package com.pyroshiv.arsabyssaux.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.junit.jupiter.api.Test;
import com.pyroshiv.arsabyssaux.common.block.CorruptingEnum;

import static org.junit.jupiter.api.Assertions.*;

class CorruptingEnumTest {

    @Test
    void testgetBlockToConvert_ValidBlocks() {
        // Test valid mappings
        assertEquals("minecraft:cobblestone", CorruptingEnum.getBlockToConvert("minecraft:stone"));
        assertEquals("minecraft:glass", CorruptingEnum.getBlockToConvert("minecraft:sand"));
        assertEquals("minecraft:oak_planks", CorruptingEnum.getBlockToConvert("minecraft:oak_log"));
        assertEquals("minecraft:iron_block", CorruptingEnum.getBlockToConvert("minecraft:iron_ore"));
    }


    @Test
    void testgetBlockToConvert_InvalidBlock() {
        // Test an invalid block
        assertNull(CorruptingEnum.getBlockToConvert("minecraft:firegoat"));
    }

    @Test
    void testgetBlockToConvert_NullInput() {
        // Test null input
        assertNull(CorruptingEnum.getBlockToConvert(null));
    }

    @Test
    void testEnumValues_FirstAndSecondBlocks() {
        // Validate that each enum constant has the expected blocks
        for (CorruptingEnum pair : CorruptingEnum.values()) {
            assertNotNull(pair.getBlockStart(), "First block should not be null");
            assertNotNull(pair.getBlockEnd(), "Second block should not be null");
        }
    }
}