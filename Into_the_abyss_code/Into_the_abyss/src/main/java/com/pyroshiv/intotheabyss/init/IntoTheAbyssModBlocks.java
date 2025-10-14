
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.pyroshiv.intotheabyss.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import com.pyroshiv.intotheabyss.block.TemporaryAbyssPortalBlock;
import com.pyroshiv.intotheabyss.block.SulfuricWaterBlock;
import com.pyroshiv.intotheabyss.block.PadaukWoodBlock;
import com.pyroshiv.intotheabyss.block.PadaukTrapdoorBlock;
import com.pyroshiv.intotheabyss.block.PadaukStairsBlock;
import com.pyroshiv.intotheabyss.block.PadaukSlabBlock;
import com.pyroshiv.intotheabyss.block.PadaukPressurePlateBlock;
import com.pyroshiv.intotheabyss.block.PadaukPlanksBlock;
import com.pyroshiv.intotheabyss.block.PadaukLogBlock;
import com.pyroshiv.intotheabyss.block.PadaukLeavesBlock;
import com.pyroshiv.intotheabyss.block.PadaukFenceGateBlock;
import com.pyroshiv.intotheabyss.block.PadaukFenceBlock;
import com.pyroshiv.intotheabyss.block.PadaukDriedLeavesBlock;
import com.pyroshiv.intotheabyss.block.PadaukDoorBlock;
import com.pyroshiv.intotheabyss.block.PadaukButtonBlock;
import com.pyroshiv.intotheabyss.block.HotStoneWallsBlock;
import com.pyroshiv.intotheabyss.block.HotStoneStairsBlock;
import com.pyroshiv.intotheabyss.block.HotStoneSlabBlock;
import com.pyroshiv.intotheabyss.block.HotStoneBlock;
import com.pyroshiv.intotheabyss.block.HotSandstoneTilesBlock;
import com.pyroshiv.intotheabyss.block.HotSandstoneBlock;
import com.pyroshiv.intotheabyss.block.HotSandBlock;
import com.pyroshiv.intotheabyss.block.HotPressurePlateBlock;
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
	public static final DeferredHolder<Block, Block> PADAUK_BUTTON = REGISTRY.register("padauk_button", () -> new PadaukButtonBlock());
	public static final DeferredHolder<Block, Block> PADAUK_PRESSURE_PLATE = REGISTRY.register("padauk_pressure_plate", () -> new PadaukPressurePlateBlock());
	public static final DeferredHolder<Block, Block> HOT_STONE = REGISTRY.register("hot_stone", () -> new HotStoneBlock());
	public static final DeferredHolder<Block, Block> HOT_STONE_SLAB = REGISTRY.register("hot_stone_slab", () -> new HotStoneSlabBlock());
	public static final DeferredHolder<Block, Block> HOT_STONE_STAIRS = REGISTRY.register("hot_stone_stairs", () -> new HotStoneStairsBlock());
	public static final DeferredHolder<Block, Block> HOT_STONE_WALLS = REGISTRY.register("hot_stone_walls", () -> new HotStoneWallsBlock());
	public static final DeferredHolder<Block, Block> HOT_PRESSURE_PLATE = REGISTRY.register("hot_pressure_plate", () -> new HotPressurePlateBlock());
	public static final DeferredHolder<Block, Block> PADAUK_DRIED_LEAVES = REGISTRY.register("padauk_dried_leaves", () -> new PadaukDriedLeavesBlock());
	public static final DeferredHolder<Block, Block> PADAUK_LEAVES = REGISTRY.register("padauk_leaves", () -> new PadaukLeavesBlock());
	public static final DeferredHolder<Block, Block> PADAUK_WOOD = REGISTRY.register("padauk_wood", () -> new PadaukWoodBlock());
	public static final DeferredHolder<Block, Block> TEMPORARY_ABYSS_PORTAL = REGISTRY.register("temporary_abyss_portal", () -> new TemporaryAbyssPortalBlock());
	public static final DeferredHolder<Block, Block> SULFURIC_WATER = REGISTRY.register("sulfuric_water", () -> new SulfuricWaterBlock());

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			PadaukLeavesBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			PadaukLeavesBlock.itemColorLoad(event);
		}
	}
}
