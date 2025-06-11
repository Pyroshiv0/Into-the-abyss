
package com.pyroshiv.intotheabyss.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import com.pyroshiv.intotheabyss.procedures.SulfuricWaterMobplayerCollidesBlockProcedure;
import com.pyroshiv.intotheabyss.init.IntoTheAbyssModFluids;

public class SulfuricWaterBlock extends LiquidBlock {
	public SulfuricWaterBlock() {
		super(() -> IntoTheAbyssModFluids.SULFURIC_WATER.get(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 2)
				.noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		SulfuricWaterMobplayerCollidesBlockProcedure.execute(entity);
	}
}
