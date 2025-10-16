import os
import sys
import json
import argparse

import dg_helpers.templates as template
import dg_helpers.util      as util
import dg_helpers.io        as io

from dg_helpers.config import OUTPUT_TAG_DIR, MOD_ID

## STOP EDITING HERE ##
parser = argparse.ArgumentParser()
parser.add_argument("-b", "--build_with", nargs='+', default=[]) # NOTE THAT THIS IS SPECIFICALLY FOR MUSIC DISCS
parser.add_argument("-i", "--item_list", nargs='+', default=[]) # THIS IS THE GENERIC ALTERNATIVE. I'M AN IDIOT
parser.add_argument("-f", "--regen", action='store_true')

arguments = parser.parse_args()

USER_APPENDED_TEXTURES = arguments.item_list
USER_APPENDED_TEXTURES_DISCS = arguments.build_with

REGEN_TAGS = arguments.regen

# Get texture lists
TEXTURES_GENERIC = io.getTextureList("", USER_APPENDED_TEXTURES)
TEXTURES_DISCS   = io.getTextureList("/discs", USER_APPENDED_TEXTURES_DISCS)

# We actually run datagen down here
# Generate models
io.generate_models(TEXTURES_GENERIC, "")
io.generate_models(TEXTURES_DISCS,   "discs/")

# Now we make sure every item is added to the music disc json
md_tag = {"replace": False, "values": []}

for texture in TEXTURES_DISCS:
    md_tag["values"].append(f"{MOD_ID}:{texture}")

with open(f"{OUTPUT_TAG_DIR}/music_discs.json", "w") as disc_tag_file:
    disc_tag_file.truncate(0)
    disc_tag_file.write(json.dumps(md_tag))

    util.log("Updated disc tag")

print("")
