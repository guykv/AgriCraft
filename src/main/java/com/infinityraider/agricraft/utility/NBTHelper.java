package com.infinityraider.agricraft.utility;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import com.infinityraider.agricraft.reference.AgriNBT;
import javax.annotation.Nullable;

public abstract class NBTHelper {

	public static boolean listContainsStack(NBTTagList list, ItemStack stack) {
		if (stack == null || stack.getItem() == null) {
			return true;
		}
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound tagAtIndex = list.getCompoundTagAt(i);
			ItemStack stackAtIndex = ItemStack.loadItemStackFromNBT(tagAtIndex);
			if (stackAtIndex == null || stackAtIndex.getItem() == null) {
				continue;
			}
			if (stack.getItem() == stackAtIndex.getItem() && stack.getItemDamage() == stackAtIndex.getItemDamage()) {
				return true;
			}
		}
		return false;
	}

	public static void addCoordsToNBT(int[] coords, NBTTagCompound tag) {
		if (coords != null && coords.length == 3) {
			addCoordsToNBT(coords[0], coords[1], coords[2], tag);
		}
	}

	public static void addCoordsToNBT(int x, int y, int z, NBTTagCompound tag) {
		tag.setInteger(AgriNBT.X1, x);
		tag.setInteger(AgriNBT.Y1, y);
		tag.setInteger(AgriNBT.Z1, z);
	}

	public static int[] getCoordsFromNBT(NBTTagCompound tag) {
		int[] coords = null;
		if (tag.hasKey(AgriNBT.X1) && tag.hasKey(AgriNBT.Y1) && tag.hasKey(AgriNBT.Z1)) {
			coords = new int[]{tag.getInteger(AgriNBT.X1), tag.getInteger(AgriNBT.Y1), tag.getInteger(AgriNBT.Z1)};
		}
		return coords;
	}

	public static void sortStacks(NBTTagList list) {
		//clear empty tags from the list
		clearEmptyStacksFromNBT(list);
		//if the list has no or one stack, nothing has to be sorted
		if (list.tagCount() < 2) {
			return;
		}
		//sort the stacks in a new array
		ItemStack[] array = new ItemStack[list.tagCount()];
		ItemStack first;
		int index;
		for (int i = 0; i < array.length; i++) {
			index = 0;
			first = ItemStack.loadItemStackFromNBT(list.getCompoundTagAt(index));
			//find the next stack in the list
			for (int j = 0; j < list.tagCount(); j++) {
				ItemStack stackAtIndex = ItemStack.loadItemStackFromNBT(list.getCompoundTagAt(j));
				String firstName = first.getDisplayName().equalsIgnoreCase("Seeds") ? "Wheat Seeds" : first.getDisplayName();
				String stackAtIndexName = stackAtIndex.getDisplayName().equalsIgnoreCase("Seeds") ? "Wheat Seeds" : stackAtIndex.getDisplayName();
				if (firstName.compareToIgnoreCase(stackAtIndexName) > 0) {
					first = stackAtIndex;
					index = j;
				}
			}
			//set the stack at this index to the next stack in order
			array[i] = first;
			//remove the stack at this index from the list
			list.removeTag(index);
		}
		//add all the stacks in order to the list
		for (ItemStack stack : array) {
			NBTTagCompound tag = new NBTTagCompound();
			stack.writeToNBT(tag);
			list.appendTag(tag);
		}
	}

	public static void clearEmptyStacksFromNBT(NBTTagList list) {
		for (int i = list.tagCount() - 1; i >= 0; i--) {
			ItemStack stack = ItemStack.loadItemStackFromNBT(list.getCompoundTagAt(i));
			if (stack == null || stack.getItem() == null) {
				list.removeTag(i);
			}
		}
	}
	
	public static boolean hasKey(NBTTagCompound tag, String... keys) {
		if (tag == null) {
			return false;
		}
		for (String key : keys) {
			if (!tag.hasKey(key)) {
				return false;
			}
		}
		return true;
	}
	
	@Nullable
	public static NBTTagCompound asTag(Object obj) {
		if (obj instanceof ItemStack) {
			return ((ItemStack) obj).getTagCompound();
		} else if (obj instanceof NBTTagCompound) {
			return (NBTTagCompound) obj;
		} else {
			return null;
		}
	}
	
}
