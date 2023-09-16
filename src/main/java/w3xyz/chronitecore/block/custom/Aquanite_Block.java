package w3xyz.chronitecore.block.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;


public class Aquanite_Block extends Block {
	public Aquanite_Block(Settings settings) {
		super(settings);
	}


	public boolean canSuffocate(BlockState state, BlockView world, BlockPos pos) {
		return true;
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.INVISIBLE;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return VoxelShapes.empty();
	}
	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		// Call the super method to ensure the block is added correctly
		super.onBlockAdded(state, world, pos, oldState, notify);

		// Check if the block is on fire
		if (world.getBlockState(pos.up()).getBlock() == Blocks.FIRE) {
			// Create a new explosion at the position of the block
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4f, true, World.ExplosionSourceType.BLOCK);

		}
	}


}
