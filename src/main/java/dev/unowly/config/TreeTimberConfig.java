package dev.unowly.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "TreeTimber")
public class TreeTimberConfig implements ConfigData {
    public boolean damagePerBlock = true;
    public boolean allowNonAxes = false;
    public int maxLogsBrocken = 256;
    public boolean replantSaplings = true;

    @ConfigEntry.Category("hud")
    public boolean enabled = true;

    @ConfigEntry.Category("hud")
    public boolean fadeAnimation = true;

    @ConfigEntry.Category("hud")
    public boolean pulseAnimation = true;

    @ConfigEntry.Category("hud")
    public boolean shadow = true;

    @ConfigEntry.Category("hud")
    @ConfigEntry.ColorPicker
    public int activeColor = 0xFF0000;

    @ConfigEntry.Category("hud")
    @ConfigEntry.ColorPicker
    public int inactiveColor = 0x00FF00; // Rot für inaktiv

    @ConfigEntry.Category("hud")
    @ConfigEntry.ColorPicker
    public int shadowColor = 0x000000;

    @ConfigEntry.Category("hud")
    @ConfigEntry.ColorPicker
    public int fadeStartColor = 0xFF0000; // Rot

    @ConfigEntry.Category("hud")
    @ConfigEntry.ColorPicker
    public int fadeEndColor = 0x0000FF;// Schwarz für Schatten

    @ConfigEntry.Category("hud")
    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    public int xOffset = 50; // Prozent von links

    @ConfigEntry.Category("hud")
    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    public int yOffset = 90; // Prozent von oben

    @ConfigEntry.Category("hud")
    @ConfigEntry.BoundedDiscrete(min = 500, max = 5000)
    public int fadeInDuration = 1000; // ms

    @ConfigEntry.Category("hud")
    @ConfigEntry.BoundedDiscrete(min = 500, max = 5000)
    public int fadeOutDuration = 1500; // ms

    @ConfigEntry.Category("hud")
    @ConfigEntry.BoundedDiscrete(min = 500, max = 3000)
    public int pulseSpeed = 1000; // ms für einen Puls-Zyklus

    @ConfigEntry.Category("hud")
    @ConfigEntry.BoundedDiscrete(min = 50, max = 200)
    public int textScale = 100; // Prozent

    @ConfigEntry.Category("hud")
    public String activeText = "TreeTimber is ACTIVE";

    @ConfigEntry.Category("hud")
    public String inactiveText = "TreeTimber is INACTIVE";

}