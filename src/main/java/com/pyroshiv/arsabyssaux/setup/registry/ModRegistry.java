package com.pyroshiv.arsabyssaux.setup.registry;


import com.hollingsworth.arsnouveau.api.sound.SpellSound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRegistry {
    public static final String MODID = "ars_abyssaux";
    /*public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    */public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);


    static final String BlockRegistryKey = "minecraft:block";
    static final String BlockEntityRegistryKey = "minecraft:block_entity_type";

    static final String prepend = MODID + ":";
/*
    //Blocks
    @ObjectHolder(value = prepend + LibBlockNames.DRAIN_JAR, registryName = BlockRegistryKey)
    public static DrainJar DRAIN_JAR;

    //BlockEntities
    @ObjectHolder(value = prepend + LibBlockNames.DRAIN_JAR, registryName = BlockEntityRegistryKey)
    public static BlockEntityType<DrainJarTile> DRAIN_JAR_TILE;


    public static void registerRegistries(IEventBus bus) {
        BLOCKS.register(bus);
        BLOCK_ENTITIES.register(bus);
        ITEMS.register(bus);
        SOUNDS.register(bus);

    }*/


    //this is an example of how to register a sound. You also need to add the sound to the sound.json file, referencing your ogg files, and a texture for the button under textures/sounds.
    //this example will use one of the existing sounds randomly
    public static RegistryObject<SoundEvent> EXAMPLE_FAMILY = SOUNDS.register("example_sound", () -> makeSound("example_sound"));
    public static SpellSound EXAMPLE_SPELL_SOUND;


    static {/*
        DRAIN_JAR = BLOCKS.register(LibBlockNames.DRAIN_JAR, new DrainJar());
    */}

    static SoundEvent makeSound(String name) {
        return SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, name));
    }


}
