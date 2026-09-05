/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.antarktidov.underwatertreasures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import java.util.function.Function;

import com.antarktidov.underwatertreasures.item.*;
import com.antarktidov.underwatertreasures.UnderwatertreasuresMod;

public class UnderwatertreasuresModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(UnderwatertreasuresMod.MODID);
	public static final DeferredItem<Item> GOLDEN_COIN;
	public static final DeferredItem<Item> SILVER_COIN;
	public static final DeferredItem<Item> WHITE_BUSY;
	public static final DeferredItem<Item> CORAL_BUSY;
	public static final DeferredItem<Item> CORAL_STAR;
	public static final DeferredItem<Item> YELLOW_STAR;
	public static final DeferredItem<Item> CORAL_STAR_2;
	public static final DeferredItem<Item> YELLOW_STAR_2;
	static {
		GOLDEN_COIN = register("golden_coin", GoldenCoinItem::new);
		SILVER_COIN = register("silver_coin", SilverCoinItem::new);
		WHITE_BUSY = register("white_busy", WhiteBusyItem::new);
		CORAL_BUSY = register("coral_busy", CoralBusyItem::new);
		CORAL_STAR = register("coral_star", CoralStarItem::new);
		YELLOW_STAR = register("yellow_star", YellowStarItem::new);
		CORAL_STAR_2 = register("coral_star_2", CoralStar2Item::new);
		YELLOW_STAR_2 = register("yellow_star_2", YellowStar2Item::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}
}