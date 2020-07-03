package com.alitapan.kaboom.entities;

import com.alitapan.kaboom.init.ItemInit;
import com.alitapan.kaboom.init.ModEntityTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class MagmaBombEntity extends ProjectileItemEntity {
	
	// CONSTRUCTORS
	// --------------------------------------------------------------------------------------------//
    public MagmaBombEntity(EntityType<? extends MagmaBombEntity> p_i50159_1_, World p_i50159_2_) {
    	super(p_i50159_1_, p_i50159_2_);
	}
    public MagmaBombEntity(World worldIn, LivingEntity throwerIn) {
    	super(ModEntityTypes.MAGMA_BOMB_ENTITY.get(), throwerIn, worldIn);
    }

    public MagmaBombEntity(World worldIn, double x, double y, double z) {
        super(ModEntityTypes.MAGMA_BOMB_ENTITY.get(), x, y, z, worldIn);
    }
    
    // --------------------------------------------------------------------------------------------//
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public IPacket createSpawnPacket() {
    	return NetworkHooks.getEntitySpawningPacket(this);
    }
   
    @Override
    protected Item getDefaultItem() {
        return ItemInit.magma_bomb;
    }
	   
	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.getType() != RayTraceResult.Type.ENTITY || !((EntityRayTraceResult)result).getEntity().isEntityEqual(this.owner)) {
			if (!this.world.isRemote) {
	        	 
				// Spawn lava block upon collision
	        	Block lavaBlock = Blocks.LAVA;
	            BlockPos lavaPos = new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ());
	            BlockState lavaState = lavaBlock.getDefaultState();
	            this.world.setBlockState(lavaPos, lavaState);
	            }
	         
			// Play the "Fire Charge Event" and remove the entity
			this.world.playEvent(1018, new BlockPos(this), 0);
	        this.remove();
	         
		}
	}

}
