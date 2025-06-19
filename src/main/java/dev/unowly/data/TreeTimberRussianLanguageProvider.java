package dev.unowly.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TreeTimberRussianLanguageProvider extends FabricLanguageProvider {
    public TreeTimberRussianLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "ru_ru", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.category.treetimber.treetimber", "TreeTimber");
        translationBuilder.add("key.treetimber.timber", "Включить TreeTimber");
        translationBuilder.add("key.treetimber.timber_config", "Настройки TreeTimber");

        //Cloth Config
        translationBuilder.add("text.autoconfig.TreeTimber.title", "Настройки TreeTimber");

        translationBuilder.add("text.autoconfig.TreeTimber.category.default", "Настройки по умолчанию");


        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock", "Повреждение инструмента за блок");
        translationBuilder.add("text.autoconfig.TreeTimber.option.damagePerBlock.@Tooltip", "Если включено, инструмент теряет 1 единицу прочности за каждое сломанное бревно.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes", "Разрешить все инструменты");
        translationBuilder.add("text.autoconfig.TreeTimber.option.allowNonAxes.@Tooltip", "Если отключено, рубить деревья можно только топорами.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken", "Максимальное количество сломанных бревен");
        translationBuilder.add("text.autoconfig.TreeTimber.option.maxLogsBrocken.@Tooltip", "Ограничивает количество бревен, которые можно сломать за раз, чтобы избежать лагов.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings", "Пересаживать саженцы");
        translationBuilder.add("text.autoconfig.TreeTimber.option.replantSaplings.@Tooltip", "Если включено, после срубки дерево пересаживается.");

        //HUD Settings
        translationBuilder.add("text.autoconfig.TreeTimber.category.hud", "Настройки HUD");

        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled", "Показать HUD");
        translationBuilder.add("text.autoconfig.TreeTimber.option.enabled.@Tooltip", "Включает или отключает отображение индикатора HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation", "Анимация исчезновения");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeAnimation.@Tooltip", "Включает анимацию плавного появления и исчезновения текста HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation", "Анимация пульсации");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseAnimation.@Tooltip", "Включает пульсирующую анимацию при активности.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow", "Тень текста");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadow.@Tooltip", "Включает тень за текстом HUD.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.activeColor", "Цвет активного текста");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveColor", "Цвет неактивного текста");
        translationBuilder.add("text.autoconfig.TreeTimber.option.shadowColor", "Цвет тени");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeStartColor", "Цвет начала исчезновения");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeEndColor", "Цвет конца исчезновения");

        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset", "Горизонтальное положение");
        translationBuilder.add("text.autoconfig.TreeTimber.option.xOffset.@Tooltip", "Положение HUD слева в процентах.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset", "Вертикальное положение");
        translationBuilder.add("text.autoconfig.TreeTimber.option.yOffset.@Tooltip", "Положение HUD сверху в процентах.");

        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeInDuration", "Длительность появления (мс)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.fadeOutDuration", "Длительность исчезновения (мс)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.pulseSpeed", "Скорость пульсации (мс)");

        translationBuilder.add("text.autoconfig.TreeTimber.option.textScale", "Размер текста (%)");
        translationBuilder.add("text.autoconfig.TreeTimber.option.activeText", "Активный текст");
        translationBuilder.add("text.autoconfig.TreeTimber.option.inactiveText", "Неактивный текст");
    }
}
