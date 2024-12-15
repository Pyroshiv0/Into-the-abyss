package com.pyroshiv.arsabyssaux.setup;

import com.pyroshiv.arsabyssaux.setup.registry.BlockRegistry;
import com.pyroshiv.arsabyssaux.setup.registry.CreativeTabRegistry;
import com.pyroshiv.arsabyssaux.setup.registry.ItemsRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;

import java.util.Objects;

public class ModSetup {
    public static void registers(IEventBus modEventBus) {
        ItemsRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        BlockRegistry.BLOCK_ENTITIES.register(modEventBus);
        //BlockRegistry.BS_PROVIDERS.register(modEventBus);
        CreativeTabRegistry.TABS.register(modEventBus);
    }

    public static void registerEvents(RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.BLOCKS)) {
            IForgeRegistry<Block> registry = Objects.requireNonNull(event.getForgeRegistry());
            BlockRegistry.onBlocksRegistry(registry);
        }
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
            IForgeRegistry<Item> registry = Objects.requireNonNull(event.getForgeRegistry());
            BlockRegistry.onBlockItemsRegistry(registry);
            ItemsRegistry.onItemRegistry(registry);
        }
    }
}
