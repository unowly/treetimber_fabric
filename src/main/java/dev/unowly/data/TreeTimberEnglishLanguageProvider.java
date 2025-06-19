package dev.unowly.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TreeTimberEnglishLanguageProvider extends FabricLanguageProvider {
    public TreeTimberEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.category.treetimber.treetimber", "TreeTimber");
        translationBuilder.add("key.treetimber.timber", "Toggle TreeTimber");
        translationBuilder.add("key.treetimber.timber_config", "TreeTimber Config");

        //Cloth Config
        translationBuilder.add("text.autoconfig.TreeTimber.title"," TreeTimber Settings");

        translationBuilder.add("text.autoconfig.TreeTimber.category.default", "Default Settings");

        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock", "Damage Tool per Block");
        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock.@Tooltip", "If enabled, the tool takes 1 durability per log broken.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes", "Allow All Tools");
        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes.@Tooltip", "If disabled, only axes can trigger tree felling.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken", "Max Logs Broken");
        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken.@Tooltip", "Limits how many logs can be broken at once to prevent lag.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings", "Replant Saplings");
        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings.@Tooltip", "If true, saplings will be planted after a tree is felled.");

        //HUD Settings
        translationBuilder.add("text.autoconfig.TreeTimber.category.hud", "HUD Settings");

        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled", "Show HUD");
        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled.@Tooltip", "Toggles the visibility of the HUD indicator.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation", "Fade Animation");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation.@Tooltip", "Enables a fade-in/out animation for the HUD text.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation", "Pulse Animation");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation.@Tooltip", "Enables a pulsing scale animation when active.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow", "Text Shadow");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow.@Tooltip", "Enables a drop shadow behind the HUD text.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.activeColor", "Active Text Color");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveColor", "Inactive Text Color");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadowColor", "Shadow Color");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeStartColor", "Fade Start Color");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeEndColor", "Fade End Color");

        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset", "Horizontal Position");
        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset.@Tooltip", "HUD position from the left in percent.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset", "Vertical Position");
        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset.@Tooltip", "HUD position from the top in percent.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeInDuration", "Fade-In Duration (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeOutDuration", "Fade-Out Duration (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseSpeed", "Pulse Speed (ms)");

        translationBuilder.add("text.autoconfig.TreeTimber.option.textScale", "Text Size (%)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.activeText", "Active Text");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveText", "Inactive Text");
    }
}
