package dev.unowly;

import dev.unowly.command.TimberCommand;
import dev.unowly.event.BlockBreakHandler;
import dev.unowly.event.PlayerJoinHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.registry.Registries;
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
	}
}