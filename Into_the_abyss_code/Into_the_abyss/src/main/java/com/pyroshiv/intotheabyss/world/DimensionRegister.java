package com.pyroshiv.intotheabyss.world;

import com.pyroshiv.intotheabyss.IntoTheAbyssMod; // Assurez-vous d'importer la classe principale de votre mod si votre MOD_ID est là
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.core.registries.Registries;

public class DimensionRegister {

    public static final ResourceKey<Level> THE_ABYSS_DIMENSION = ResourceKey.create(
            Registries.DIMENSION,
            new ResourceLocation(IntoTheAbyssMod.MODID, "the_abyss") // Assurez-vous que IntoTheAbyss.MOD_ID est correct
    );

    // Si vous avez d'autres dimensions customisées, déclarez-les ici aussi.

    // Méthode optionnelle pour initialiser cette classe, si vous avez des registres complexes
    public static void register() {
        // Cette méthode peut être vide ou contenir des loggers si nécessaire.
        // Son but principal est de forcer le chargement de cette classe et de ses static final fields.
    }
}
