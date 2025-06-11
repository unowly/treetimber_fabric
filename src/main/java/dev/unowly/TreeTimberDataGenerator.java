package dev.unowly;

import dev.unowly.data.TreeTimberEnglishLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TreeTimberDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

//LANGUAGE PROVIDER
        pack.addProvider(TreeTimberEnglishLanguageProvider::new);
    }
}