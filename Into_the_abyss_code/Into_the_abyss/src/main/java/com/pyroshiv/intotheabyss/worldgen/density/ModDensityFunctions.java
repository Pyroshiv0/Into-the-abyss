package com.pyroshiv.intotheabyss.worldgen.density;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.serialization.JsonOps;
import com.pyroshiv.intotheabyss.IntoTheAbyssMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

import com.mojang.serialization.Codec;

import static com.pyroshiv.intotheabyss.IntoTheAbyssMod.LOGGER;

@Mod.EventBusSubscriber(modid = IntoTheAbyssMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDensityFunctions {

    @SubscribeEvent
    public static void registerDensityFunctions(RegisterEvent event) {

        event.register(Registries.DENSITY_FUNCTION_TYPE, helper -> {
            helper.register(
                    new ResourceLocation(IntoTheAbyssMod.MODID, "island_shape"),
                    IslandShapeDensityFunction.CODEC.codec()
            );
        });
    }
}