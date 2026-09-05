package com.antarktidov.underwatertreasures;

import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.bus.api.SubscribeEvent;

import com.antarktidov.underwatertreasures.init.UnderwatertreasuresModItems;

public final class UnderwaterTreasureSpawner {
	private static final int CHECK_INTERVAL = 200;
	private static final int SEARCH_RADIUS = 32;
	private static final int MINIMUM_DISTANCE = 12;
	private static final DeferredItem<?>[] TREASURES = {
		UnderwatertreasuresModItems.GOLDEN_COIN,
		UnderwatertreasuresModItems.SILVER_COIN,
		UnderwatertreasuresModItems.WHITE_BUSY,
		UnderwatertreasuresModItems.CORAL_BUSY,
		UnderwatertreasuresModItems.CORAL_STAR,
		UnderwatertreasuresModItems.YELLOW_STAR,
		UnderwatertreasuresModItems.CORAL_STAR_2,
		UnderwatertreasuresModItems.YELLOW_STAR_2,
		UnderwatertreasuresModItems.PIRATE_FLAG
	};

	private UnderwaterTreasureSpawner() {
	}

	public static void register() {
		NeoForge.EVENT_BUS.register(UnderwaterTreasureSpawner.class);
	}

	@SubscribeEvent
	public static void onServerTick(ServerTickEvent.Post event) {
		if (event.getServer().getTickCount() % CHECK_INTERVAL != 0) {
			return;
		}

		for (Level level : event.getServer().getAllLevels()) {
			for (Player player : level.players()) {
				trySpawn(level, player);
			}
		}
	}

	private static void trySpawn(Level level, Player player) {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		int x = player.blockPosition().getX() + random.nextInt(-SEARCH_RADIUS, SEARCH_RADIUS + 1);
		int z = player.blockPosition().getZ() + random.nextInt(-SEARCH_RADIUS, SEARCH_RADIUS + 1);
		int y = level.getHeight(Heightmap.Types.OCEAN_FLOOR, x, z);
		BlockPos floor = new BlockPos(x, y - 1, z);

		if (!isValidLocation(level, floor)) {
			return;
		}

		AABB nearbyArea = new AABB(x - MINIMUM_DISTANCE, y, z - MINIMUM_DISTANCE, x + MINIMUM_DISTANCE, y + 2, z + MINIMUM_DISTANCE);
		if (!level.getEntitiesOfClass(ItemEntity.class, nearbyArea).isEmpty()) {
			return;
		}

		Item item = TREASURES[random.nextInt(TREASURES.length)].get();
		ItemEntity treasure = new ItemEntity(level, x + 0.5, y, z + 0.5, new net.minecraft.world.item.ItemStack(item));
		level.addFreshEntity(treasure);
	}

	private static boolean isValidLocation(Level level, BlockPos floor) {
		if (!(level.getBiome(floor).is(BiomeTags.IS_OCEAN) || level.getBiome(floor).is(BiomeTags.IS_RIVER))) {
			return false;
		}

		BlockPos water = floor.above();
		return level.getFluidState(water).isSource() && level.getFluidState(water).is(net.minecraft.tags.FluidTags.WATER);
	}
}