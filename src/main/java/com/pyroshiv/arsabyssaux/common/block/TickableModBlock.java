package com.pyroshiv.arsabyssaux.common.block;


import com.hollingsworth.arsnouveau.common.block.ModBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;


public abstract class TickableModBlock extends ModBlock implements ITickableBlock {
    public TickableModBlock() {
        this(defaultProperties());
    }

    public TickableModBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
}
