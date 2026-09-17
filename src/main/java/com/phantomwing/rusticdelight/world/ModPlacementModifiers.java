package com.phantomwing.rusticdelight.world;

import com.mojang.serialization.MapCodec;
import com.phantomwing.rusticdelight.RusticDelight;
import com.phantomwing.rusticdelight.world.modifiers.ConfigurableRarityFilter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.function.Supplier;

public class ModPlacementModifiers {
    // 26.3 registers the codec directly; PlacementModifierType is gone.
    public static final Supplier<MapCodec<ConfigurableRarityFilter>> CONFIGURABLE_RARITY_FILTER =
            registerModifier("configurable_rarity_filter", ConfigurableRarityFilter.CODEC);

    public static <T extends PlacementModifier> Supplier<MapCodec<T>> registerModifier(String name, MapCodec<T> codec) {
        Supplier<MapCodec<T>> supplier = () -> Registry.register(
                BuiltInRegistries.PLACEMENT_MODIFIER_TYPE,
                Identifier.fromNamespaceAndPath(RusticDelight.MOD_ID, name),
                codec);
        supplier.get();
        return supplier;
    }

    public static void registerPlacementModfiiers() {
        RusticDelight.LOGGER.info("Registering placement modifiers for " + RusticDelight.MOD_ID);

    }
}
