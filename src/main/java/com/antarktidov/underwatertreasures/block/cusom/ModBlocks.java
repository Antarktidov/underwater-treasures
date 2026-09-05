package com.antarktidov.underwatertreasures.block.cusom;

import com.antarktidov.underwatertreasures.UnderwatertreasuresMod;
import com.antarktidov.underwatertreasures.block.cusom.PirateChest;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(UnderwatertreasuresMod.MODID);

    public static final DeferredBlock<PirateChest> PIRATE_CHEST = register("pirate_chest",
            p -> new PirateChest(() -> BlockEntityType.CHEST, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p));

    private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
        return REGISTRY.registerBlock(name, supplier);
    }
}
