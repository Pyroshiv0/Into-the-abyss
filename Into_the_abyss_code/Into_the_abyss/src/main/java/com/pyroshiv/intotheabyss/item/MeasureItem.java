package com.pyroshiv.intotheabyss.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;

public class MeasureItem extends Item {
    public MeasureItem() {
        super(new Item.Properties().rarity(Rarity.COMMON).durability(0));
    }
}