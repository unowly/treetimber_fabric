package dev.unowly.config;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "TreeTimber")
public class TreeTimberConfig implements ConfigData {
    public boolean damagePerBlock = true;
    public boolean allowNonAxes = false;
    public int maxLogsBrocken = 256;
    public boolean replantSaplings = true;
}
