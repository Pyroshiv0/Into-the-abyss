package com.pyroshiv.arsabyssaux.common.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.stream.Stream;

public enum CorruptingEnum {
    STONE_TO_COBBLESTONE("minecraft:stone", "minecraft:cobblestone"),
    SAND_TO_GLASS("minecraft:sand", "minecraft:glass"),
    OAK_LOG_TO_OAK_PLANKS("minecraft:oak_log", "minecraft:oak_planks"),
    IRON_ORE_TO_IRON_INGOT("minecraft:iron_ore", "minecraft:iron_block");

    private final String blockStart;
    private final String blockEnd;

    CorruptingEnum(String blockStart,String blockEnd) {
        this.blockStart = blockStart;
        this.blockEnd = blockEnd;
    }

    public static String getBlockToConvert(String blockStart) {
        return Arrays.stream(CorruptingEnum.values())
                .filter(element -> element.blockStart.equals(blockStart))
                .findFirst()
                .map(CorruptingEnum::getBlockEnd)
                .orElse(null);//block not in list
    }

    public String getBlockStart() {
        return blockStart;
    }

    public String getBlockEnd() {
        return blockEnd;
    }
}
