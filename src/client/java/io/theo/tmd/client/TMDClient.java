package io.theo.tmd.client;

import io.theo.tmd.OptionalResources;
import net.fabricmc.api.ClientModInitializer;

public class TMDClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        OptionalResources.init();
    }
}
