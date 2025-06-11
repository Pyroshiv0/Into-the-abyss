
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.pyroshiv.intotheabyss.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.pyroshiv.intotheabyss.IntoTheAbyssMod;

public class IntoTheAbyssModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IntoTheAbyssMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABYSSBLOCKS = REGISTRY.register("abyssblocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.into_the_abyss.abyssblocks")).icon(() -> new ItemStack(IntoTheAbyssModBlocks.PADAUK_PLANKS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IntoTheAbyssModBlocks.HOT_SAND.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.HOT_SANDSTONE_TILES.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.HOT_SANDSTONE.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_LOG.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_PLANKS.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_DOOR.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_TRAPDOOR.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_STAIRS.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_SLAB.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_FENCE.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_FENCE_GATE.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_BUTTON.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_PRESSURE_PLATE.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.HOT_STONE.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.HOT_STONE_SLAB.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.HOT_STONE_STAIRS.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.HOT_STONE_WALLS.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.HOT_PRESSURE_PLATE.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_DRIED_LEAVES.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_LEAVES.get().asItem());
				tabData.accept(IntoTheAbyssModBlocks.PADAUK_WOOD.get().asItem());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABYSS_OBJECTS = REGISTRY.register("abyss_objects",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.into_the_abyss.abyss_objects")).icon(() -> new ItemStack(IntoTheAbyssModItems.SULFURIC_WATER_BUCKET.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IntoTheAbyssModItems.SULFURIC_WATER_BUCKET.get());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABYSS_ARTEFACTS = REGISTRY.register("abyss_artefacts",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.into_the_abyss.abyss_artefacts")).icon(() -> new ItemStack(IntoTheAbyssModBlocks.PADAUK_BUTTON.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IntoTheAbyssModItems.TEMPORARY_ABYSS.get());
			})

					.build());
}
