package com.pyroshiv.intotheabyss.player;

import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.minecraft.world.entity.player.Player;

public class PlayerPressureHandler {

    // Constantes physiques
    private static final double DENSITY_OF_AIR = 1.0; // kg/m^3 (densité moyenne de l'air pour la pression "terrestre")
    private static final double GRAVITY = 9.81;            // m/s^2

    // Couche Y à partir de laquelle la pression commence
    private static final int PRESSURE_START_Y = 50;

    // Dernière pression calculée (en Pascals)
    private static double lastCalculatedPressure = 0.0;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        // Exécuter côté serveur à la fin du tick
        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide()) {
            Player player = event.player;

            // Position Y des yeux du joueur
            double playerEyeY = player.getEyeY();

            // Calcul de la profondeur sous la couche de départ (Y=50)
            // Si le joueur est à Y=40, profondeur = 50 - 40 = 10
            // Si le joueur est à Y=60, profondeur = 0
            double depth = Math.max(0, PRESSURE_START_Y - playerEyeY);

            // Calcul de la pression (P = rho * g * h)
            double currentPressure = DENSITY_OF_AIR * GRAVITY * depth;

            // Mise à jour de la dernière pression
            lastCalculatedPressure = currentPressure;

            // Affichage de la pression dans la barre d'action
            if (depth > 0) {
                double pressure_Pa = currentPressure ; // En Pa
                player.displayClientMessage(Component.literal(String.format("Pression : %.2f Pa", pressure_Pa)), true);
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
