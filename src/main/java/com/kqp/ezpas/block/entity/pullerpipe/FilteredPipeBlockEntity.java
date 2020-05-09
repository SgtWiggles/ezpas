package com.kqp.ezpas.block.entity.pullerpipe;

import com.kqp.ezpas.block.FilteredPipeBlock;
import com.kqp.ezpas.block.container.FilteredPipeContainer;
import com.kqp.ezpas.init.Ezpas;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.DefaultedList;

public class FilteredPipeBlockEntity extends LootableContainerBlockEntity {
    public DefaultedList<ItemStack> inventory;

    public FilteredPipeBlockEntity() {
        super(Ezpas.FILTERED_PIPE_BLOCK_ENTITY);

        this.inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    }

    @Override
    public int getInvSize() {
        return 9;
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container.filtered_pipe");
    }

    @Override
    protected Container createContainer(int syncId, PlayerInventory playerInventory) {
        return new FilteredPipeContainer(syncId, playerInventory, this,
                getFilterType());
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);

        this.inventory = DefaultedList.ofSize(this.getInvSize(), ItemStack.EMPTY);

        if (!this.deserializeLootTable(tag)) {
            Inventories.fromTag(tag, this.inventory);
        }
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        if (!this.serializeLootTable(tag)) {
            Inventories.toTag(tag, this.inventory);
        }

        return tag;
    }

    private FilteredPipeBlock.Type getFilterType() {
        return ((FilteredPipeBlock) this.world.getBlockState(this.pos).getBlock()).type;
    }
}
