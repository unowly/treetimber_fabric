package dev.unowly.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class ModConfig {
    public static TreeTimberConfig CONFIG;

    public static void init() {
        AutoConfig.register(TreeTimberConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(TreeTimberConfig.class).getConfig();
    }
}
