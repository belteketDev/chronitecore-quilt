package w3xyz.chronitecore.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import w3xyz.chronitecore.item.ModItems;

@Mixin(WanderingTraderEntity.class)
public abstract class WanderingTraderMixin extends MerchantEntity {
	public WanderingTraderMixin(EntityType<? extends MerchantEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "fillRecipes", at = @At("RETURN"))
	private void addCustomTrade(CallbackInfo ci) {
		// Generate a random number between 0 and 1
		double rand = Math.random();

		// Add the custom trade with a 33% chance
		if (rand < 0.33) {
			// Add a custom trade that sells 1 diamond for 10 emeralds
			this.getOffers().add(new TradeOffer(new ItemStack(Items.EMERALD, 24), new ItemStack(ModItems.ION_DUST), 1, 0, 0.05F));
		}
	}
}

