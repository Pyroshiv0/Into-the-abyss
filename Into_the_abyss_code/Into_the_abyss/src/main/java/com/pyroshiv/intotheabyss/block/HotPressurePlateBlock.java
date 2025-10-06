
package com.pyroshiv.intotheabyss.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class HotPressurePlateBlock extends PressurePlateBlock {
	public HotPressurePlateBlock() {
		super(BlockSetType.IRON, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.5f, 10f).requiresCorrectToolForDrops().noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false).dynamicShape().forceSolidOn());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}
