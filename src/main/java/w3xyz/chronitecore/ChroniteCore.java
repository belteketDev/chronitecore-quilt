package w3xyz.chronitecore;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import w3xyz.chronitecore.block.ModBlocks;
import w3xyz.chronitecore.item.ModItemGroups;
import w3xyz.chronitecore.item.ModItems;

public class ChroniteCore implements ModInitializer {

	public static final String MOD_ID = "chronitecore";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override

	public void onInitialize(ModContainer mod) {

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());

	}
}
