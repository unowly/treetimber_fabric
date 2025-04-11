package dev.unowly.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

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
