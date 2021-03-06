package com.infinityraider.agricraft.reference;

import com.infinityraider.infinitylib.block.blockstate.InfinityProperty;
import net.minecraft.block.properties.PropertyInteger;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

/**
 * A class containing AgriCraft block state properties, most of these are unlisted
 */
public interface AgriProperties {
	InfinityProperty<Boolean> JOURNAL = new InfinityProperty<>(PropertyBool.create("journal"), false);
	InfinityProperty<EnumFacing> FACING = new InfinityProperty<>(PropertyDirection.create("facing"), EnumFacing.NORTH);

	InfinityProperty<Boolean> CROSSCROP = new InfinityProperty<>(PropertyBool.create("crosscrop"), false);
	InfinityProperty<Boolean> WEEDS = new InfinityProperty<>(PropertyBool.create("weeds"), false);
	InfinityProperty<Boolean> PLANT = new InfinityProperty<>(PropertyBool.create("plant"), false);
    InfinityProperty<Integer> GROWTHSTAGE = new InfinityProperty<>(PropertyInteger.create("age", 0, 7), 0);

	InfinityProperty<Integer> VINES = new InfinityProperty<>(PropertyInteger.create("age", 0, 3), 0);
}
