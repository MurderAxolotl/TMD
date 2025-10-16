import os
import json

import dg_helpers.templates as template
import dg_helpers.util      as util

from dg_helpers.config import TEXTURE_LOCATION, OUTPUT_MODEL_DIR, MOD_ID, TEXTURE_SKIP_LIST

def getTextureList(subpath:str, append_list) -> list:
	textures = []

	for appended_texture in append_list:
		textures.append(appended_texture)

	for textureName in os.listdir(TEXTURE_LOCATION + f"/{subpath}"):
		if ".png" in textureName and textureName.split(".")[0] not in textures and textureName.split(".")[0] not in TEXTURE_SKIP_LIST:
			textures.append(textureName.split(".")[0])

	return textures

def generate_models(textureList:list, textureBasePath:str="-"):
	if textureBasePath == "-":
		textureBasePath = ""
		util.log_warn("textureBasePath was not provided, defaulting to item root. You should explicitly set textureBasePath")

	for texture in textureList:
		if not os.path.exists(f"{OUTPUT_MODEL_DIR}/{texture}.json"):
			util.log(f"Generating model for {texture}")

			imTemplate = template.itemModel
			imTemplate["textures"]["layer0"] = f"{MOD_ID}:item/{textureBasePath}{texture}"

			with open(f"{OUTPUT_MODEL_DIR}/{texture}.json", "x") as model_file:
				model_file.write(json.dumps(imTemplate))
				model_file.flush()
