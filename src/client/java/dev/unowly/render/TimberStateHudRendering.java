package dev.unowly.render;

import dev.unowly.config.TreeTimberConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import org.joml.Matrix3x2fStack;

public class TimberStateHudRendering {

    private static boolean timberActive = false;
    private static boolean previousState = false;
    private static long stateChangeTime = 0;
    private static TreeTimberConfig config;

    public static void setConfig(TreeTimberConfig config) {
        TimberStateHudRendering.config = config;
    }

    public static void setTimberActive(boolean active) {
        if (timberActive != active) {
            previousState = timberActive;
            timberActive = active;
            stateChangeTime = System.currentTimeMillis();
        }
    }

    public static boolean isTimberActive() {
        return timberActive;
    }

    public static void render(DrawContext context, RenderTickCounter tickCounter) {
        if (!timberActive && (config == null || config.enabled)) return;
        if (config != null && !config.enabled) return;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.textRenderer == null) return;

        long currentTime = System.currentTimeMillis();
        long timeSinceChange = currentTime - stateChangeTime;

        float alpha = config != null && config.fadeAnimation ? calculateAlpha(timeSinceChange) : 1.0f;
        if (alpha <= 0.0f) return;

        float pulseMultiplier = 1.0f;
        if (config != null && config.pulseAnimation && timberActive) {
            pulseMultiplier = calculatePulse(currentTime);
        }

        String message = timberActive ?
                (config != null ? config.activeText : "TreeTimber is ACTIVE") :
                (config != null ? config.inactiveText : "TreeTimber is INACTIVE");
        TextRenderer renderer = client.textRenderer;

        int screenWidth = context.getScaledWindowWidth();
        int screenHeight = context.getScaledWindowHeight();

        int textWidth = renderer.getWidth(message);
        int xOffset = config != null ? config.xOffset : 50;
        int yOffset = config != null ? config.yOffset : 90;
        int x = (screenWidth * xOffset / 100) - (textWidth / 2);
        int y = screenHeight * yOffset / 100;

        int baseColor = timberActive ?
                (config != null ? config.activeColor : 0x00FF00) :
                (config != null ? config.inactiveColor : 0xFF0000);
        int color = applyAlpha(baseColor, alpha);

        Matrix3x2fStack matrices = context.getMatrices();
        matrices.pushMatrix();

        float scale = ((config != null ? config.textScale : 100) / 100.0f) * pulseMultiplier;

        float centerX = x + renderer.getWidth(message) / 2f;
        float centerY = y + renderer.fontHeight / 2f;

        matrices.translate(centerX, centerY);
        matrices.scale(scale, scale);
        matrices.translate(-centerX, -centerY);

        int scaledX = x;
        int scaledY = y;

        if (config == null || config.shadow) {
            int shadowColor = applyAlpha(config != null ? config.shadowColor : 0x000000, alpha);
            context.drawText(renderer, message, scaledX + 1, scaledY + 1, shadowColor, false);
        }

        if (config != null && config.fadeAnimation) {
            renderGradientText(context, renderer, message, scaledX, scaledY, alpha, currentTime);
        } else {
            context.drawText(renderer, message, scaledX, scaledY, color, false);
        }

        matrices.popMatrix();
    }

    private static float calculateAlpha(long timeSinceChange) {
        if (config == null || !config.fadeAnimation) {
            return 1.0f;
        }

        if (timberActive) {
            if (timeSinceChange < config.fadeInDuration) {
                return (float) timeSinceChange / config.fadeInDuration;
            }
            return 1.0f;
        } else {
            if (timeSinceChange < config.fadeOutDuration) {
                return 1.0f - ((float) timeSinceChange / config.fadeOutDuration);
            }
            return 0.0f;
        }
    }

    private static float calculatePulse(long currentTime) {
        if (config == null || config.pulseSpeed <= 0) return 1.0f;

        double cycle = (currentTime % config.pulseSpeed) / (double) config.pulseSpeed;
        return 1.0f + 0.1f * (float) Math.sin(cycle * 2 * Math.PI);
    }

    private static int applyAlpha(int color, float alpha) {
        int a = (int) (255 * alpha);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    private static void renderGradientText(DrawContext context, TextRenderer renderer, String message, int x, int y, float alpha, long time) {
        int totalWidth = renderer.getWidth(message);
        int startColor = config.fadeStartColor;
        int endColor = config.fadeEndColor;

        int currentX = x;
        float speed = 0.001f;
        float offset = (time % 10000L) * speed;

        for (int i = 0; i < message.length(); i++) {
            String s = String.valueOf(message.charAt(i));
            int charWidth = renderer.getWidth(s);

            float t = totalWidth == 0 ? 0 : ((float)(currentX - x) / totalWidth + offset) % 1.0f;
            int interpolatedColor = interpolateColor(startColor, endColor, t);
            int colorWithAlpha = applyAlpha(interpolatedColor, alpha);

            context.drawText(renderer, s, currentX, y, colorWithAlpha, false);
            currentX += charWidth;
        }
    }
    private static int interpolateColor(int color1, int color2, float t) {
        int r1 = (color1 >> 16) & 0xFF;
        int g1 = (color1 >> 8) & 0xFF;
        int b1 = color1 & 0xFF;

        int r2 = (color2 >> 16) & 0xFF;
        int g2 = (color2 >> 8) & 0xFF;
        int b2 = color2 & 0xFF;

        int r = (int)(r1 + (r2 - r1) * t);
        int g = (int)(g1 + (g2 - g1) * t);
        int b = (int)(b1 + (b2 - b1) * t);

        return (r << 16) | (g << 8) | b;
    }
}