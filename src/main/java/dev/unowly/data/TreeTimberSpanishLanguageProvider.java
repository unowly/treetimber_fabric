package dev.unowly.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TreeTimberSpanishLanguageProvider extends FabricLanguageProvider {
    public TreeTimberSpanishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "es_es", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.category.treetimber.treetimber", "TreeTimber");
        translationBuilder.add("key.treetimber.timber", "Alternar TreeTimber");
        translationBuilder.add("key.treetimber.timber_config", "Configuración de TreeTimber");

        //Cloth Config
        translationBuilder.add("text.autoconfig.TreeTimber.title", "Configuración de TreeTimber");

        translationBuilder.add("text.autoconfig.TreeTimber.category.default", "Configuración predeterminada");


        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock", "Daño a la herramienta por bloque");
        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock.@Tooltip", "Si está activado, la herramienta pierde 1 de durabilidad por cada tronco roto.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes", "Permitir todas las herramientas");
        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes.@Tooltip", "Si está desactivado, solo los hachas pueden talar árboles.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken", "Máximo troncos rotos");
        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken.@Tooltip", "Limita cuántos troncos pueden romperse a la vez para evitar lag.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings", "Replantar retoños");
        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings.@Tooltip", "Si está activado, los retoños serán replantados tras talar un árbol.");

        //HUD Settings
        translationBuilder.add("text.autoconfig.TreeTimber.category.hud", "Configuración del HUD");

        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled", "Mostrar HUD");
        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled.@Tooltip", "Activa o desactiva el indicador del HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation", "Animación de desvanecimiento");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation.@Tooltip", "Activa una animación de desvanecimiento para el texto del HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation", "Animación de pulso");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation.@Tooltip", "Activa una animación de pulso cuando está activo.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow", "Sombra del texto");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow.@Tooltip", "Activa una sombra para el texto del HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.activeColor", "Color del texto activo");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveColor", "Color del texto inactivo");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadowColor", "Color de la sombra");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeStartColor", "Color inicial del desvanecimiento");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeEndColor", "Color final del desvanecimiento");

        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset", "Posición horizontal");
        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset.@Tooltip", "Posición del HUD desde la izquierda en porcentaje.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset", "Posición vertical");
        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset.@Tooltip", "Posición del HUD desde arriba en porcentaje.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeInDuration", "Duración del desvanecimiento de entrada (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeOutDuration", "Duración del desvanecimiento de salida (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseSpeed", "Velocidad del pulso (ms)");

        translationBuilder.add("text.autoconfig.TreeTimber.option.textScale", "Tamaño del texto (%)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.activeText", "Texto activo");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveText", "Texto inactivo");
    }
}
