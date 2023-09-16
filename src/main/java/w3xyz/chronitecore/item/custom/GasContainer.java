package w3xyz.chronitecore.item.custom;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.player.PlayerEntity;

import java.util.List;

public class GasContainer extends Item {
	public GasContainer(Settings settings) {
		super(settings);
	}

	public void addItem(ItemStack stack, Item item) {
		NbtCompound tag = stack.getOrCreateNbt();
		String itemName = item.getTranslationKey();
		int itemCount = tag.getInt(itemName);
		int totalItems = getTotalItems(tag);
		if (totalItems < 50) {
			itemCount++;
			tag.putInt(itemName, itemCount);
		}
	}

	private int getTotalItems(NbtCompound tag) {
		int totalItems = 0;
		for (String key : tag.getKeys()) {
			totalItems += tag.getInt(key);
		}
		return totalItems;
	}


	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);

		if (!world.isClient) {
			addItem(stack, Items.IRON_INGOT);
		}

		return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		NbtCompound tag = stack.getOrCreateNbt();
		int totalItems = 0;
		for (String key : tag.getKeys()) {
			int count = tag.getInt(key);
			totalItems += count;
			String translatedKey = Text.translatable(key).getString();
			tooltip.add(Text.of("Contains " + count*2 + "% of " + translatedKey));
		}
		int empty = 50 - totalItems;
		tooltip.add(Text.of(empty + " slots empty"));
	}


}
