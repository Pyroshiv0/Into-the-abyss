package com.pyroshiv.arsabyssaux.common.block.tile;

import com.hollingsworth.arsnouveau.api.client.ITooltipProvider;
import com.hollingsworth.arsnouveau.api.source.AbstractSourceMachine;
import com.hollingsworth.arsnouveau.common.block.ITickable;
import com.pyroshiv.arsabyssaux.api.drain.AbstractDrainMachine;
import com.pyroshiv.arsabyssaux.api.drain.IDrainTile;
import com.pyroshiv.arsabyssaux.common.block.CorrupterBlock;
import com.pyroshiv.arsabyssaux.common.block.CorruptingEnum;
import com.pyroshiv.arsabyssaux.setup.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.io.Console;
import java.util.List;
import java.util.logging.Logger;

import static com.pyroshiv.arsabyssaux.common.util.BlockUtils.getBlockByName;
import static com.pyroshiv.arsabyssaux.common.util.BlockUtils.getBlockName;

public class CorrupterTile extends AbstractDrainMachine implements ITooltipProvider, ITickable {

    private CorruptingEnum corruptingEnum;
    public boolean draining;

    public CorrupterTile(BlockPos pos, BlockState state) {
        super(BlockRegistry.CORRUPTER_TILE.get(), pos, state);
    }

    @Override
    public void tick(Level level, BlockState state, BlockPos pos){

        if (level==null) return;System.out.println("passed");
        if (level.getGameTime() % 100 == 0) {
            int maxReach=draining? 1 : 2;
            for (int x=-maxReach; x<maxReach; x++) {
                for (int y=-maxReach; y<maxReach; y++) {
                    for (int z=-maxReach; z<maxReach; z++) {
                        BlockPos npos = new BlockPos((int) (pos.getX()+x), (int) (pos.getY()+y), (int) (pos.getZ()+z));
                        BlockState blockState= level.getBlockState(npos);
                        String result = corruptingEnum.getBlockToConvert(getBlockName(blockState.getBlock()));

                        if (result != null) {
                            level.setBlockAndUpdate(pos, getBlockByName(result).defaultBlockState());
                        }
                    }
                }
            }
        }
    }
    public int getMaxDrainHold(){
        return 1000;
    }

    @Override
    public void getTooltip(List<Component> list) {

    }

    @Override
    public int getTransferRate() {
        return getMaxDrainHold();
    }
}
