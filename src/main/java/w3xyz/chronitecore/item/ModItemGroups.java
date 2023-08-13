package w3xyz.chronitecore.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import w3xyz.chronitecore.ChroniteCore;
import w3xyz.chronitecore.block.ModBlocks;

public class ModItemGroups {

	public static final ItemGroup CHRONITE_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(ChroniteCore.MOD_ID, "chronite"),
			FabricItemGroup.builder().name(Text.translatable("itemgroup.chronite")).icon(() -> new ItemStack(ModItems.CHRONITE)).entries(((displayParameters, itemStackCollector) -> {
				itemStackCollector.addItem(ModItems.CHRONITE);
				itemStackCollector.addItem(ModItems.RAW_CHRONITE);
				itemStackCollector.addItem(ModBlocks.IONIZED_CHRONITE_BLOCK);
				itemStackCollector.addItem(ModBlocks.RAW_CHRONITE_BLOCK);
				itemStackCollector.addItem(ModBlocks.DEEPSLATE_CHRONITE_ORE);
				itemStackCollector.addItem(ModBlocks.CHRONITE_BLOCK);
				itemStackCollector.addItem(ModItems.ION_DUST);
				itemStackCollector.addItem(ModItems.ION_SHARD);
			})).build());

	public static void registerItemGroups() {
		ChroniteCore.LOGGER.info("registering item groups for" + ChroniteCore.MOD_ID);
	}
}
