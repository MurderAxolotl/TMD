package io.theo.tmd;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.intellij.lang.annotations.Identifier;

public class CraftingParts {

    public static void init() {
        // Crafting components
        registerGenericItem(new Item(new FabricItemSettings().stacksTo(1)), "blank_disc"); // A complete, blank disc
        registerGenericItem(new Item(new FabricItemSettings().stacksTo(64)), "disc_caddy"); // Base disc, no data
        registerGenericItem(new Item(new FabricItemSettings().stacksTo(64)), "disc_data_layer"); // Data-storing component
        registerGenericItem(new Item(new FabricItemSettings().stacksTo(16)), "remnant"); // oooo afton jizz
    }

    public static void registerGenericItem(Item item, String id) {
        if (TMD.verbose) {
            TMD.logger.info("Registering item {}", id);
        }

        Registry.register( BuiltInRegistries.ITEM, new ResourceLocation(TMD.mod_id, id), item );
    }
}
