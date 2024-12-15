package com.pyroshiv.arsabyssaux.common.block.tile;

import com.hollingsworth.arsnouveau.api.client.ITooltipProvider;
import com.hollingsworth.arsnouveau.common.block.ITickable;
import com.pyroshiv.arsabyssaux.api.drain.AbstractDrainMachine;
import com.pyroshiv.arsabyssaux.common.block.DrainJar;
import com.pyroshiv.arsabyssaux.setup.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class DrainJarTile extends AbstractDrainMachine implements ITooltipProvider, ITickable {

    public DrainJarTile(BlockPos pos, BlockState state) {
        super(BlockRegistry.DRAIN_JAR_TILE.get(), pos, state);
    }

    public DrainJarTile(BlockEntityType<? extends com.pyroshiv.arsabyssaux.common.block.tile.DrainJarTile> tileTileEntityType, BlockPos pos, BlockState state) {
        super(tileTileEntityType, pos, state);
    }

    @Override
    public int getMaxDrain() {
        return 10000;
    }

    @Override
    public boolean updateBlock() {
        super.updateBlock();
        BlockState state = level.getBlockState(worldPosition);
        int fillState = 0;
        if (this.getDrain() > 0 && this.getDrain() < 1000)
            fillState = 1;
        else if (this.getDrain() != 0) {
            fillState = (this.getDrain() / 1000) + 1;
        }
        if (state.hasProperty(DrainJar.fill))
            level.setBlock(worldPosition, state.setValue(DrainJar.fill, fillState), 3);
        return true;
    }

    @Override
    public int getTransferRate() {
        return getMaxDrain();
    }

    @Override
    public void getTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("ars_abyssaux.drain_jar.fullness", (getDrain() * 100) / this.getMaxDrain()));
    }
}