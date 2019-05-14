package info.tritusk.dumpster;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class DumpsterMod implements ModInitializer {

    @Override
    public void onInitialize() {
        final Identifier id = new Identifier("dumpster", "dumpster");

        Dumpster block = Registry.register(Registry.BLOCK, id, new Dumpster(Block.Settings.of(Material.GLASS, MaterialColor.BLACK)));

        Registry.register(Registry.BLOCK_ENTITY, id, Dumpster.Logic.TYPE_TOKEN);

        Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().itemGroup(ItemGroup.MISC)));
    }

}
