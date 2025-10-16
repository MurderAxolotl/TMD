package io.theo.tmd;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.intellij.lang.annotations.Identifier;

public class ModSounds {
    // Functions used above
    public static SoundEvent registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(TMD.mod_id, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createFixedRangeEvent(id, 32));
    }
}
