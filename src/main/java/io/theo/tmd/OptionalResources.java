package io.theo.tmd;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class OptionalResources {
    public static void registerBuiltinPack(String id) {
        if (TMD.verbose) {
            TMD.logger.info("Registering resource pack {}", id);
        }

        ModContainer mod = FabricLoader.getInstance().getModContainer(TMD.mod_id).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(
                new ResourceLocation(TMD.mod_id, id),
                mod,
                Component.literal("Classic Discs"),
                ResourcePackActivationType.NORMAL);
    }

    public static void init() {
        registerBuiltinPack("tmd_classic");
    }
}
