package com.pyroshiv.arsabyssaux.common.block.tile;

import com.hollingsworth.arsnouveau.client.particle.ParticleUtil;
import com.pyroshiv.arsabyssaux.api.drain.AbstractDrainMachine;
import com.pyroshiv.arsabyssaux.common.block.ITickableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;

import java.util.List;

public class DrainlinkTile extends AbstractDrainMachine implements GeoBlockEntity, ITickableBlock {

    int progress ;
    public boolean isDisabled = false;
    public boolean registered= false;

    public DrainlinkTile(BlockEntityType<?> drainlinkTile, BlockPos pos, BlockState state) {
        super(drainlinkTile, pos, state);
    }

    @Override
    public void tick(){
        if (level.isClientSide()) return;
        if (level.getGameTime() % 120 == 0 && usesEventQueue()) {
            DrainlinkEventQueue.addPosition(level, this.worldPosition);
            registered true;
        }

        if (level.getGameTime() % 100 == 0 && getDrain() > 0) {
            List<ISpecialDrainProvider> providers = DrainUtil.canGiveDrain(worldPosition,level,5);
            if (!providers.isEmpty()) {
                transferDrain(this,providers.getFist().getDrain());
                ParticleUtil.spawnFollowProjectile(level, this.worldPosition,providers.getFirst().getCurrent(),this.getColor());
            }
        }
    }
}
