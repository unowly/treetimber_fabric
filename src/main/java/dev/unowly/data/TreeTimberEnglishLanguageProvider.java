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

        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock", "Damage Tool per Block");
        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock.@Tooltip", "If enabled, the tool takes 1 durability per log broken.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes", "Allow All Tools");
        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes.@Tooltip", "If disabled, only axes can trigger tree felling.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken", "Max Logs Broken");
        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken.@Tooltip", "Limits how many logs can be broken at once to prevent lag.");

        translationBuilder.add("config.treetimber.replantSapling", "Replant Saplings");
        translationBuilder.add("config.treetimber.replantSapling.@Tooltip", "If true, saplings will be planted after a tree is felled.");
    }
}
