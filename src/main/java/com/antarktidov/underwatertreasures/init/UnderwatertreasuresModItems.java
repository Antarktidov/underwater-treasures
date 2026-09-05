/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.antarktidov.underwatertreasures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import java.util.function.Function;

import com.antarktidov.underwatertreasures.item.SilverCoinItem;
import com.antarktidov.underwatertreasures.item.GoldenCoinItem;
import com.antarktidov.underwatertreasures.UnderwatertreasuresMod;

public class UnderwatertreasuresModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(UnderwatertreasuresMod.MODID);
	public static final DeferredItem<Item> GOLDEN_COIN;
	public static final DeferredItem<Item> SILVER_COIN;
	static {
		GOLDEN_COIN = register("golden_coin", GoldenCoinItem::new);
		SILVER_COIN = register("silver_coin", SilverCoinItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}
}