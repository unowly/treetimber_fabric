package dev.unowly;

import dev.unowly.event.KeyInputHandler;
import dev.unowly.networking.PayloadHandler;
import dev.unowly.networking.packet.TimberModeS2CPayload;
import dev.unowly.render.TimberStateHudRendering;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.util.Identifier;


public class TreeTimberClient implements ClientModInitializer {
	private static final Identifier TIMBER_MODE = Identifier.of(TreeTimber.MOD_ID, "tree_timber_hud_layer");
	private static boolean timberEnabled = false;

	@Override
	public void onInitializeClient() {
		PayloadTypeRegistry.playS2C().register(TimberModeS2CPayload.ID, TimberModeS2CPayload.CODEC);
		PayloadHandler.register();

		KeyInputHandler.register();

		HudLayerRegistrationCallback.EVENT.register(layeredDrawer
				-> layeredDrawer.attachLayerBefore(IdentifiedLayer.CHAT, TIMBER_MODE, TimberStateHudRendering::render));
	}

	public static void setTimberEnabled(boolean enabled) {
		timberEnabled = enabled;
	}

	public static boolean isTimberEnabled() {
		return timberEnabled;
	}
}
