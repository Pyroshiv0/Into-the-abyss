package com.pyroshiv.arsabyssaux.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import com.pyroshiv.arsabyssaux.common.block.tile.DrainlinkTile;
import java.util.Random;

public class DrainlinkBlock extends TickableModBlock{
    public DrainlinkBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        super.randomTick(state,worldIn,pos,random);
        DrainlinkTile tile = (DrainlinkTile) worldIn.getBlockEntity(pos);
        if (tile==null)
            return;
        tile.doRandomAction();
    }
}
