
package com.pyroshiv.intotheabyss.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import com.pyroshiv.intotheabyss.init.IntoTheAbyssModItems;
import com.pyroshiv.intotheabyss.init.IntoTheAbyssModFluids;
import com.pyroshiv.intotheabyss.init.IntoTheAbyssModFluidTypes;
import com.pyroshiv.intotheabyss.init.IntoTheAbyssModBlocks;

public abstract class SulfuricWaterFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> IntoTheAbyssModFluidTypes.SULFURIC_WATER_TYPE.get(), () -> IntoTheAbyssModFluids.SULFURIC_WATER.get(),
			() -> IntoTheAbyssModFluids.FLOWING_SULFURIC_WATER.get()).explosionResistance(100f).tickRate(6).slopeFindDistance(3).bucket(() -> IntoTheAbyssModItems.SULFURIC_WATER_BUCKET.get())
			.block(() -> (LiquidBlock) IntoTheAbyssModBlocks.SULFURIC_WATER.get());

	private SulfuricWaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.FALLING_WATER;
	}

	public static class Source extends SulfuricWaterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SulfuricWaterFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
