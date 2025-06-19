package dev.unowly.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TreeTimberGermanLanguageProvider extends FabricLanguageProvider {
    public TreeTimberGermanLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "de_de", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.category.treetimber.treetimber", "TreeTimber");
        translationBuilder.add("key.treetimber.timber", "TreeTimber umschalten");
        translationBuilder.add("key.treetimber.timber_config", "TreeTimber Einstellungen");

        translationBuilder.add("text.autoconfig.TreeTimber.title","TreeTimber Einstellungen");

        translationBuilder.add("text.autoconfig.TreeTimber.category.default", "Standard Einstellungen");

        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock", "Werkzeugverschleiß pro Block");
        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock.@Tooltip", "Wenn aktiviert, verliert das Werkzeug pro Holzblock 1 Haltbarkeit.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes", "Alle Werkzeuge erlauben");
        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes.@Tooltip", "Wenn deaktiviert, können nur Äxte Bäume fällen.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken", "Maximal zerstörte Holzblöcke");
        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken.@Tooltip", "Begrenzt die Anzahl an Holzblöcken, um Lag zu vermeiden.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings", "Setzlinge nachpflanzen");
        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings.@Tooltip", "Wenn aktiviert, werden nach dem Fällen Setzlinge gepflanzt.");

        translationBuilder.add("text.autoconfig.TreeTimber.category.hud", "HUD-Einstellungen");

        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled", "HUD anzeigen");
        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled.@Tooltip", "Schaltet die Sichtbarkeit des HUD-Indikators um.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation", "Ein-/Ausblendanimation");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation.@Tooltip", "Aktiviert eine Fade-In/Fade-Out-Animation für den HUD-Text.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation", "Puls-Animation");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation.@Tooltip", "Aktiviert eine pulsierende Skalierungsanimation, wenn aktiv.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow", "Textschatten");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow.@Tooltip", "Aktiviert einen Schatten hinter dem HUD-Text.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.activeColor", "Farbe (aktiv)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveColor", "Farbe (inaktiv)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadowColor", "Schattenfarbe");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeStartColor", "Startfarbe (Fade)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeEndColor", "Endfarbe (Fade)");

        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset", "Horizontale Position");
        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset.@Tooltip", "HUD-Position von links in Prozent.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset", "Vertikale Position");
        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset.@Tooltip", "HUD-Position von oben in Prozent.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeInDuration", "Einblenddauer (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeOutDuration", "Ausblenddauer (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseSpeed", "Puls-Geschwindigkeit (ms)");

        translationBuilder.add("text.autoconfig.TreeTimber.option.textScale", "Textgröße (%)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.activeText", "Text (aktiv)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveText", "Text (inaktiv)");

    }
}
