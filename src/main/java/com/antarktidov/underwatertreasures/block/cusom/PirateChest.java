package com.antarktidov.underwatertreasures.block.cusom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import java.util.function.Supplier;

public class PirateChest extends ChestBlock {
    public PirateChest(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType, SoundEvent openSound, SoundEvent closeSound, Properties properties) {
        super(blockEntityType, openSound, closeSound, properties);
    }
}
