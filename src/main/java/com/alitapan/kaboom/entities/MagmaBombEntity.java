package com.alitapan.kaboom.entities;

import com.alitapan.kaboom.init.ItemInit;
import com.alitapan.kaboom.init.ModEntityTypes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class MagmaBombEntity extends ProjectileItemEntity {
	
    public MagmaBombEntity(EntityType<? extends MagmaBombEntity> p_i50159_1_, World p_i50159_2_) {
    	super(p_i50159_1_, p_i50159_2_);
	}
    public MagmaBombEntity(World worldIn, LivingEntity throwerIn) {
        super(ModEntityTypes.MAGMA_BOMB_ENTITY.get(), throwerIn, worldIn);
    }

    public MagmaBombEntity(World worldIn, double x, double y, double z) {
        super(ModEntityTypes.MAGMA_BOMB_ENTITY.get(), x, y, z, worldIn);
    } 
    
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
		// TODO Auto-generated method stub
		
	}

}
