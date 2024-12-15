package com.pyroshiv.arsabyssaux.setup.registry;

import com.hollingsworth.arsnouveau.common.items.ModBlockItem;
import com.hollingsworth.arsnouveau.common.world.tree.SupplierBlockStateProvider;
import com.pyroshiv.arsabyssaux.common.block.CorrupterBlock;
import com.pyroshiv.arsabyssaux.common.block.tile.CorrupterTile;
import com.pyroshiv.arsabyssaux.setup.registry.ItemsRegistry;
import com.pyroshiv.arsabyssaux.common.block.DrainJar;
import com.pyroshiv.arsabyssaux.common.block.tile.DrainJarTile;
import com.pyroshiv.arsabyssaux.common.util.RegistryWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegistry {
   public static Properties woodProp;
   public static final DeferredRegister<Block> BLOCKS;
   public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES;
   public static final DeferredRegister<BlockStateProviderType<?>> BS_PROVIDERS;
   public static final RegistryObject<BlockStateProviderType<?>> stateProviderType;

   public static RegistryWrapper<CorrupterBlock> CORRUPTER_BLOCK;
   public static RegistryWrapper<DrainJar> DRAIN_JAR;
   public static RegistryWrapper<BlockEntityType<DrainJarTile>> DRAIN_JAR_TILE;
   public static RegistryWrapper<BlockEntityType<CorrupterTile>> CORRUPTER_TILE;

   /* public static Properties LOG_PROP;
   public static Properties SAP_PROP;
   public static RegistryWrapper<MageBlock> MAGE_BLOCK;
   public static RegistryWrapper<BlockEntityType<MageBlockTile>> MAGE_BLOCK_TILE;
   public static RegistryWrapper<LightBlock> LIGHT_BLOCK;

   public static RegistryWrapper<BlockEntityType<ArchwoodChestTile>> ARCHWOOD_CHEST_TILE;
   public static RegistryWrapper<SpellPrismBlock> SPELL_PRISM;
   public static RegistryWrapper<WhirlisprigFlower> WHIRLISPRIG_FLOWER;

   public static RegistryWrapper<RepositoryBlock> REPOSITORY;
   public static RegistryWrapper<BlockEntityType<RepositoryTile>> REPOSITORY_TILE;
   public static RegistryWrapper<FalseWeave> FALSE_WEAVE;

   public static final RegistryWrapper<BrazierRelay> BRAZIER_RELAY;
   public static final RegistryWrapper<CraftingLecternBlock> CRAFTING_LECTERN;
   public static final RegistryWrapper<ArcanePedestal> ARCANE_PEDESTAL;
   public static final RegistryWrapper<BlockEntityType<ArcanePedestalTile>> ARCANE_PEDESTAL_TILE;
   public static final RegistryWrapper<BlockEntityType<MagelightTorchTile>> MAGELIGHT_TORCH_TILE;
   public static final RegistryWrapper<RitualBrazierBlock> RITUAL_BLOCK;
   public static final RegistryWrapper<SkyWeave> SKY_WEAVE;
   public static final RegistryWrapper<TemporaryBlock> TEMPORARY_BLOCK;
   public static final RegistryWrapper<ItemDetector> ITEM_DETECTOR;
   public static final RegistryWrapper<BlockEntityType<RitualBrazierTile>> RITUAL_TILE;
   public static final RegistryWrapper<BlockEntityType<BrazierRelayTile>> BRAZIER_RELAY_TILE;
   public static final RegistryWrapper<BlockEntityType<SkyBlockTile>> SKYWEAVE_TILE;
   public static final RegistryWrapper<BlockEntityType<TemporaryTile>> TEMPORARY_TILE;
   public static final RegistryWrapper<BlockEntityType<CraftingLecternTile>> CRAFTING_LECTERN_TILE;
   */
   public static void onBlocksRegistry(IForgeRegistry<Block> registry) {
      /*String[] DECORATIVE_SOURCESTONE_LIST = LibBlockNames.DECORATIVE_SOURCESTONE;
      int size = DECORATIVE_SOURCESTONE_LIST.length;

      int i;
      String s;
      for(i = 0; i < size; ++i) {
         s = DECORATIVE_SOURCESTONE_LIST[i];
         if (LibBlockNames.DIRECTIONAL_SOURCESTONE.contains(s)) {
            registry.register(s, new DirectionalModBlock());
         } else {
            registry.register(s, new ModBlock());
         }
      }

      Iterator var5 = LibBlockNames.DECORATIVE_SLABS.iterator();

      while(var5.hasNext()) {
         String s = (String)var5.next();
         registry.register(s, new SlabBlock(Properties.m_284310_().m_60913_(1.5F, 6.0F).m_60918_(SoundType.f_56742_)));
      }

      var1 = LibBlockNames.DECORATIVE_SOURCESTONE;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         s = var1[var3];
         registry.register(s + "_stairs", new StairBlock(() -> {
            return ((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation("ars_nouveau", s))).m_49966_();
         }, Properties.m_284310_().m_60913_(1.5F, 6.0F).m_60918_(SoundType.f_56742_)));
      }

      registry.register(LibBlockNames.Pot("magebloom_crop"), createPottedBlock(() -> {
         return (Block)MAGE_BLOOM_CROP.get();
      }));
      registry.register(LibBlockNames.Pot("red_archwood_sapling"), createPottedBlock(() -> {
         return (Block)BLAZING_SAPLING.get();
      }));
      registry.register(LibBlockNames.Pot("blue_archwood_sapling"), createPottedBlock(() -> {
         return (Block)CASCADING_SAPLING.get();
      }));
      registry.register(LibBlockNames.Pot("green_archwood_sapling"), createPottedBlock(() -> {
         return (Block)FLOURISHING_SAPLING.get();
      }));
      registry.register(LibBlockNames.Pot("purple_archwood_sapling"), createPottedBlock(() -> {
         return (Block)VEXING_SAPLING.get();
      }));*/
   }

   /*
   public static MagicLeaves createLeavesBlock(MapColor color) {
      return new MagicLeaves(Properties.m_284310_().m_284180_(color).m_60978_(0.2F).m_60977_().m_60918_(SoundType.f_56740_).m_60955_().m_60922_(BlockRegistry::allowsSpawnOnLeaves).m_60960_(BlockRegistry::isntSolid).m_60971_(BlockRegistry::isntSolid).m_278166_(PushReaction.DESTROY).m_60924_(BlockRegistry::isntSolid).m_278183_());
   }special tree?*/

   public static void onBlockItemsRegistry(IForgeRegistry<Item> registry) {/*
      String[] var1 = LibBlockNames.DECORATIVE_SOURCESTONE;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         String s = var1[var3];
         ItemsRegistry.ITEMS.register(s, () -> {
            return getDefaultBlockItem((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation("ars_nouveau", s)));
         });
      }

      Iterator var5 = LibBlockNames.DECORATIVE_STAIRS.iterator();

      String s;
      while(var5.hasNext()) {
         s = (String)var5.next();
         ItemsRegistry.ITEMS.register(s, () -> {
            return getDefaultBlockItem((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation("ars_nouveau", s)));
         });
      }

      var5 = LibBlockNames.DECORATIVE_SLABS.iterator();

      while(var5.hasNext()) {
         s = (String)var5.next();
         ItemsRegistry.ITEMS.register(s, () -> {
            return getDefaultBlockItem((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation("ars_nouveau", s)));
         });
      }
      */
   }

   public static ModBlockItem getDefaultBlockItem(Block block) {
      return new ModBlockItem(block, ItemsRegistry.defaultItemProperties());
   }
   /*
   private static Boolean allowsSpawnOnLeaves(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
      return entity == EntityType.f_20505_ || entity == EntityType.f_20508_;
   }*/

   private static boolean isntSolid(BlockState state, BlockGetter reader, BlockPos pos) {
      return false;
   }

   public static Block getBlock(String blockName) {
      return (Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation("ars_abyssaux", blockName));
   }

   public static <T extends Block> RegistryWrapper<T> registerBlock(String name, Supplier<T> blockSupp) {
      return new RegistryWrapper(BLOCKS.register(name, blockSupp));
   }

   public static <T extends Block> RegistryWrapper<T> registerBlockAndItem(String name, Supplier<T> blockSupp) {
      RegistryWrapper<T> blockReg = new RegistryWrapper(BLOCKS.register(name, blockSupp));
      ItemsRegistry.ITEMS.register(name, () -> {
         return getDefaultBlockItem((Block)blockReg.get());
      });
      return blockReg;
   }

   public static <T extends Block> RegistryWrapper<T> registerBlockAndItem(String name, Supplier<T> blockSupp, Function<RegistryWrapper<T>, Item> blockItemFunc) {
      RegistryWrapper<T> blockReg = new RegistryWrapper(BLOCKS.register(name, blockSupp));
      ItemsRegistry.ITEMS.register(name, () -> {
         return (Item)blockItemFunc.apply(blockReg);
      });
      return blockReg;
   }
   /*
   public static FlowerPotBlock createPottedBlock(Supplier<? extends Block> block) {
      FlowerPotBlock pot = new FlowerPotBlock(() -> {
         return (FlowerPotBlock)Blocks.f_50276_;
      }, block, Properties.m_284310_().m_60966_().m_60955_());
      flowerPots.put(() -> {
         return ForgeRegistries.BLOCKS.getKey((Block)block.get());
      }, pot);
      return pot;
   }*/

   public static <T extends BlockEntityType> RegistryWrapper<T> registerTile(String regName, BlockEntitySupplier tile, RegistryWrapper<? extends Block> block) {
      return new RegistryWrapper(BLOCK_ENTITIES.register(regName, () -> {
         return Builder.of(tile, new Block[]{(Block)block.get()}).build((null));
      }));
   }

   static {
      //woodProp = Properties.m_284310_().m_60913_(2.0F, 3.0F).m_278183_().m_284180_(MapColor.f_283825_).m_60918_(SoundType.f_56736_);
      BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "ars_abyssaux");
      BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "ars_abyssaux");
      BS_PROVIDERS = DeferredRegister.create(ForgeRegistries.BLOCK_STATE_PROVIDER_TYPES, "ars_abyssaux");
      stateProviderType = BS_PROVIDERS.register("an_stateprovider", () -> {
         return new BlockStateProviderType(SupplierBlockStateProvider.CODEC);
      });
      DRAIN_JAR = registerBlockAndItem("drain_jar", DrainJar::new);
      CORRUPTER_BLOCK=registerBlockAndItem("corrupter_block", CorrupterBlock::new);

      DRAIN_JAR_TILE = registerTile("drain_jar", DrainJarTile::new, DRAIN_JAR);
      CORRUPTER_TILE= registerTile("corrupter_block",CorrupterTile::new,CORRUPTER_BLOCK);

      //CREATIVE_SOURCE_JAR = registerBlockAndItem("creative_source_jar", CreativeSourceJar::new);
      //CREATIVE_SOURCE_JAR_TILE = registerTile("creative_source_jar", CreativeSourceJarTile::new, CREATIVE_SOURCE_JAR);

   }
}
