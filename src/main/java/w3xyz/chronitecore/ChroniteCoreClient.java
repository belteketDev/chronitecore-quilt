package w3xyz.chronitecore;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;


public class ChroniteCoreClient implements ClientModInitializer {

		/*Color fuckMyEyes = new Color(255, 89, 55);
		Color fuckMyEyesMore= new Color(255, 223, 138);
		ScreenParticleBuilder.create(new LodestoneScreenParticleType(),
						new HashMap<LodestoneScreenParticleTextureSheet, ArrayList<ScreenParticle>>())
				.setColorData(ColorParticleData.create(fuckMyEyesMore, fuckMyEyes).build())
				.setScaleData(GenericParticleData.create(1f).build())
				.setLifetime(20)
				.setGravity(0)
				.setRandomMotion(0)
				.addMotion(0, 0)
				.setRandomOffset(0.5)
				.spawn(1, 1);*/


	@Override
	public void onInitializeClient(ModContainer mod) {
	}public boolean isPlayerLookingAtBlock(PlayerEntity player, BlockPos targetPos) {
		Vec3d playerLookVec = player.getRotationVec(1.0F);
		Vec3d playerPos = player.getCameraPosVec(1.0F);
		Vec3d targetVec = new Vec3d(targetPos.getX() + 0.5, targetPos.getY() + 0.5, targetPos.getZ() + 0.5);
		Vec3d directionToTarget = targetVec.subtract(playerPos).normalize();
		double dotProduct = playerLookVec.dotProduct(directionToTarget);
		double threshold = Math.cos(Math.toRadians(30));
		return dotProduct > threshold;
	}


}

