
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.pyroshiv.intotheabyss.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

import com.pyroshiv.intotheabyss.item.TemporaryAbyssItem;
import com.pyroshiv.intotheabyss.item.SulfuricWaterItem;
import com.pyroshiv.intotheabyss.IntoTheAbyssMod;

public class IntoTheAbyssModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, IntoTheAbyssMod.MODID);
	public static final DeferredHolder<Item, Item> HOT_SAND = block(IntoTheAbyssModBlocks.HOT_SAND);
	public static final DeferredHolder<Item, Item> HOT_SANDSTONE_TILES = block(IntoTheAbyssModBlocks.HOT_SANDSTONE_TILES);
	public static final DeferredHolder<Item, Item> HOT_SANDSTONE = block(IntoTheAbyssModBlocks.HOT_SANDSTONE);
	public static final DeferredHolder<Item, Item> PADAUK_LOG = block(IntoTheAbyssModBlocks.PADAUK_LOG);
	public static final DeferredHolder<Item, Item> PADAUK_PLANKS = block(IntoTheAbyssModBlocks.PADAUK_PLANKS);
	public static final DeferredHolder<Item, Item> PADAUK_DOOR = doubleBlock(IntoTheAbyssModBlocks.PADAUK_DOOR);
	public static final DeferredHolder<Item, Item> PADAUK_TRAPDOOR = block(IntoTheAbyssModBlocks.PADAUK_TRAPDOOR);
	public static final DeferredHolder<Item, Item> PADAUK_STAIRS = block(IntoTheAbyssModBlocks.PADAUK_STAIRS);
	public static final DeferredHolder<Item, Item> PADAUK_SLAB = block(IntoTheAbyssModBlocks.PADAUK_SLAB);
	public static final DeferredHolder<Item, Item> PADAUK_FENCE = block(IntoTheAbyssModBlocks.PADAUK_FENCE);
	public static final DeferredHolder<Item, Item> PADAUK_FENCE_GATE = block(IntoTheAbyssModBlocks.PADAUK_FENCE_GATE);
	public static final DeferredHolder<Item, Item> PADAUK_BUTTON = block(IntoTheAbyssModBlocks.PADAUK_BUTTON);
	public static final DeferredHolder<Item, Item> PADAUK_PRESSURE_PLATE = block(IntoTheAbyssModBlocks.PADAUK_PRESSURE_PLATE);
	public static final DeferredHolder<Item, Item> HOT_STONE = block(IntoTheAbyssModBlocks.HOT_STONE);
	public static final DeferredHolder<Item, Item> HOT_STONE_SLAB = block(IntoTheAbyssModBlocks.HOT_STONE_SLAB);
	public static final DeferredHolder<Item, Item> HOT_STONE_STAIRS = block(IntoTheAbyssModBlocks.HOT_STONE_STAIRS);
	public static final DeferredHolder<Item, Item> HOT_STONE_WALLS = block(IntoTheAbyssModBlocks.HOT_STONE_WALLS);
	public static final DeferredHolder<Item, Item> HOT_PRESSURE_PLATE = block(IntoTheAbyssModBlocks.HOT_PRESSURE_PLATE);
	public static final DeferredHolder<Item, Item> PADAUK_DRIED_LEAVES = block(IntoTheAbyssModBlocks.PADAUK_DRIED_LEAVES);
	public static final DeferredHolder<Item, Item> PADAUK_LEAVES = block(IntoTheAbyssModBlocks.PADAUK_LEAVES);
	public static final DeferredHolder<Item, Item> PADAUK_WOOD = block(IntoTheAbyssModBlocks.PADAUK_WOOD);
	public static final DeferredHolder<Item, Item> TEMPORARY_ABYSS = REGISTRY.register("temporary_abyss", () -> new TemporaryAbyssItem());
	public static final DeferredHolder<Item, Item> SULFURIC_WATER_BUCKET = REGISTRY.register("sulfuric_water_bucket", () -> new SulfuricWaterItem());

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static DeferredHolder<Item, Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
