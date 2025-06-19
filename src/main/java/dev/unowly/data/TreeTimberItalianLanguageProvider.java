package dev.unowly.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TreeTimberItalianLanguageProvider extends FabricLanguageProvider {
    public TreeTimberItalianLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "it_it", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.category.treetimber.treetimber", "TreeTimber");
        translationBuilder.add("key.treetimber.timber", "Attiva TreeTimber");
        translationBuilder.add("key.treetimber.timber_config", "Configurazione TreeTimber");

        //Cloth Config
        translationBuilder.add("text.autoconfig.TreeTimber.title", "Impostazioni TreeTimber");

        translationBuilder.add("text.autoconfig.TreeTimber.category.default", "Impostazioni predefinite");

        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock", "Danno all’attrezzo per blocco");
        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock.@Tooltip", "Se attivato, l’attrezzo perde 1 punto di durabilità per ogni tronco rotto.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes", "Permetti tutti gli attrezzi");
        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes.@Tooltip", "Se disattivato, solo le asce possono abbattere gli alberi.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken", "Numero massimo di tronchi rotti");
        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken.@Tooltip", "Limita quanti tronchi possono essere rotti contemporaneamente per evitare lag.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings", "Ripiantare le piantine");
        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings.@Tooltip", "Se attivato, le piantine saranno ripiantate dopo l’abbattimento di un albero.");

        //HUD Settings
        translationBuilder.add("text.autoconfig.TreeTimber.category.hud", "Impostazioni HUD");

        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled", "Mostra HUD");
        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled.@Tooltip", "Attiva o disattiva l’indicatore HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation", "Animazione dissolvenza");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation.@Tooltip", "Attiva un’animazione di dissolvenza per il testo HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation", "Animazione a impulsi");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation.@Tooltip", "Attiva un’animazione a impulsi quando attivo.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow", "Ombra del testo");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow.@Tooltip", "Attiva un’ombra dietro il testo HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.activeColor", "Colore testo attivo");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveColor", "Colore testo inattivo");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadowColor", "Colore ombra");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeStartColor", "Colore inizio dissolvenza");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeEndColor", "Colore fine dissolvenza");

        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset", "Posizione orizzontale");
        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset.@Tooltip", "Posizione HUD da sinistra in percentuale.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset", "Posizione verticale");
        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset.@Tooltip", "Posizione HUD dall’alto in percentuale.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeInDuration", "Durata dissolvenza entrante (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeOutDuration", "Durata dissolvenza uscente (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseSpeed", "Velocità impulso (ms)");

        translationBuilder.add("text.autoconfig.TreeTimber.option.textScale", "Scala del testo (%)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.activeText", "Testo attivo");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveText", "Testo inattivo");
    }
}
