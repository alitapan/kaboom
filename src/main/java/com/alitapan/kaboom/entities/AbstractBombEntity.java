package com.alitapan.kaboom.entities;

import com.alitapan.kaboom.init.ItemInit;
import com.alitapan.kaboom.init.ModEntityTypes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AbstractBombEntity  extends ProjectileItemEntity  {
	
	   public AbstractBombEntity(EntityType<? extends AbstractBombEntity> p_i50159_1_, World p_i50159_2_) {
		      super(p_i50159_1_, p_i50159_2_);
		   }

	   public AbstractBombEntity(World worldIn, LivingEntity throwerIn) {
	      super(ModEntityTypes.IRON_BOMB_ENTITY.get(), throwerIn, worldIn);
	   }

	   public AbstractBombEntity(World worldIn, double x, double y, double z) {
	      super(ModEntityTypes.IRON_BOMB_ENTITY.get(), x, y, z, worldIn);
	   }

	   protected Item getDefaultItem() {
	      return ItemInit.iron_bomb;
	   }

	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO Auto-generated method stub
		
	}
}
