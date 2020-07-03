package com.alitapan.kaboom.entities;

import java.util.List;

import com.alitapan.kaboom.init.ItemInit;
import com.alitapan.kaboom.init.ModEntityTypes;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EnderBombEntity extends ProjectileItemEntity {
    public EnderBombEntity(EntityType<? extends EnderBombEntity> p_i50159_1_, World p_i50159_2_) {
    	super(p_i50159_1_, p_i50159_2_);
	}
    public EnderBombEntity(World worldIn, LivingEntity throwerIn) {
        super(ModEntityTypes.ENDER_BOMB_ENTITY.get(), throwerIn, worldIn);
    }

    public EnderBombEntity(World worldIn, double x, double y, double z) {
        super(ModEntityTypes.ENDER_BOMB_ENTITY.get(), x, y, z, worldIn);
    } 
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public IPacket createSpawnPacket() {
       return NetworkHooks.getEntitySpawningPacket(this);
    }
   
    @Override
    protected Item getDefaultItem() {
        return ItemInit.ender_bomb;
    }
	   
	@Override
	protected void onImpact(RayTraceResult result) {
	      RayTraceResult.Type raytraceresult$type = result.getType();
	      if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
	         BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)result;
	         BlockState blockstate = this.world.getBlockState(blockraytraceresult.getPos());
	         blockstate.onProjectileCollision(this.world, blockstate, blockraytraceresult, this);
	      }
	      if (result.getType() != RayTraceResult.Type.ENTITY || !((EntityRayTraceResult)result).getEntity().isEntityEqual(this.owner)) {
	         if (!this.world.isRemote) {
	            List<LivingEntity> list = this.world.getEntitiesWithinAABB(LivingEntity.class, this.getBoundingBox().grow(4.0D, 2.0D, 4.0D));
	            AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
	           // areaeffectcloudentity.setOwner(this.shootingEntity);
	            areaeffectcloudentity.setParticleData(ParticleTypes.DRAGON_BREATH);
	            areaeffectcloudentity.setRadius(3.0F);
	            areaeffectcloudentity.setDuration(600);
	            areaeffectcloudentity.setRadiusPerTick((7.0F - areaeffectcloudentity.getRadius()) / (float)areaeffectcloudentity.getDuration());
	            areaeffectcloudentity.addEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 10, 1));
	            if (!list.isEmpty()) {
	               for(LivingEntity livingentity : list) {
	                  double d0 = this.getDistanceSq(livingentity);
	                  if (d0 < 16.0D) {
	                     areaeffectcloudentity.setPosition(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ());
	                     break;
	                  }
	               }
	            }

	            this.world.playEvent(2006, new BlockPos(this), 0);
	            this.world.addEntity(areaeffectcloudentity);
	            this.remove();
	         }

	      }
		
	}

}
