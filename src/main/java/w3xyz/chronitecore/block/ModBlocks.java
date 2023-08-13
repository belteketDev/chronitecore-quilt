package w3xyz.chronitecore.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.int_provider.UniformIntProvider;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import w3xyz.chronitecore.ChroniteCore;
import w3xyz.chronitecore.block.custom.IonizedChroniteBlock;

public class ModBlocks {


    public static final Block RAW_CHRONITE_BLOCK = registerBlock("raw_chronite_block",
            new Block(QuiltBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.CALCITE)));
    public static final Block IONIZED_CHRONITE_BLOCK = registerBlock("ionized_chronite_block",
            new IonizedChroniteBlock(QuiltBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.CALCITE)));
	public static final Block CHRONITE_BLOCK = registerBlock("chronite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block DEEPSLATE_CHRONITE_ORE = registerBlock("deepslate_chronite_ore",
            new ExperienceDroppingBlock(QuiltBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).strength(5f), UniformIntProvider.create(2,5)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return  Registry.register(Registries.BLOCK, new Identifier(ChroniteCore.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ChroniteCore.MOD_ID, name),
                new BlockItem(block, new QuiltItemSettings()));
    }
    public static void registerModBlocks() {
        ChroniteCore.LOGGER.info("Registering Blocks for" + ChroniteCore.MOD_ID);
    }
}
