package info.tritusk.modpack.dumpster.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

public class FabricEntryPoint implements ModInitializer {
    @Override
    public void onInitialize() {
        Block theBlock = new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK));

        Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath("dumpster.json", "dumpster.json"), theBlock);

        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath("dumpster", "dumpster"),
                new BlockItem(theBlock, new Item.Properties()) {
                    @Override
                    public void appendHoverText(ItemStack item, TooltipContext context, List<Component> tooltips, TooltipFlag flag) {
                        super.appendHoverText(item, context, tooltips, flag);
                        tooltips.add(Component.translatable("block.dumpster.dumpster.tooltip.1"));
                        tooltips.add(Component.translatable("block.dumpster.dumpster.tooltip.2"));
                    }
                });

        ItemStorage.SIDED.registerForBlocks((level, pos, state, be, direction) -> VoidingItemStorage.INSTANCE, theBlock);
        FluidStorage.SIDED.registerForBlocks((level, pos, state, be, direction) -> VoidingFluidStorage.INSTANCE, theBlock);
    }
}
