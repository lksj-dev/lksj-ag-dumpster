package info.tritusk.dumpster;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.BlockView;
import java.util.List;

final class Dumpster extends Block implements BlockEntityProvider {

    Dumpster(Settings settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void buildTooltip(ItemStack item, BlockView blockView, List<Component> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableComponent("block.dumpster.dumpster.tooltip.1"));
        tooltip.add(new TranslatableComponent("block.dumpster.dumpster.tooltip.2"));
        tooltip.add(new TranslatableComponent("block.dumpster.dumpster.tooltip.3"));
    }

    @Override
    public boolean hasBlockEntity() {
        return true;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new Logic();
    }

    static final class Logic extends BlockEntity implements Inventory { // TODO (3TUSK): uh should we add liquid support???

        static final BlockEntityType<Logic> TYPE_TOKEN = BlockEntityType.Builder.create(Logic::new).build(null);

        Logic() {
            super(TYPE_TOKEN);
        }

        @Override
        public int getInvSize() {
            return 1;
        }

        @Override
        public boolean isInvEmpty() {
            return true; // Always.
        }

        @Override
        public ItemStack getInvStack(int index) {
            return ItemStack.EMPTY;
        }

        @Override
        public ItemStack takeInvStack(int index, int takeCount) {
            return ItemStack.EMPTY;
        }

        @Override
        public ItemStack removeInvStack(int index) {
            return ItemStack.EMPTY;
        }

        @Override
        public void setInvStack(int index, ItemStack item) {
            // No-op, because we eat everything
        }

        @Override
        public boolean canPlayerUseInv(PlayerEntity player) {
            return true;
        }

        @Override
        public void clear() {
            // No-op
        }
    }
}
