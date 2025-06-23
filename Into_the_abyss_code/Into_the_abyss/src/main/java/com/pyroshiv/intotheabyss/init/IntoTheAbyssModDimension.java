package com.pyroshiv.intotheabyss.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;

public class IntoTheAbyssModDimension {
    public static final DeferredRegister<DimensionType> REGISTRY =
        DeferredRegister.create(Registries.DIMENSION_TYPE, "into_the_abyss");
    public static final ResourceKey<DimensionType> THE_ABYSS_KEY =
            ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation("into_the_abyss", "the_abyss"));


    public static final ResourceKey<Level> THE_ABYSS_DIM =
            ResourceKey.create(Registries.DIMENSION, new ResourceLocation("into_the_abyss", "the_abyss"));


    @Mod.EventBusSubscriber(modid = "into_the_abyss", bus = Mod.EventBusSubscriber.Bus.MOD)
    public class DimensionInit {
        @SubscribeEvent
        public static void onRegister(RegisterEvent event) {
            // rien à faire ici normalement, les fichiers JSON suffisent
        }
    }


}
