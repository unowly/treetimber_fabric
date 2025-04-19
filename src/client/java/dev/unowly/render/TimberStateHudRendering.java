package dev.unowly.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;

public class TimberStateHudRendering {

    public static boolean timberActive = false;

    public static void render(DrawContext context, RenderTickCounter tickCounter) {
        if (!timberActive) return;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.textRenderer == null) return;

        String message = "TreeTimber is ACTIVE";
        TextRenderer renderer = client.textRenderer;

        int screenWidth = context.getScaledWindowWidth();
        int screenHeight = context.getScaledWindowHeight();

        int x = (screenWidth - renderer.getWidth(message)) / 2;
        int y = screenHeight - 50;

        context.drawText(renderer, message, x, y, 0xFFFF0000, true);
    }
}