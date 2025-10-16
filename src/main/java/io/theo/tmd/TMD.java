package io.theo.tmd;

// Notes for myself because I damn well know I'll forget
// Datagen is based on AVAILABLE TEXTURES!
// ^ this can be bypassed by running "python src/dev/datagen.py --build_with" with a list of disc names:
// ^ " python src/dev/datagen.py --build_with joyride my_disc super_cool_disc_2 "

// TODO
// -> Crafting stuff (I REALLY don't want to do this lol)
// -> Add FOB discs? (meh)
// -> Linkin Park? (...)

// Normalize commands, in case my ass forgets:
// ffmpeg-normalize * -t -12 -of ../normalized
// for i in *.mkv; do ffmpeg -i "$i" -ac 1 "../converted/${i%.*}.ogg"; done

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TMD implements ModInitializer {
    // Configuration
    public static String  mod_id = "theos_discs";
    public static boolean verbose = true;

    public static final Logger logger = LoggerFactory.getLogger(mod_id);

    @Override
    public void onInitialize() {
        logger.info("Prepare for trouble...");

        if (verbose) {
            logger.warn("...and make it double (verbose logging is enabled)");
        }

        DiscDefinitions.init();
        CraftingParts.init();
        TabDefinitions.init();
    }
}
