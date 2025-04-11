package dev.unowly.event;


import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.Map;
import java.util.UUID;

public class PlayerJoinHandler implements  net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents.Join{

    private final Map<UUID, Boolean> timberEnabled;

    public PlayerJoinHandler(Map<UUID, Boolean> timberEnabled) {
        this.timberEnabled = timberEnabled;
    }

    @Override
    public void onPlayReady(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server) {
        ServerPlayerEntity player = handler.getPlayer();
        timberEnabled.put(player.getUuid(), false);
    }
}
