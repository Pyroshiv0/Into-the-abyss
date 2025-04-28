
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.pyroshiv.intotheabyss.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.pyroshiv.intotheabyss.IntoTheAbyssMod;

public class IntoTheAbyssModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IntoTheAbyssMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABYSSBLOCKS = REGISTRY.register("abyssblocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.into_the_abyss.abyssblocks")).icon(() -> new ItemStack(Blocks.BEDROCK)).displayItems((parameters, tabData) -> {
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
			})

					.build());
}
