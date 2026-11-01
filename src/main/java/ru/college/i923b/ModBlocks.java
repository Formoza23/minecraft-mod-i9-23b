package ru.college.i923b;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static Block registerBlock(String name) {
        Identifier id = Identifier.of(CrystalLight.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        Block block = new Block(
                AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                        .registryKey(key)
                        .strength(3.0f, 6.0f)
                        .luminance(state -> 8)
        );

        return Registry.register(Registries.BLOCK, key, block);
    }

    public static Item registerBlockItem(Block block, String name) {
        Identifier id = Identifier.of(CrystalLight.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        Item item = new BlockItem(
                block,
                new Item.Settings()
                        .registryKey(key)
                        .useBlockPrefixedTranslationKey()
        );

        return Registry.register(Registries.ITEM, key, item);
    }

    public static final Block GLOWING_CRYSTAL =
            registerBlock("glowing_crystal");

    public static final Item GLOWING_CRYSTAL_ITEM =
            registerBlockItem(GLOWING_CRYSTAL, "glowing_crystal");

    public static void initialize() {
    }
}
