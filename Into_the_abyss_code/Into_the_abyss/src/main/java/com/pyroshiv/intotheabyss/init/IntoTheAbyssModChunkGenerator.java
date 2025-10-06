package com.pyroshiv.intotheabyss.init;

import com.mojang.serialization.Codec;
import com.pyroshiv.intotheabyss.IntoTheAbyssMod;
import com.pyroshiv.intotheabyss.worldgen.ChunkGenerators.AbyssChunkGenerator;
import com.pyroshiv.intotheabyss.worldgen.biomesource.AbyssBiomeSource;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.RegisterEvent;

import static com.pyroshiv.intotheabyss.IntoTheAbyssMod.MODID;

public class IntoTheAbyssModChunkGenerator {
    public static final DeferredRegister<Codec<? extends ChunkGenerator>> REGISTRY = DeferredRegister.create(BuiltInRegistries.CHUNK_GENERATOR, MODID);

    public static final DeferredHolder<Codec<? extends ChunkGenerator>, Codec<? extends ChunkGenerator>> ABYSS_CHUNK_GENERATOR =
            REGISTRY.register("abyss_chunk_generator", () -> AbyssChunkGenerator.CODEC);

    public static final ResourceKey<Codec<? extends ChunkGenerator>> ABYSS_CHUNK_GENERATOR_KEY =
            ResourceKey.create(Registries.CHUNK_GENERATOR, new ResourceLocation(MODID, "abyss_chunk_generator"));

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class GenInit {
        @SubscribeEvent
        public static void onRegister(RegisterEvent event) {
            // rien à faire ici normalement, les fichiers JSON suffisent
        }
    }
}
