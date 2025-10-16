package io.theo.tmd;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static io.theo.tmd.DiscDefinitions.ITEM_LIST;
import static io.theo.tmd.TMD.mod_id;

public class TabDefinitions {
    public static final ResourceKey<CreativeModeTab> DEFAULT_GROUP = registerResourceKey("music_disc_group");
    public static final ResourceKey<CreativeModeTab> BBNOS_GROUP = registerResourceKey("music_disc_group_bbnos");
    public static final ResourceKey<CreativeModeTab> FNAF_GROUP = registerResourceKey("music_disc_group_fnaf");
    public static final ResourceKey<CreativeModeTab> KIT_GROUP = registerResourceKey("music_disc_group_kit");
    public static final ResourceKey<CreativeModeTab> ONESHOT_GROUP = registerResourceKey("music_disc_group_oneshot");

    public static void init() {
        registerGroup(DEFAULT_GROUP, "itemGroup.discs", "and_so_we_fall");
        registerGroup(BBNOS_GROUP, "itemGroup.discs.bbnos", "bbnos_meant_to_be");
        registerGroup(FNAF_GROUP, "itemGroup.discs.fnaf", "shadow_bonnie");
//        registerGroup(KIT_GROUP, "itemGroup.discs.kit", "mushrooms");
        registerGroup(ONESHOT_GROUP, "itemGroup.discs.oneshot", "on_little_cat_feet");
    }

    private static ResourceKey<CreativeModeTab> registerResourceKey(String group_id) {
        return ResourceKey.create(
                BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                new ResourceLocation(mod_id, group_id)
        );
    }

    private static void registerGroup(ResourceKey<CreativeModeTab> group, String translation, String displayDisc) {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, group, FabricItemGroup.builder()
                .title(Component.translatable(translation))
                .icon(() -> new ItemStack(ITEM_LIST.get(displayDisc)))
                .build());

        if (TMD.verbose) {
            TMD.logger.info("Registering item group {}", group.toString());
        }
    }

}
