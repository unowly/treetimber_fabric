package dev.unowly.event;

import dev.unowly.config.TreeTimberConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_TREE_TIMBER = "key.category.treetimber.treetimber";
    public static final String KEY_TREE_TIMBER = "key.treetimber.timber";
    public static final String KEY_TREE_TIMBER_CONFIG = "key.treetimber.timber_config";

    public static KeyBinding timberKey;
    public static KeyBinding timberConfigKey;

    public static void registerKeyCommandInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (timberKey != null && timberKey.wasPressed()) {
                if (client.player != null) {
                    client.player.networkHandler.sendCommand("timber");
                }
            }

            if (timberConfigKey != null && timberConfigKey.wasPressed()) {
                client.setScreen(AutoConfig.getConfigScreen(TreeTimberConfig.class, client.currentScreen).get());
            }
        });
    }

    public static void register() {
        timberKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TREE_TIMBER,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                KEY_CATEGORY_TREE_TIMBER
        ));

        timberConfigKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TREE_TIMBER_CONFIG,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                KEY_CATEGORY_TREE_TIMBER
        ));

        registerKeyCommandInputs();
    }
}
