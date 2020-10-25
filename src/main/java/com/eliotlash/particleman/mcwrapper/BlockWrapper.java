package com.eliotlash.particleman.mcwrapper;

import com.eliotlash.particlelib.mcwrapper.IBlock;
import com.eliotlash.particlelib.mcwrapper.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockWrapper<T extends Block> implements IBlock {
    T block;

    public BlockWrapper(T block) {
        this.block = block;
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return ConversionUtils.concreteToAbstractRL(ForgeRegistries.BLOCKS.getKey(block));
    }
}
