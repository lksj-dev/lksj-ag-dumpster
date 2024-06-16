package info.tritusk.modpack.dumpster.forge;

import com.mojang.datafixers.DSL;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod("dumpster")
@Mod.EventBusSubscriber(modid = "dumpster", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeEntryPoint {

    static Block dumpsterBlock;

    @SubscribeEvent
    public static void reg(RegisterEvent event) {
        if (Registries.BLOCK.isFor(event.getRegistryKey())) {
            dumpsterBlock = Registry.register(event.getVanillaRegistry(), ResourceLocation.fromNamespaceAndPath("dumpster", "dumpster"),
                    new DumpsterBlockForgeVer(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)));
        } else if (Registries.BLOCK_ENTITY_TYPE.isFor(event.getRegistryKey())) {
            DumpsterBlockForgeVer.Logic.type = Registry.register(event.getVanillaRegistry(), ResourceLocation.fromNamespaceAndPath("dumpster", "dumpster"),
                    BlockEntityType.Builder.of(DumpsterBlockForgeVer.Logic::new, dumpsterBlock).build(DSL.remainderType()));
        }
    }

}
