package com.phantomwing.rusticdelight.world;

import com.phantomwing.rusticdelight.RusticDelight;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * Placed feature keys. The features and placements themselves live in data
 * ({@code data/rusticdelight/worldgen/feature} and {@code .../placed_feature}) since 26.3
 * made configured features data driven; these keys are just handles for biome injection.
 */
public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> WILD_BELL_PEPPERS_PLACED_KEY = registerKey("wild_bell_peppers_placed");
    public static final ResourceKey<PlacedFeature> WILD_COTTON_PLACED_KEY = registerKey("wild_cotton_placed");
    public static final ResourceKey<PlacedFeature> WILD_COFFEE_PLACED_KEY = registerKey("wild_coffee_placed");
    public static final ResourceKey<PlacedFeature> BELL_PEPPER_BLOCK_PATCH_PLACED_KEY = registerKey("bell_pepper_block_patch_placed");

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(RusticDelight.MOD_ID, name));
    }
}
