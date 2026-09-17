package com.phantomwing.rusticdelight.util;

import com.phantomwing.rusticdelight.item.ModItems;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;

public class FuelHelper {
    public static void registerFuelItems() {
        DefaultItemComponentEvents.MODIFY.register(context -> context.modify(ModItems.COTTON_BOLL, builder ->
                builder.set(DataComponents.COOKING_FUEL, new CookingFuel(
                        new ResolvableInt.Constant(100),
                        ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER)))));
    }
}
