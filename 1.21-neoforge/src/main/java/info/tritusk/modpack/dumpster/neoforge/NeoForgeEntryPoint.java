package info.tritusk.modpack.dumpster.neoforge;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.List;

@Mod("dumpster")
public class NeoForgeEntryPoint {

    public NeoForgeEntryPoint(IEventBus bus) {
        bus.register(NeoForgeEntryPoint.class);
    }

    public static Block dumpsterBlock;

    @SubscribeEvent
    public static void reg(RegisterEvent event) {
        if (!Registries.BLOCK.equals(event.getRegistryKey())) {
            return;
        }

        dumpsterBlock = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath("dumpster", "dumpster"),
                new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)) {
                    @Override
                    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean byPiston) {
                        super.onPlace(state, level, pos, oldState, byPiston);
                        level.invalidateCapabilities(pos);
                    }

                    @Override
                    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean byPiston) {
                        super.onRemove(state, level, pos, oldState, byPiston);
                        level.invalidateCapabilities(pos);
                    }
                });

        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath("dumpster", "dumpster"),
                new BlockItem(dumpsterBlock, new Item.Properties()) {
                    @Override
                    public void appendHoverText(ItemStack item, TooltipContext context, List<Component> tooltips, TooltipFlag flag) {
                        super.appendHoverText(item, context, tooltips, flag);
                        tooltips.add(Component.translatable("block.dumpster.dumpster.tooltip.1"));
                        tooltips.add(Component.translatable("block.dumpster.dumpster.tooltip.2"));
                    }
                });
    }

    @SubscribeEvent
    public static void attachCap(RegisterCapabilitiesEvent event) {
        event.registerBlock(Capabilities.ItemHandler.BLOCK, (level, pos, state, be, side) -> VoidingItemHandler.INSTANCE, dumpsterBlock);
        event.registerBlock(Capabilities.FluidHandler.BLOCK, (level, pos, state, be, side) -> VoidingFluidHandler.INSTANCE, dumpsterBlock);
        event.registerBlock(Capabilities.EnergyStorage.BLOCK, (level, pos, state, be, side) -> VoidingEnergyHandler.INSTANCE, dumpsterBlock);
    }
}
