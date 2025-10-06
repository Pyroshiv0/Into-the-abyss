package com.pyroshiv.intotheabyss.init;

import com.mojang.serialization.Codec;
import com.pyroshiv.intotheabyss.worldgen.ChunkGenerators.AbyssChunkGenerator;
import com.pyroshiv.intotheabyss.worldgen.biomesource.AbyssBiomeSource;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;

import static com.pyroshiv.intotheabyss.IntoTheAbyssMod.MODID;

public class IntoTheAbyssModBiomeSource {
    public static final DeferredRegister<Codec <? extends BiomeSource>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BIOME_SOURCE, MODID);

    public static final DeferredHolder<Codec<? extends BiomeSource>, Codec<? extends BiomeSource>> ABYSS_CHUNK_GENERATOR =
            REGISTRY.register("abyss_biome_source", () -> AbyssBiomeSource.CODEC);

    public static final ResourceKey<Codec<? extends BiomeSource>> ABYSS_CHUNK_GENERATOR_KEY =
            ResourceKey.create(Registries.BIOME_SOURCE, new ResourceLocation(MODID, "abyss_biome_source"));

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class GenInit {
        @SubscribeEvent
        public static void onRegister(RegisterEvent event) {
            // rien à faire ici normalement, les fichiers JSON suffisent
        }
    }
}
