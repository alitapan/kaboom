package com.alitapan.kaboom.entities;

import com.alitapan.kaboom.init.ItemInit;
import com.alitapan.kaboom.init.ModEntityTypes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class IronBombEntity extends ProjectileItemEntity {
	
    public IronBombEntity(EntityType<? extends IronBombEntity> p_i50159_1_, World p_i50159_2_) {
    	super(p_i50159_1_, p_i50159_2_);
	}
    public IronBombEntity(World worldIn, LivingEntity throwerIn) {
        super(ModEntityTypes.IRON_BOMB_ENTITY.get(), throwerIn, worldIn);
    }

    public IronBombEntity(World worldIn, double x, double y, double z) {
        super(ModEntityTypes.IRON_BOMB_ENTITY.get(), x, y, z, worldIn);
    } 
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public IPacket createSpawnPacket() {
       return NetworkHooks.getEntitySpawningPacket(this);
    }
    
    @Override
    protected Item getDefaultItem() {
        return ItemInit.iron_bomb;
    }
	   
	@Override
	protected void onImpact(RayTraceResult result) {
	    this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.00625D), this.getPosZ(), 4.0F, Explosion.Mode.BREAK);
	    if (!this.world.isRemote) {
		      this.world.setEntityState(this, (byte)3);
		      this.remove();
		   }
		
	}
}
