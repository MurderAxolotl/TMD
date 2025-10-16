import os
import mutagen
import argparse

from dg_helpers.config import PATH, MOD_ID, RESOURCE_LOCATION

parser = argparse.ArgumentParser()
parser.add_argument("-p", "--path")
parser.add_argument("-g", "--group")

args = parser.parse_args()

APPEND_PATH = args.path + "/" if args.path is not None else ""
fg = args.group

if fg is not None:
	FORCE_GROUP = fg.upper()
	GN = f"{FORCE_GROUP}_GROUP"

else:
	FORCE_GROUP = fg
	GN = "DEFAULT_GROUP"

AUDIO_FILE_DIR = f"{RESOURCE_LOCATION}/assets/theos_discs/sounds/{APPEND_PATH}"
GROUP_REGISTER_NAME = "ALBUM_DEFAULT" if FORCE_GROUP is None else f"ALBUM_{FORCE_GROUP}"

fUr = os.listdir(AUDIO_FILE_DIR)
fUr.sort()

for file in fUr:
    fp = f"{AUDIO_FILE_DIR}/{file}"

    if os.path.isfile(fp):
        audio = mutagen.File(fp)
        info  = audio.info
        leng  = int(info.length)

        # print(f"{file} == " + str(leng))
        print(f"makeNewDisc(\"{file.split(".")[0]}\", {leng}, {GROUP_REGISTER_NAME}, {GN});")
