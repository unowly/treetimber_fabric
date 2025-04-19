package dev.unowly.networking;

import dev.unowly.networking.packet.TimberModeS2CPayload;
import dev.unowly.render.TimberStateHudRendering;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.world.ClientWorld;

public class PayloadHandler {
    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(TimberModeS2CPayload.ID, (payload, context) ->{
            ClientWorld world = context.client().world;

            if(world == null){
                return;
            }

            Boolean enabled = payload.enabled();
            TimberStateHudRendering.timberActive = enabled;
        });
    }
}
