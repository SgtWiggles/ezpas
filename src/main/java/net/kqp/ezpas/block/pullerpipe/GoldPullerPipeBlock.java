package net.kqp.ezpas.block.pullerpipe;

import net.kqp.ezpas.block.entity.pullerpipe.GoldPullerPipeBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class GoldPullerPipeBlock extends PullerPipeBlock {
    public GoldPullerPipeBlock() {
        super();
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new GoldPullerPipeBlockEntity();
    }
}
