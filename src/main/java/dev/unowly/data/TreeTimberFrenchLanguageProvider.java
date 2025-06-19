package dev.unowly.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TreeTimberFrenchLanguageProvider extends FabricLanguageProvider {
    public TreeTimberFrenchLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "fr_fr", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.category.treetimber.treetimber", "TreeTimber");
        translationBuilder.add("key.treetimber.timber", "Basculer TreeTimber");
        translationBuilder.add("key.treetimber.timber_config", "Configuration TreeTimber");

        //Cloth Config
        translationBuilder.add("text.autoconfig.TreeTimber.title", "Paramètres TreeTimber");

        translationBuilder.add("text.autoconfig.TreeTimber.category.default", "Paramètres par défaut");

        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock", "Dommage à l’outil par bloc");
        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock.@Tooltip", "Si activé, l’outil perd 1 durabilité par bûche cassée.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes", "Autoriser tous les outils");
        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes.@Tooltip", "Si désactivé, seuls les haches peuvent abattre les arbres.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken", "Nombre maximum de bûches cassées");
        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken.@Tooltip", "Limite combien de bûches peuvent être cassées en une fois pour éviter le lag.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings", "Replanter les pousses");
        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings.@Tooltip", "Si activé, les pousses seront replantées après l’abattage d’un arbre.");

        //HUD Settings
        translationBuilder.add("text.autoconfig.TreeTimber.category.hud", "Paramètres HUD");

        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled", "Afficher le HUD");
        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled.@Tooltip", "Active ou désactive l’affichage de l’indicateur HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation", "Animation de fondu");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation.@Tooltip", "Active une animation de fondu pour le texte HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation", "Animation de pulsation");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation.@Tooltip", "Active une animation de pulsation lorsque actif.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow", "Ombre du texte");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow.@Tooltip", "Active une ombre portée derrière le texte HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.activeColor", "Couleur du texte actif");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveColor", "Couleur du texte inactif");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadowColor", "Couleur de l’ombre");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeStartColor", "Couleur de début du fondu");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeEndColor", "Couleur de fin du fondu");

        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset", "Position horizontale");
        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset.@Tooltip", "Position du HUD depuis la gauche en pourcentage.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset", "Position verticale");
        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset.@Tooltip", "Position du HUD depuis le haut en pourcentage.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeInDuration", "Durée du fondu entrant (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeOutDuration", "Durée du fondu sortant (ms)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseSpeed", "Vitesse de pulsation (ms)");

        translationBuilder.add("text.autoconfig.TreeTimber.option.textScale", "Taille du texte (%)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.activeText", "Texte actif");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveText", "Texte inactif");
    }
}
