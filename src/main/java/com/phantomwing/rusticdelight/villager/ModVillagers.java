package com.phantomwing.rusticdelight.villager;

import com.phantomwing.rusticdelight.item.ModItems;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.VillagerFood;
import net.minecraft.world.item.Item;

import java.util.List;

/**
 * Runtime villager hooks. Trade registration is now data-driven (see
 * {@code com.phantomwing.rusticdelight.datagen.ModVillagerTrades}); this class only handles the
 * villager-food component that controls which items farmers can pick up and consume.
 */
public class ModVillagers {
    // 26.3 replaced the hardcoded Villager.FOOD_POINTS map with a data component. These match the
    // old map values (everything ours was 1).
    private static final List<Item> VILLAGER_FOODS = List.of(
        ModItems.BELL_PEPPER_GREEN,
        ModItems.BELL_PEPPER_YELLOW,
        ModItems.BELL_PEPPER_RED,
        ModItems.BELL_PEPPER_ORANGE,
        ModItems.BELL_PEPPER_WHITE,
        ModItems.BELL_PEPPER_PINK,
        ModItems.BELL_PEPPER_BLUE,
        ModItems.BELL_PEPPER_PURPLE,
        ModItems.BELL_PEPPER_BLACK,
        // Cotton and coffee aren't truly food, but counting them lets farmer villagers reliably
        // offload them to a partner so they work in automatic farms. The minor realism cost
        // (villagers eating / breeding on them) is unnoticeable in normal play.
        ModItems.COTTON_BOLL,
        ModItems.COFFEE_BEANS
    );

    public static void registerFoodsAndTrades() {
        registerFoodPoints();
    }

    /**
     * Tags our edible crops as villager food so farmer villagers count, share and breed on them
     * like vanilla crops.
     */
    private static void registerFoodPoints() {
        DefaultItemComponentEvents.MODIFY.register(context -> {
            for (Item item : VILLAGER_FOODS) {
                context.modify(item, builder -> builder.set(DataComponents.VILLAGER_FOOD, new VillagerFood(1)));
            }
        });
    }
}
