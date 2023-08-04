package w3xyz.chronitecore;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;
import team.lodestar.lodestone.setup.LodestoneScreenParticles;
import team.lodestar.lodestone.systems.rendering.particle.Easing;
import team.lodestar.lodestone.systems.rendering.particle.ScreenParticleBuilder;
import team.lodestar.lodestone.systems.rendering.particle.data.ColorParticleData;
import team.lodestar.lodestone.systems.rendering.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.rendering.particle.screen.LodestoneScreenParticleTextureSheet;
import team.lodestar.lodestone.systems.rendering.particle.screen.ScreenParticleType;
import team.lodestar.lodestone.systems.rendering.particle.screen.base.ScreenParticle;
import team.lodestar.lodestone.systems.rendering.particle.type.LodestoneScreenParticleType;
import team.lodestar.lodestone.systems.screenshake.PositionedScreenshakeInstance;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class ChroniteCoreClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		/*Identifier id = new Identifier("chronitecore", "flash");
		ClientPlayNetworking.registerGlobalReceiver(id, (client, handler, buf, responseSender) -> {

			Vec3d cameraPos = getCameraPosition(client);
			Color fuckMyEyes = new Color(255, 89, 55);
			Color fuckMyEyesMore= new Color(255, 223, 138);
			ScreenParticleBuilder.create()
					.setColorData(ColorParticleData.create(fuckMyEyesMore, fuckMyEyes).build())
					.setScaleData(GenericParticleData.create(1f).build())
					.setLifetime(20)
					.setGravity(0)
					.setRandomMotion(0)
					.addMotion(0, 0)
					.setRandomOffset(0.5)
					.spawn(1, 1);

		});*/
	}
	public Vec3d getCameraPosition(MinecraftClient client) {
		GameRenderer renderer = client.gameRenderer;
		return renderer.getCamera().getPos();
	}

}

