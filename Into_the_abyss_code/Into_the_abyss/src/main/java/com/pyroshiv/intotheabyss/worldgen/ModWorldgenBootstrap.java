package com.pyroshiv.intotheabyss.worldgen;

import com.mojang.serialization.Codec;
import com.pyroshiv.intotheabyss.IntoTheAbyssMod;
import com.pyroshiv.intotheabyss.worldgen.biomesource.AbyssBiomeSource;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.BiomeSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = IntoTheAbyssMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModWorldgenBootstrap {

    @SubscribeEvent
    public static void registerWorldgen(RegisterEvent event) {

        // ➔ Enregistrement du BiomeSource
        event.register(Registries.BIOME_SOURCE, helper -> {
            helper.register(
                    new ResourceLocation(IntoTheAbyssMod.MODID, "abyss_biome_source"),
                    AbyssBiomeSource.CODEC
            );
        });

        // ➔ (optionnel) si tu ajoutes d'autres éléments plus tard, tu peux aussi faire :
        //
        // event.register(Registries.CHUNK_GENERATOR, helper -> { ... });
        // event.register(Registries.NOISE_SETTINGS, helper -> { ... });
        // event.register(Registries.DIMENSION_TYPE, helper -> { ... });
        // event.register(Registries.BIOME, helper -> { ... });
    }
}
