
package com.pyroshiv.intotheabyss.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import com.pyroshiv.intotheabyss.init.IntoTheAbyssModFluids;

public class SulfuricWaterItem extends BucketItem {
	public SulfuricWaterItem() {
		super(IntoTheAbyssModFluids.SULFURIC_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
