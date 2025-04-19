package dev.unowly.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.unowly.networking.packet.TimberModeS2CPayload;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.Map;
import java.util.UUID;

public class TimberCommand {

    private final Map<UUID, Boolean> timberEnabled;

    public TimberCommand(Map<UUID, Boolean> timberEnabled) {
        this.timberEnabled = timberEnabled;
    }

    public void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("timber")
                .executes(context -> {
                    if (context.getSource().getEntity() instanceof ServerPlayerEntity player) {
                        UUID playerId = player.getUuid();
                        boolean isEnabled = timberEnabled.getOrDefault(playerId, false);
                        timberEnabled.put(playerId, !isEnabled);
                        World world = player.getEntityWorld();
                        if(world.isClient()){
                            return 1;
                        }

                        TimberModeS2CPayload payload = new TimberModeS2CPayload(isEnabled);
                        for (ServerPlayerEntity serverPlayer : PlayerLookup.world((ServerWorld) world)) {
                            ServerPlayNetworking.send(serverPlayer, payload);
                        }
                        player.sendMessage(
                                Text.literal("Tree").formatted(Formatting.GREEN).append(Text.literal("Timber").formatted(Formatting.DARK_GREEN))
                                        .append(Text.literal(" is now "))
                                        .append(Text.literal(isEnabled ? "deactivated" : "activated").formatted(isEnabled ? Formatting.YELLOW : Formatting.RED))
                                        .append(Text.literal(".")),
                                false
                        );
                        return 1;
                    } else {
                        context.getSource().sendError(Text.literal("Dieser Befehl kann nur von Spielern ausgeführt werden."));
                        return 0;
                    }
                })
        );
    }
}
