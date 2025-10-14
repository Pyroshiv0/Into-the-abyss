package com.pyroshiv.intotheabyss.player;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.SubscribeEvent;
import com.pyroshiv.intotheabyss.world.dimension.TheAbyssDimension;
import net.neoforged.neoforge.event.TickEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import com.pyroshiv.intotheabyss.item.MeasureItem;
import com.pyroshiv.intotheabyss.world.DimensionRegister;

public class PlayerPressureHandler {

    // Constantes physiques
    private static final double DENSITY_OF_AIR = 1.293;    // kg/m^3
    private static final double DENSITY_OF_WATER = 999.975; // kg/m^3
    private static final double GRAVITY = 9.81;            // m/s^2

    // Couche Y à partir de laquelle la pression commence
    private static final int PRESSURE_START_Y = 50;

    private static final ResourceKey<Level> TARGET_DIMENSION = DimensionRegister.THE_ABYSS_DIMENSION;


    // Dernière pression calculée (en Pascals)
    private static double lastCalculatedPressure = 0.0;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        // Exécuter côté serveur à la fin du tick
        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide()){
            Player player = event.player;
            Level level = player.level(); // Récupérer le monde du joueur

            // Vérification de la dimension
            if (!level.dimension().equals(TARGET_DIMENSION)) {
                player.displayClientMessage(Component.literal(""), true);
                lastCalculatedPressure = 0.0;
                return;
            }

            // Vérifier si le joueur tient le MeasureItem
            boolean holdingMeasureItem = player.getMainHandItem().getItem() instanceof MeasureItem ||
                    player.getOffhandItem().getItem() instanceof MeasureItem;

            // Si le joueur ne tient pas le MeasureItem, réinitialiser l'affichage et arrêter
            if (!holdingMeasureItem) {
                player.displayClientMessage(Component.literal(""), true);
                lastCalculatedPressure = 0.0;
                return;
            }

            // Position Y des yeux du joueur
            double playerEyeY = player.getEyeY();

            // Calcul de la profondeur sous la couche de départ (Y=50)
            double depth = Math.max(0, PRESSURE_START_Y - playerEyeY);

            // Variable pour stocker la pression calculée localement
            double currentPressure = 0.0;

            // Vérifier si le joueur est dans l'eau
            // On vérifie le bloc où se trouve les pieds du joueur pour le fluide
            BlockPos playerFeetPos = player.blockPosition();
            FluidState fluidStateAtFeet = level.getFluidState(playerFeetPos);

            if (fluidStateAtFeet.getType() == Fluids.WATER) {
                // Calcul de la pression (P = rho * g * h)
                currentPressure = DENSITY_OF_WATER * GRAVITY * depth;

            } else {
                currentPressure = DENSITY_OF_AIR * GRAVITY * depth;
            }

            // Mise à jour de la dernière pression
            lastCalculatedPressure = currentPressure;

            // Affichage de la pression dans la barre d'action
            if (depth > 0) { // N'afficher que s'il y a une profondeur de pression
                double pressure_kPa = currentPressure / 1000.0; // Conversion en kPa pour l'affichage
                player.displayClientMessage(Component.literal(String.format("Pression : %.2f kPa", pressure_kPa)), true);
            } else {
                player.displayClientMessage(Component.literal(""), true); // Effacer si pas de pression
            }
        }
    }

    /**
     * Méthode pour obtenir la dernière pression calculée.
     * @return La dernière pression calculée en Pascals (Pa).
     */
    public static double getLastCalculatedPressure() {
        return lastCalculatedPressure;
    }
}
