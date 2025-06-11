
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package com.pyroshiv.intotheabyss.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import com.pyroshiv.intotheabyss.fluid.types.SulfuricWaterFluidType;
import com.pyroshiv.intotheabyss.IntoTheAbyssMod;

public class IntoTheAbyssModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, IntoTheAbyssMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> SULFURIC_WATER_TYPE = REGISTRY.register("sulfuric_water", () -> new SulfuricWaterFluidType());
}
