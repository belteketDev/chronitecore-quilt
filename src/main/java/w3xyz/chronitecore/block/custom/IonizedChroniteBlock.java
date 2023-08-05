package w3xyz.chronitecore.block.custom;

import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;
import team.lodestar.lodestone.setup.LodestoneParticles;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import team.lodestar.lodestone.systems.rendering.particle.LodestoneWorldParticleTextureSheet;
import team.lodestar.lodestone.systems.rendering.particle.WorldParticleBuilder;
import team.lodestar.lodestone.systems.rendering.particle.data.ColorParticleData;
import team.lodestar.lodestone.systems.rendering.particle.data.GenericParticleData;
import w3xyz.chronitecore.ChroniteCore;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;


public class IonizedChroniteBlock extends Block {
	Random random = new Random();

	public IonizedChroniteBlock(Settings settings) {
		super(settings);
	}

	private static final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);

	@Override
	public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
		for (int i = 0; i < 2500; i++) {
			summonSmoke(100, pos, world);
		}
		for (int i = 0; i < 599; i++) {
			summonTower(50, pos, world);
		}




		Entity entity = explosion.getCausingEntity();
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entity;
			BlockPos targetPos = pos;
			if (isPlayerLookingAtBlock(player, targetPos)) {
				ChroniteCore.LOGGER.info("looking");

			}
		}


		world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 200.0F, World.ExplosionSourceType.BLOCK);
		createAirSphere(world, pos, 20);
		for (int i = 0; i < 599; i++) {
			summonCone(40, pos, world);
			summonDebri(100, pos, world);
		}
		for (int i = 0; i < 1000; i++) {
			smokeRing(150-40,180, pos, world);
			smokeRing(130-40,240, pos, world);}


	}





	public void sendCustomPacket(ServerPlayerEntity player, Identifier channel) {
		PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
		// You can write any data you want to send to the client here
		ServerPlayNetworking.send(player, channel, data);
	}



	public void summonSmoke(int maxDist, BlockPos pos, World world) {
		Random rand = new Random();
		int y = rand.nextInt(50);
		double angle = rand.nextDouble() * 2 * Math.PI;
		double radius = maxDist * Math.sqrt(rand.nextDouble());
		int x = (int) (radius * Math.cos(angle));
		int z = (int) (radius * Math.sin(angle));
		Random lifetime = new Random();
		int u = lifetime.nextInt(351) + 400;
		Color c1 = new Color(255, 186, 67, 255);
		Color c2 = new Color(255, 52, 0, 255);
		WorldParticleBuilder.create(LodestoneParticles.SMOKE_PARTICLE)
				.setColorData(ColorParticleData.create(c1, c2).build())
				.setScaleData(GenericParticleData.create(15f, 20f).build())
				.setLifetime(u)
				.setMotion(0, 0, 0)
				.setRandomMotion(0.01)
				.setRandomOffset(5 * 2.5f)
				.setGravity(1/5)
				.spawn(world, pos.getX() + x, pos.getY() + 150 + y, pos.getZ() + z);
	}
	public void summonDebri(int maxDist, BlockPos pos, World world) {
		Random rand = new Random();
		int y = rand.nextInt(20);
		double angle = rand.nextDouble() * 2 * Math.PI;
		double radius = maxDist * Math.sqrt(rand.nextDouble());
		int x = (int) (radius * Math.cos(angle));
		int z = (int) (radius * Math.sin(angle));
		Random lifetime = new Random();
		int u = lifetime.nextInt(351) + 400;
		Color c1 = new Color(103, 57, 26, 255);
		Color c2 = new Color(54, 43, 36, 255);
		Color c3 = new Color(37, 32, 29, 255);
		WorldParticleBuilder.create(LodestoneParticles.SMOKE_PARTICLE)
				.setRenderType(LodestoneWorldParticleTextureSheet.TRANSPARENT)
				.setColorData(ColorParticleData.create(c1, c2).build())
				.setScaleData(GenericParticleData.create(15f, 20f).build())
				.setLifetime(u)
				.setMotion(0, -0.002, 0)
				.setRandomOffset(5 * 2.5f)
				.setGravity(0)
				.spawn(world, pos.getX() + x, pos.getY() + y, pos.getZ() + z);
	}

	public void flash(World world, BlockPos pos){
		Color fuckMyEyes = new Color(255, 89, 55);
		Color fuckMyEyesMore= new Color(255, 223, 138);


	}
	public void smokeRing(int radius, int y, BlockPos pos, World world){
		Random rand = new Random();
		int u = rand.nextInt(351) + 400;
		double angle = rand.nextDouble() * 2 * Math.PI;
		int x = (int) (radius * Math.cos(angle));
		int z = (int) (radius * Math.sin(angle));
		double speed = 0.002; // adjust this value to control the speed of the particle
		Color c1 = new Color(255, 255, 255);
		WorldParticleBuilder.create(LodestoneParticles.SMOKE_PARTICLE)
				.setColorData(ColorParticleData.create(c1, c1).build())
				.setLifetime(u)
				.setScaleData(GenericParticleData.create(5f, 20f, 1f).build())
				.setMotion(-x * -speed, 0, -z * -speed)
				.setRenderType(LodestoneWorldParticleTextureSheet.TRANSPARENT)
				.spawn(world, pos.getX() + x, pos.getY() + y, pos.getZ() + z);
	}


	public void summonDust(int maxDist, BlockPos pos, World world) {
		Color c1 = new Color(0, 0, 0, 156);
		Color c2 = new Color(0, 0, 0, 13);
		WorldParticleBuilder.create(LodestoneParticles.SMOKE_PARTICLE)
				.setColorData(ColorParticleData.create(c1, c2).build())
				.setScaleData(GenericParticleData.create(15f, 20f).build())
				.setLifetime(18000)
				.setMotion(0, 0, 0)
				.setRandomOffset(maxDist * 2.5f)
				.setGravity(1)
				.spawn(world, pos.getX(), pos.getY() + 5, pos.getZ());
	}
	public void summonTower(int maxDist, BlockPos pos, World world) {
		Random cheese = new Random();
		int n = cheese.nextInt(150);
		Random lifetime = new Random();
		int u = lifetime.nextInt(351) + 400;
		Random yesno = new Random();
		double l = yesno.nextDouble();
			Color c1 = new Color(103, 57, 26, 255);
			Color c2 = new Color(54, 43, 36, 255);
			WorldParticleBuilder.create(LodestoneParticles.SMOKE_PARTICLE)
					.setColorData(ColorParticleData.create(c1, c2).build())
					.setRenderType(LodestoneWorldParticleTextureSheet.LUMITRANSPARENT)
					.setScaleData(GenericParticleData.create(0f,15f, 30f).build())
					.setLifetime(u)
					.setMotion(0, 0.090, 0)
					.setRandomOffset(2 * 2.5f)
					.setGravity(1/5)
					.spawn(world, pos.getX(), pos.getY() + n, pos.getZ());
		}





	public void summonCone(int rad, BlockPos pos, World world){
		Random rand = new Random();
		int n = rand.nextInt(100);
		int u = rand.nextInt(351) + 400;

		Random yesno = new Random();
		double l = yesno.nextDouble();

			for (int y = 0; y < n; y++) {
				Color c1 = new Color(103, 57, 26, 255);
				Color c2 = new Color(54, 43, 36, 255);
				double angle = rand.nextDouble() * 2 * Math.PI;
				int x = (int) (rad * (n - y) / n * Math.cos(angle));
				int z = (int) (rad * (n - y) / n * Math.sin(angle));
				WorldParticleBuilder.create(LodestoneParticles.SMOKE_PARTICLE)
						.setColorData(ColorParticleData.create(c1, c2).build())
						.setRenderType(LodestoneWorldParticleTextureSheet.LUMITRANSPARENT)
						.setScaleData(GenericParticleData.create(0f, 15f, 30f).build())
						.setLifetime(u)
						.setMotion(0, 0.090, 0)
						.setRandomOffset(2 * 2.5f)
						.setGravity(1 / 5)
						.spawn(world, pos.getX() + x, pos.getY() + y, pos.getZ() + z);
			}

	}

	public void createAirSphere(World world, BlockPos center, int radius) {
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					if (x * x + y * y + z * z <= radius * radius) {
						BlockPos pos = center.add(x, y, z);
						if (world.getBlockState(pos).getBlock() != Blocks.BEDROCK) {
							world.setBlockState(pos, Blocks.AIR.getDefaultState());

						}
					}
				}
			}
		}
	}
	public boolean isPlayerLookingAtBlock(PlayerEntity player, BlockPos targetPos) {
		Vec3d playerLookVec = player.getRotationVec(1.0F);
		Vec3d playerPos = player.getCameraPosVec(1.0F);
		Vec3d targetVec = new Vec3d(targetPos.getX() + 0.5, targetPos.getY() + 0.5, targetPos.getZ() + 0.5);
		Vec3d directionToTarget = targetVec.subtract(playerPos).normalize();
		double dotProduct = playerLookVec.dotProduct(directionToTarget);
		double threshold = Math.cos(Math.toRadians(30)); // 30 degree threshold
		return dotProduct > threshold;
	}

}
