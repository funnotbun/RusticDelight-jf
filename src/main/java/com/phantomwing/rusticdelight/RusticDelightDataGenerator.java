package com.phantomwing.rusticdelight;

import com.phantomwing.rusticdelight.datagen.*;
import com.phantomwing.rusticdelight.datagen.ModLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class RusticDelightDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
        pack.addProvider(ModBiomeTagsProvider::new);

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModAdvancements::new);

        // 26.1 drives villager trades from data rather than TradeOfferHelper at runtime.
        pack.addProvider(ModVillagerTrades::new);
        pack.addProvider(ModVillagerTradeTagsProvider::new);
    }
}
