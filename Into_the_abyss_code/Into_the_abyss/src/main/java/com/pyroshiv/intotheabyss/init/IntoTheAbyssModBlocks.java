
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.pyroshiv.intotheabyss.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import com.pyroshiv.intotheabyss.block.PadaukTrapdoorBlock;
import com.pyroshiv.intotheabyss.block.PadaukStairsBlock;
import com.pyroshiv.intotheabyss.block.PadaukSlabBlock;
import com.pyroshiv.intotheabyss.block.PadaukPlanksBlock;
import com.pyroshiv.intotheabyss.block.PadaukLogBlock;
import com.pyroshiv.intotheabyss.block.PadaukFenceBlock;
import com.pyroshiv.intotheabyss.block.PadaukDoorBlock;
import com.pyroshiv.intotheabyss.block.HotSandstoneTilesBlock;
import com.pyroshiv.intotheabyss.block.HotSandstoneBlock;
import com.pyroshiv.intotheabyss.block.HotSandBlock;
import com.pyroshiv.intotheabyss.IntoTheAbyssMod;

public class IntoTheAbyssModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, IntoTheAbyssMod.MODID);
	public static final DeferredHolder<Block, Block> HOT_SAND = REGISTRY.register("hot_sand", () -> new HotSandBlock());
	public static final DeferredHolder<Block, Block> HOT_SANDSTONE_TILES = REGISTRY.register("hot_sandstone_tiles", () -> new HotSandstoneTilesBlock());
	public static final DeferredHolder<Block, Block> HOT_SANDSTONE = REGISTRY.register("hot_sandstone", () -> new HotSandstoneBlock());
	public static final DeferredHolder<Block, Block> PADAUK_LOG = REGISTRY.register("padauk_log", () -> new PadaukLogBlock());
	public static final DeferredHolder<Block, Block> PADAUK_PLANKS = REGISTRY.register("padauk_planks", () -> new PadaukPlanksBlock());
	public static final DeferredHolder<Block, Block> PADAUK_DOOR = REGISTRY.register("padauk_door", () -> new PadaukDoorBlock());
	public static final DeferredHolder<Block, Block> PADAUK_TRAPDOOR = REGISTRY.register("padauk_trapdoor", () -> new PadaukTrapdoorBlock());
	public static final DeferredHolder<Block, Block> PADAUK_STAIRS = REGISTRY.register("padauk_stairs", () -> new PadaukStairsBlock());
	public static final DeferredHolder<Block, Block> PADAUK_SLAB = REGISTRY.register("padauk_slab", () -> new PadaukSlabBlock());
	public static final DeferredHolder<Block, Block> PADAUK_FENCE = REGISTRY.register("padauk_fence", () -> new PadaukFenceBlock());
	public static final DeferredHolder<Block, Block> PADAUK_FENCE_GATE = REGISTRY.register("padauk_fence_gate", () -> new PadaukFenceGateBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
