package net.kqp.ezpas.block.pullerpipe;

import net.kqp.ezpas.block.entity.pullerpipe.IronPullerPipeBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class IronPullerPipeBlock extends PullerPipeBlock {
    public IronPullerPipeBlock() {
        super();
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new IronPullerPipeBlockEntity();
    }
}
