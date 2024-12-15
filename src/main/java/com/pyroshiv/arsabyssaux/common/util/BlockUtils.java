package com.pyroshiv.arsabyssaux.common.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class BlockUtils {

    public static String getBlockName(Block block) {
        ResourceLocation registryName = BuiltInRegistries.BLOCK.getKey(block);
        return registryName != null ? registryName.toString() : "unknown_block";
    }

    public static Block getBlockByName(String blockName) {
        ResourceLocation resourceLocation = new ResourceLocation(blockName);
        return BuiltInRegistries.BLOCK.get(resourceLocation);
    }
}

