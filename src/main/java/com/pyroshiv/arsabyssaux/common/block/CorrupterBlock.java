package com.pyroshiv.arsabyssaux.common.block;

import com.pyroshiv.arsabyssaux.common.block.tile.CorrupterTile;
import com.pyroshiv.arsabyssaux.common.lib.LibBlockNames;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CorrupterBlock extends DrainBlock{
    //public static final VoxelShape shape;
    public CorrupterBlock() {
        super(TickableModBlock.defaultProperties().noOcclusion(), LibBlockNames.CORRUPTER_BLOCK);
    }

    public CorrupterBlock(Properties properties) {
        super(properties,LibBlockNames.CORRUPTER_BLOCK);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CorrupterTile(pos, state);
    }

    /*@Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shape;
    }*/
}
