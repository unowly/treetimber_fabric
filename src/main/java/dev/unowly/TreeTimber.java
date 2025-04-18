package dev.unowly;

import dev.unowly.command.TimberCommand;
import dev.unowly.event.BlockBreakHandler;
import dev.unowly.event.PlayerJoinHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TreeTimber implements ModInitializer {
	public static final String MOD_ID = "treetimber";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Identifier TIMBER_STATUS_PACKET = Identifier.of(MOD_ID, "timber_status");

	private final Set<Identifier> woodBlockIds = new HashSet<>();
	private final ConcurrentHashMap<UUID, Boolean> timberEnabled = new ConcurrentHashMap<>();

	@Override
	public void onInitialize() {
		LOGGER.info("TreeTimber 1.21.5 initializing...");

		Registries.BLOCK.forEach(block -> {
			Identifier identifier = Registries.BLOCK.getId(block);
			if(identifier.getPath().endsWith("_log") || identifier.getPath().endsWith("_wood") || identifier.getPath().endsWith("_stem")) {
				woodBlockIds.add(identifier);
			}
		});

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			new TimberCommand(timberEnabled).register(dispatcher);
		});

		PlayerBlockBreakEvents.BEFORE.register(new BlockBreakHandler(timberEnabled, woodBlockIds)::onBlockBreak);
		ServerPlayConnectionEvents.JOIN.register(new PlayerJoinHandler(timberEnabled));

		ServerPlayNetworking.registerGlobalReceiver(TIMBER_STATUS_PACKET, (handler, buf, responseSender) -> {
			boolean isActive = buf.readBoolean();
			MinecraftServer server = handler.getServer();
			if (server != null) {
				server.execute(() -> TreeTimberClient.setTimberActive(isActive));
				LOGGER.info("Timber-Status vom Server empfangen und an Client weitergegeben: " + isActive + " für " + handler.getPlayer().getName().getString());
			}
		});

		// Spieler Join Event registrieren (sendet initialen Status)
		ServerPlayConnectionEvents.JOIN.register(new PlayerJoinHandler(timberEnabled, this::syncTimberStatus));
		LOGGER.info("PlayerJoinHandler registriert.");
	}

	public void syncTimberStatus(ServerPlayerEntity player) {
		boolean isActive = timberEnabled.getOrDefault(player.getUuid(), false);
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeBoolean(isActive);
		ServerPlayNetworking.send(player, TIMBER_STATUS_PACKET, buf);
		LOGGER.info("Timber-Status für " + player.getName().getString() + " synchronisiert: " + isActive);
	}
}