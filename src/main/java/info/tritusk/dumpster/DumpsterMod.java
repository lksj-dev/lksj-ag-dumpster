package info.tritusk.dumpster;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@GameRegistry.ObjectHolder("dumpster")
@Mod(modid = "dumpster", name = "Dumpster", version = "@INJECT_VERSION@", useMetadata = true, acceptedMinecraftVersions = "[1.12.2]")
@Mod.EventBusSubscriber(modid = "dumpster")
public final class DumpsterMod {

    @GameRegistry.ObjectHolder("dumpster")
    public static Block DUMPSTER;
    @GameRegistry.ObjectHolder("dumpster")
    public static Item DUMPSTER_ITEM;

    @SubscribeEvent
    public static void block(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Dumpster().setCreativeTab(CreativeTabs.MISC).setTranslationKey("dumpster.dumpster").setRegistryName("dumpster:dumpster"));
        GameRegistry.registerTileEntity(Dumpster.Logic.class, new ResourceLocation("dumpster", "dumpster"));
    }

    @SubscribeEvent
    public static void item(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(DUMPSTER).setRegistryName("dumpster:dumpster"));
    }

    @Mod.EventBusSubscriber(modid = "dumpster", value = Side.CLIENT)
    public static final class ModelStuff {
        @SubscribeEvent
        public static void model(ModelRegistryEvent event) {
            ModelLoader.setCustomModelResourceLocation(DUMPSTER_ITEM, 0, new ModelResourceLocation(new ResourceLocation("dumpster", "dumpster"), "normal"));
        }
    }

}
