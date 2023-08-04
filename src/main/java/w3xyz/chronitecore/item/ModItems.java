package w3xyz.chronitecore.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import w3xyz.chronitecore.ChroniteCore;

public class ModItems {
	public static final Item CHRONITE = registerItem("chronite", new Item(new QuiltItemSettings()));
	public static final Item RAW_CHRONITE = registerItem("raw_chronite", new Item(new QuiltItemSettings()));





	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(ChroniteCore.MOD_ID, name), item);
	}
	public static void registerModItems() {
		ChroniteCore.LOGGER.info("Starting Mod Items for " + ChroniteCore.MOD_ID);
	}
}
