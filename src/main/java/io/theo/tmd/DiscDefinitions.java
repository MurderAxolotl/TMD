package io.theo.tmd;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

import java.util.ArrayList;
import java.util.HashMap;

import static io.theo.tmd.ModSounds.registerSoundEvent;
import static io.theo.tmd.TabDefinitions.*;

public class DiscDefinitions {
    public static final HashMap<String, Item> ITEM_LIST = new HashMap<>();

    // These lists define which tab groups stuff gets added to
    public static final ArrayList<String> ALBUM_DEFAULT = new ArrayList<>();
    public static final ArrayList<String> ALBUM_BBNOS = new ArrayList<>();
    public static final ArrayList<String> ALBUM_FNAF = new ArrayList<>();
    public static final ArrayList<String> ALBUM_KIT = new ArrayList<>();
    public static final ArrayList<String> ALBUM_ONESHOT = new ArrayList<>();

    // All disc lengths get put in this hashmap for simplicity
    public static final HashMap<String, Integer> MUSIC_DISC_LENGTHS = new HashMap<>();

    public static void init() {
        // Register default discs
        makeNewDisc("and_so_we_fall", 160, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("aria_math", 267, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("bernadette", 322, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("brain_implosion_energy", 112, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("butcher_vanity", 187, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("diggy_diggy_hole", 315, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("dreams_of_homeland", 63, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("fading_memories", 90, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("gasoline", 199, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("hanachirusato", 94, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("hear_me_out", 220, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("honestly", 217, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("joyride", 150, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("kamado_tanjirou_no_uta", 328, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("lagtrain", 251, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("minimum_rage", 202, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("of_solitude_past_and_present", 239, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("rainbow_cradlesong", 101, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("rex_incognito", 278, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("shining_in_the_depths", 162, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("siren", 242, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("surasthana_fantasia", 141, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("telephone", 220, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("tetoris", 142, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("two_phut_hon", 183, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("war_without_reason", 408, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("winding_through_avydia", 128, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("wriothesley_theme", 127, ALBUM_DEFAULT, DEFAULT_GROUP);

        // BBNO$
        makeNewDisc("bbnos_antidepressants", 118, ALBUM_BBNOS, BBNOS_GROUP);
        makeNewDisc("bbnos_boom", 163, ALBUM_BBNOS, BBNOS_GROUP);
        makeNewDisc("bbnos_edamame", 135, ALBUM_BBNOS, BBNOS_GROUP);
        makeNewDisc("bbnos_meant_to_be", 170, ALBUM_BBNOS, BBNOS_GROUP);
        makeNewDisc("bbnos_one_eight_hundred", 207, ALBUM_BBNOS, BBNOS_GROUP);
        makeNewDisc("bbnos_two", 135, ALBUM_BBNOS, BBNOS_GROUP);

        // FNaF
        makeNewDisc("aftershow", 233, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("afton_family", 204, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("daddys_little_monsters", 218, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("die_in_a_fire", 185, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("dream_your_dream", 240, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("follow_you", 194, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("for_you", 180, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("our_little_horror_story", 285, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("shadow_bonnie", 170, ALBUM_FNAF, FNAF_GROUP);
        makeNewDisc("sweet_dreams", 322, ALBUM_DEFAULT, FNAF_GROUP);

        // Kit
        // Adopted into the Default album list
        makeNewDisc("mushrooms", 76, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("resurrections", 578, ALBUM_DEFAULT, DEFAULT_GROUP);
//        makeNewDisc("uwa_temperate", 56, ALBUM_KIT, KIT_GROUP);

        // Oneshot
        makeNewDisc("on_little_cat_feet", 913, ALBUM_ONESHOT, ONESHOT_GROUP);
        makeNewDisc("phosphor", 201, ALBUM_ONESHOT, ONESHOT_GROUP);
        makeNewDisc("someplace_i_know", 178, ALBUM_ONESHOT, ONESHOT_GROUP);
//        makeNewDisc("the_prophecy", 838, ALBUM_ONESHOT, ONESHOT_GROUP);

        // SharaX
        // Adopted into the Default album list
        makeNewDisc("graveyard_kitten", 300, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("heartache", 285, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("its_raining_somewhere_else", 320, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("sound_of_winter", 307, ALBUM_DEFAULT, DEFAULT_GROUP);
        makeNewDisc("spider_dance", 328, ALBUM_DEFAULT, DEFAULT_GROUP);

    }

    private static void makeNewDisc(String name, Integer length, ArrayList<String> album, ResourceKey<CreativeModeTab> group) {
        album.add(name);
        MUSIC_DISC_LENGTHS.put(name, length);

        if (TMD.verbose) {
            TMD.logger.info("Registering disc {} ({}s)", name, length);
        }

        registerItem(name, group);
    }

    public static void registerItem(String name, ResourceKey<CreativeModeTab> group) {
        // Register the sound
        SoundEvent soundEvent = registerSoundEvent(name);

        // Create the item
        RecordItem item = Registry.register(
                BuiltInRegistries.ITEM,
                new ResourceLocation(TMD.mod_id, name),
                new RecordItem(
                        1,
                        soundEvent,
                        new Item.Properties().rarity(Rarity.RARE).stacksTo(1),
                        MUSIC_DISC_LENGTHS.get(name)));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.accept(item));
        ITEM_LIST.put(name, item);
    }
}
