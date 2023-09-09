package w3xyz.chronitecore;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DimensionVisualEffects;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.AbstractSittingPhase;
import net.minecraft.entity.boss.dragon.phase.SittingAttackingPhase;
import net.minecraft.entity.damage.*;
import net.minecraft.registry.Holder;
import net.minecraft.registry.Registry;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.GlobalPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;
import org.spongepowered.asm.mixin.Mixin;
import team.lodestar.lodestone.handlers.ScreenshakeHandler;
import team.lodestar.lodestone.setup.LodestoneParticles;
import team.lodestar.lodestone.setup.LodestoneRenderLayers;
import team.lodestar.lodestone.systems.rendering.particle.Easing;
import team.lodestar.lodestone.systems.rendering.particle.LodestoneWorldParticleTextureSheet;
import team.lodestar.lodestone.systems.rendering.particle.WorldParticleBuilder;
import team.lodestar.lodestone.systems.rendering.particle.data.ColorParticleData;
import team.lodestar.lodestone.systems.rendering.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.screenshake.PositionedScreenshakeInstance;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;
import w3xyz.chronitecore.block.custom.IonizedChroniteBlock;
import w3xyz.chronitecore.sound.ModSounds;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


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
		// Remove the mixin annotation and the abstract class declaration
		public class ScreenShakeEffect {

			// Make the method static and pass the position as a parameter
			public static void screenShake(Vec3d pos, int dur) {
				ScreenshakeInstance screenShake = new PositionedScreenshakeInstance(dur, pos, 20f, 0f, 25f, Easing.CIRC_IN_OUT).setIntensity(1.0f, 2.0f, 1.0f);
				ScreenshakeHandler.addScreenshake(screenShake);
			}

		}


	@Override
	public void onInitializeClient(ModContainer mod) {
		ClientPlayNetworking.registerGlobalReceiver(new Identifier(ChroniteCore.MOD_ID, "particles"), (client, handler, buf, responseSender) -> {
			GlobalPos globalPos = buf.readGlobalPos();
			long deley = buf.readLong();
			BlockPos pos = globalPos.getPos();
			RegistryKey<World> dimension = globalPos.getDimension();
			World world = client.world;
			// Get the current client world
			if (world != null && world.getRegistryKey().equals(dimension)) {
				for (int i = 0; i < 2500; i++) {
					summonSmoke(100, pos, world);
				}
				for (int i = 0; i < 599; i++) {
					summonTower(50, pos, world);
				}
				for (int i = 0; i < 599; i++) {
					summonCone(40, pos, world);
					summonDebri(100, pos, world);
				}
				for (int i = 0; i < 1000; i++) {
					smokeRing(150 - 40, 180, pos, world);
					smokeRing(130 - 40, 240, pos, world);
				}
				ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
				executorService.schedule(() -> {
					for (int i = 0; i < 9000; i++) {
						afterSmoke(100,pos, world);
						afterSmoke(100,pos, world);
						afterSmoke(100,pos, world);
					}
				}, 16, TimeUnit.SECONDS);
				PlayerEntity player = MinecraftClient.getInstance().player;

// Check if the player exists


				ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
				executor.schedule(() -> {
					ChroniteCore.LOGGER.info("now " + deley);



					int durys = 120;
					if (player != null) {
						// Get the player position
						Vec3d playerPos = player.getPos();
						// Call the screenShake() method with the player position
						ScreenShakeEffect.screenShake(playerPos, 120);
					}
				}, (long) deley, TimeUnit.SECONDS);


			}
		});
	}


	public boolean isPlayerLookingAtBlock(PlayerEntity player, BlockPos targetPos) {
		Vec3d playerLookVec = player.getRotationVec(1.0F);
		Vec3d playerPos = player.getCameraPosVec(1.0F);
		Vec3d targetVec = new Vec3d(targetPos.getX() + 0.5, targetPos.getY() + 0.5, targetPos.getZ() + 0.5);
		Vec3d directionToTarget = targetVec.subtract(playerPos).normalize();
		double dotProduct = playerLookVec.dotProduct(directionToTarget);
		double threshold = Math.cos(Math.toRadians(30));
		return dotProduct > threshold;
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
	public void afterSmoke(int maxDist, BlockPos pos, World world) {
		Color c1 = new Color(54, 54, 54, 255);
		Color c2 = new Color(38, 38, 38, 255);
		WorldParticleBuilder.create(LodestoneParticles.SMOKE_PARTICLE)
				.setColorData(ColorParticleData.create(c1, c2).build())
				.setScaleData(GenericParticleData.create(15f, 20f, 30f).build())
				.setLifetime(18000)
				.setMotion(0, 0, 0)
				.setRandomMotion(0.01)
				.setRandomOffset(200 * 2.5f)
				.setGravity(0.01f)
				.setRenderType(LodestoneWorldParticleTextureSheet.TRANSPARENT)
				.spawn(world, pos.getX(), pos.getY() + 120, pos.getZ());
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
		WorldParticleBuilder.create(LodestoneParticles.SMOKE_PARTICLE)
				.setRenderType(LodestoneWorldParticleTextureSheet.TRANSPARENT)
				.setColorData(ColorParticleData.create(c1, c2).build())
				.setScaleData(GenericParticleData.create(15f, 20f).build())
				.setLifetime(u)
				.setMotion(0, -0.002, 0)
				.setRandomOffset(5 * 2.5f)
				.setGravity(0.1f)
				.spawn(world, pos.getX() + x, pos.getY() + y, pos.getZ() + z);
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
	public void summonTower(int maxDist, BlockPos pos, World world) {
		Random cheese = new Random();
		int n = cheese.nextInt(150);
		Random lifetime = new Random();
		int u = lifetime.nextInt(351) + 400;
		Random yesno = new Random();
		double l = yesno.nextDouble();
		Color c1 = new Color(255, 179, 67, 255);
		Color c2 = new Color(119, 22, 0, 255);
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
			Color c1 = new Color(255, 179, 67, 255);
			Color c2 = new Color(119, 22, 0, 255);
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

}

