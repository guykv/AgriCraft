package com.infinityraider.agricraft.farming.cropplant;

import com.infinityraider.agricraft.api.requirment.IGrowthRequirement;
import com.infinityraider.agricraft.api.render.RenderMethod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public final class CropPlantNone extends CropPlant {
	
    public static final CropPlantNone NONE = new CropPlantNone();

    private CropPlantNone() {}

	@Override
	public String getId() {
		return "none";
	}

	@Override
	public String getPlantName() {
		return "None";
	}

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public Block getBlock() {
        return null;
    }

    @Override
    public ArrayList<ItemStack> getAllFruits() {
        return new ArrayList<>();
    }

    @Override
    public ItemStack getRandomFruit(Random rand) {
        return null;
    }

    @Override
    public ArrayList<ItemStack> getFruitsOnHarvest(int gain, Random rand) {
        return new ArrayList<>();
    }

    @Override
    public boolean canBonemeal() {
        return false;
    }

    @Override
    protected IGrowthRequirement initGrowthRequirement() {
        return null;
    }

    @Override
    public void onAllowedGrowthTick(World world, BlockPos pos, int oldGrowthStage) {

    }

    @Override
    public float getHeight(int meta) {
        return 0;
    }

    @Override
    public RenderMethod getRenderMethod() {
        return RenderMethod.HASHTAG;
    }

    @Override
    public ResourceLocation getPrimaryPlantTexture(int growthStage) {
        return null;
    }

    @Override
    public ResourceLocation getSecondaryPlantTexture(int growthStage) {
        return null;
    }

	@Override
	public ResourceLocation getSeedTexture() {
		return new ResourceLocation("agricraft:items/seed_unknown");
	}

    @Override
    public String getInformation() {
        return null;
    }
}
