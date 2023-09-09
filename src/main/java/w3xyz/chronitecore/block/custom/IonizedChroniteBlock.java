package w3xyz.chronitecore.block.custom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.AbstractSittingPhase;
import net.minecraft.entity.boss.dragon.phase.SittingAttackingPhase;
import net.minecraft.entity.damage.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Holder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.GlobalPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.qsl.lifecycle.api.event.ServerTickEvents;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.lodestar.lodestone.handlers.ScreenshakeHandler;
import team.lodestar.lodestone.systems.rendering.particle.Easing;
import team.lodestar.lodestone.systems.screenshake.PositionedScreenshakeInstance;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;
import w3xyz.chronitecore.ChroniteCore;
import w3xyz.chronitecore.block.ModBlocks;
import w3xyz.chronitecore.sound.ModSounds;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import net.minecraft.block.Block;
import java.util.concurrent.*;








public class IonizedChroniteBlock extends Block {

	public IonizedChroniteBlock(Settings settings) {
		super(settings);

	}









	@Override

	public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
		Entity entity = explosion.getCausingEntity();
		if (entity != null) {
			BlockPos targetPos = pos;
			entity.getPos();
			BlockPos blockPos = pos;
			Vec3d blockVec = new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
			Vec3d entityVec = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
			double distanceSq = blockVec.squaredDistanceTo(entityVec);
			double distance = Math.sqrt(distanceSq);
			double delay = distance / 100;
			ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
			executor.schedule(() -> {
				ChroniteCore.LOGGER.info("now " + delay);
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					player.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE,
							SoundCategory.HOSTILE,
							22f,
							-1f);


				}
				if (distance < 300) {
					String messageId = "generic";
					DamageScalingType scaling = DamageScalingType.WHEN_CAUSED_BY_LIVING_NON_PLAYER;
					float exhaustion = 0.0f;
					DamageEffects effects = DamageEffects.HURT;
					DeathMessageType deathMessageType = DeathMessageType.DEFAULT;
					DamageType damageType = new DamageType(messageId, scaling, exhaustion, effects, deathMessageType);
					Holder<DamageType> damageTypeHolder = Holder.createDirect(damageType);
					DamageSource damageSource = new DamageSource(damageTypeHolder);

					entity.damage(damageSource, 200);

				} else if (distance < 600) {
					entity.addVelocity(0, 5, 0);
					Vec3d direction = entityVec.subtract(blockVec).normalize();
					entity.addVelocity(direction.x * 12, direction.y * 12, direction.z * 12);
				} else {

				}
			}, (long) delay, TimeUnit.SECONDS);






			ChroniteCore.LOGGER.info("cheese" + delay);
			//if (isPlayerLookingAtBlock(player, targetPos)) {ChroniteCore.LOGGER.info("looking");}

			MinecraftServer server = world.getServer();
			List<ServerPlayerEntity> players = server.getPlayerManager().getPlayerList();
			for (ServerPlayerEntity playeer : players) {
			sendPacket(ChroniteCore.MOD_ID, "particles", playeer, pos, world, (long) delay);}

			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 200.0F, World.ExplosionSourceType.BLOCK);
			createAirSphere(world, pos, 20);


		}
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.schedule(() -> {
			int radius = 500; // The radius
			int duration = 40; // The duration of the effect in ticks (15 minutes = 18000 ticks)

			for (Entity entity1 : world.getEntitiesByClass(Entity.class, new Box(pos).expand(radius), entity1 -> true)) {
				if (entity1.squaredDistanceTo(pos.getX(), pos.getY(), pos.getZ()) <= radius * radius) {
					if (entity1 instanceof LivingEntity) {
						LivingEntity livingEntity = (LivingEntity) entity1;
						ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
						Runnable task = new Runnable() {
							@Override
							public void run() {
								livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, duration));
							}
						};
						executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

						executor.schedule(new Runnable() {
							@Override
							public void run() {
								executor.shutdown();
							}
						}, 15, TimeUnit.MINUTES);
					}
				}
			}




		}, 16, TimeUnit.SECONDS);
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
	public void sendPacket(String modid, String packetname, ServerPlayerEntity player, BlockPos pos, World world, long deley) {
		Identifier id = new Identifier(modid, packetname);

		PacketByteBuf buf = PacketByteBufs.create();
		RegistryKey<World> dimension = world.getRegistryKey();
		GlobalPos globalPos = GlobalPos.create(dimension, pos);
		buf.writeGlobalPos(globalPos);
		buf.writeLong(deley); // write the delay value to the buffer
		ServerPlayNetworking.send(player, id, buf);
	}







}
