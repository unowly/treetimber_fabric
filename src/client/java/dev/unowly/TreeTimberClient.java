package dev.unowly;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class TreeTimberClient implements ClientModInitializer {
	private static boolean timberActiveClientSide = false;
	@Override
	public void onInitializeClient() {
		HudRenderCallback.EVENT.register(((drawContext, renderTickCounter) -> {
			MinecraftClient client = MinecraftClient.getInstance();
			if(client != null && client.player != null) {
				Text text;
				Formatting color;
				if(timberActiveClientSide) {
					text = Text.literal("Timber Mode active!");
					color = Formatting.DARK_RED;
				} else {
					text = Text.literal("");
					color = Formatting.RED;
				}
				int width = client.getWindow().getScaledWidth();
				int height = client.getWindow().getScaledHeight();
				int textWidth = client.textRenderer.getWidth(text);
				int x = width / 2 - textWidth / 2;
				int y = height / 2 - 60;
				drawContext.drawText(client.textRenderer, text, x, y, 0xFFFFFF, true);
			}
		}));
	}

	public static void setTimberActive(boolean active) {
		timberActiveClientSide = active;
		TreeTimber.LOGGER.info("Client-seitiger Timber-Status gesetzt: " + active);
	}

	public static boolean isTimberActive() {
		return timberActiveClientSide;
	}
}
