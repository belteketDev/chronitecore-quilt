package w3xyz.chronitecore.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import w3xyz.chronitecore.ChroniteCore;

public class ModSounds {

	public static SoundEvent SHOCKWAVE = registerSoundEvent("shockwave");

	private static SoundEvent registerSoundEvent(String name){
		Identifier id = new Identifier(ChroniteCore.MOD_ID, name);
		return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
	}
}
