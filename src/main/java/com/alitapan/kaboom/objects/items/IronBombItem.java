package com.alitapan.kaboom.objects.items;


import com.alitapan.kaboom.entities.IronBombEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class IronBombItem extends GenericBombItem {

	public IronBombItem(Properties properties) {
		super(properties);
	}
	
   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      ItemStack itemstack = playerIn.getHeldItem(handIn);
      worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
      if (!worldIn.isRemote) {
    	  IronBombEntity ironbombEntity = new IronBombEntity(worldIn, playerIn);
    	 ironbombEntity.setItem(itemstack);
    	 ironbombEntity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
         worldIn.addEntity(ironbombEntity);
      }

      playerIn.addStat(Stats.ITEM_USED.get(this));
      if (!playerIn.abilities.isCreativeMode) {
         itemstack.shrink(1);
      }

      return ActionResult.resultSuccess(itemstack);
   }

}
