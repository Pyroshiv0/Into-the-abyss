package com.pyroshiv.arsabyssaux.common.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class RegistryWrapper<T> implements Supplier<T>, ItemLike {
   public RegistryObject<T> registryObject;

   public RegistryWrapper(RegistryObject<T> registryObject) {
      this.registryObject = registryObject;
   }

   @NotNull
   public T get() {
      return this.registryObject.get();
   }

   @Override
   public Item asItem() {
      Object current = this.registryObject.get();
      if (current instanceof ItemLike) {
         ItemLike itemLike = (ItemLike)current;
         return itemLike.asItem();
      } else {
         throw new IllegalStateException("RegistryWrapper is not an Item");
      }
   }

   public String getRegistryName() {
      return this.registryObject.getId().getNamespace();
   }

   public BlockState defaultBlockState() {
      Object current = this.registryObject.get();
      if (current instanceof Block) {
         Block block = (Block)current;
         return block.defaultBlockState();
      } else {
         throw new IllegalStateException("RegistryWrapper is not a Block");
      }
   }


}
