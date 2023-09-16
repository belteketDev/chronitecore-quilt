package w3xyz.chronitecore.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
/*
public class GasPackingStationBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

	protected final PropertyDelegate propertyDelegate;
	private int progress = 0;
	private int maxProgress = 72;

	public GasPackingStationBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.GAS_PACKING_STATION, pos, state);
		this.propertyDelegate = new PropertyDelegate() {
			public int get(int index) {
				switch (index) {
					case 0: return GasPackingStationBlockEntity.this.progress;
					case 1: return GasPackingStationBlockEntity.this.maxProgress;
					default: return 0;
				}
			}

			public void set(int index, int value) {
				switch(index) {
					case 0: GasPackingStationBlockEntity.this.progress = value; break;
					case 1: GasPackingStationBlockEntity.this.maxProgress = value; break;
				}
			}

			public int size() {
				return 2;
			}
		};
	}

	@Override
	public Text getDisplayName() {
		return Text.literal("Gas Packing Station");
	}

	@Nullable
	@Override
	public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
		return ;
	}

	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, inventory);
		nbt.putInt("gas_packaging_station.progress", progress);
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		Inventories.readNbt(nbt, inventory);
		super.readNbt(nbt);
		progress = nbt.getInt("gas_packaging_station.progress");
	}

	@Override
	public DefaultedList<ItemStack> getItems() {
		return this.inventory;
	}

	public static void tick(World world, BlockPos pos, BlockState state, GasPackingStationBlockEntity entity) {
		if (world.isClient()) {
			return;
		}
		if (hasRecipe(entity)){
			entity.progress++;
			markDirty(world, pos, state);
			if (entity.progress >= entity.maxProgress){
				craftItem(entity);
			}else {
				entity.resetProgress();
				markDirty(world, pos, state);
			}
		}


	}

	private static boolean hasRecipe(GasPackingStationBlockEntity entity) {
		boolean
	}
}
 */

