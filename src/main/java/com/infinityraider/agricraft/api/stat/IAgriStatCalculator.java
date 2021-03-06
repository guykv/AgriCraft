package com.infinityraider.agricraft.api.stat;


import com.infinityraider.agricraft.api.crop.IAgriCrop;
import com.infinityraider.agricraft.api.plant.IAgriPlant;
import com.infinityraider.agricraft.api.stat.IAgriStat;
import java.util.List;

/**
 * Interface to create custom Stat Calculator logic
 * use API.setStatCalculator(IStatCalculator calculator) to set the active calculator
 */
public interface IAgriStatCalculator {
    /**
     * Calculates the stats for a mutation or spread result
     * @param result an ItemStack containing the seed of the new plant
     * @param input a List containing all neighbouring crops
     * @param mutation if a mutation occurred, this is false if the plant simply spread to a cross crop
     * @return an ISeedStats object containing the resulting stats
     */
    IAgriStat calculateStats(IAgriPlant child, List<? extends IAgriCrop> input, boolean mutation);
}
