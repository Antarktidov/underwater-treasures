/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.antarktidov.underwatertreasures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.antarktidov.underwatertreasures.UnderwatertreasuresMod;

public class UnderwatertreasuresModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnderwatertreasuresMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TREASURES = REGISTRY.register("treasures",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.underwatertreasures.treasures")).icon(() -> new ItemStack(UnderwatertreasuresModItems.GOLDEN_COIN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(UnderwatertreasuresModItems.GOLDEN_COIN.get());
				tabData.accept(UnderwatertreasuresModItems.SILVER_COIN.get());
			}).build());
}