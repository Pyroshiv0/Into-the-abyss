
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package com.pyroshiv.intotheabyss.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import com.pyroshiv.intotheabyss.fluid.SulfuricWaterFluid;
import com.pyroshiv.intotheabyss.IntoTheAbyssMod;

public class IntoTheAbyssModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, IntoTheAbyssMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> SULFURIC_WATER = REGISTRY.register("sulfuric_water", () -> new SulfuricWaterFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_SULFURIC_WATER = REGISTRY.register("flowing_sulfuric_water", () -> new SulfuricWaterFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(SULFURIC_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_SULFURIC_WATER.get(), RenderType.translucent());
		}
	}
}
