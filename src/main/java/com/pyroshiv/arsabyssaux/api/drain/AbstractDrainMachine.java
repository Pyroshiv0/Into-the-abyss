package com.pyroshiv.arsabyssaux.api.drain;

import com.hollingsworth.arsnouveau.common.block.tile.ModdedTile;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractDrainMachine extends ModdedTile implements IDrainTile {

    private int drain = 0;
    private int maxDrain = 0;
    public static final String DRAIN_TAG = "drain";
    public static final String MAX_DRAIN_TAG = "max_drain";

    public AbstractDrainMachine(BlockEntityType<?> manaTile, BlockPos pos, BlockState state) {
        super(manaTile, pos, state);
    }

    @Override
    public void load(CompoundTag tag) {
        drain = tag.getInt(DRAIN_TAG);
        maxDrain = tag.getInt(MAX_DRAIN_TAG);
        super.load(tag);
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt(DRAIN_TAG, getDrain());
        tag.putInt(MAX_DRAIN_TAG, getMaxDrain());
    }

    @Override
    public int setDrain(int drain) {
        if (this.drain == drain)
            return this.drain;
        this.drain = drain;
        if (this.drain > this.getMaxDrain())
            this.drain = this.getMaxDrain();
        if (this.drain < 0)
            this.drain = 0;
        updateBlock();
        return this.drain;
    }

    @Override
    public int addDrain(int drain) {
        return this.setDrain(this.getDrain() + drain);
    }

    @Override
    public int getDrain() {
        return this.drain;
    }

    @Override
    public int removeDrain(int drain) {
        if (drain == 0)
            return this.getDrain();
        this.setDrain(this.getDrain() - drain);
        updateBlock();
        return this.getDrain();
    }

    @Override
    public void setMaxDrain(int max) {
        this.maxDrain = max;
        updateBlock();
    }

    @Override
    public int getMaxDrain() {
        return maxDrain;
    }

    public boolean canAcceptDrain() {
        return this.getDrain() < this.getMaxDrain();
    }

    public boolean canAcceptDrain(int drain) {
        return this.getDrain() + drain <= this.getMaxDrain();
    }

    /**
     * Transfers the maximum possible amount of source from one tile to another.
     * Takes the maximum transfer rate of the two tiles into account, and the space remaining.
     *
     * @return The amount of source that was transferred.
     */
    public int transferDrain(IDrainTile from, IDrainTile to) {
        int transferRate = getTransferRate(from, to);
        from.removeDrain(transferRate);
        to.addDrain(transferRate);
        return transferRate;
    }

    /**
     * Gets the maximum amount of drain that can be transferred from one tile to another.
     */
    public int getTransferRate(IDrainTile from, IDrainTile to) {
        return Math.min(Math.min(from.getTransferRate(), from.getDrain()), to.getMaxDrain() - to.getDrain());
    }

    public int transferDrain(IDrainTile from, IDrainTile to, int fromTransferRate) {
        int transferRate = getTransferRate(from, to, fromTransferRate);
        if (transferRate == 0)
            return 0;
        from.removeDrain(transferRate);
        to.addDrain(transferRate);
        return transferRate;
    }

    public int getTransferRate(IDrainTile from, IDrainTile to, int fromTransferRate) {
        return Math.min(Math.min(fromTransferRate, from.getDrain()), to.getMaxDrain() - to.getDrain());
    }
}


