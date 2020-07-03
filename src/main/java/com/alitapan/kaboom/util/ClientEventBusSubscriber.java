package com.alitapan.kaboom.util;

import com.alitapan.kaboom.Kaboom;
import com.alitapan.kaboom.init.ModEntityTypes;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Kaboom.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber{
		
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
		// Register sprite for Iron Bomb
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IRON_BOMB_ENTITY.get(), new IRenderFactory<Entity>()
		{
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public EntityRenderer<? super Entity> createRenderFor(EntityRendererManager manager)
			  {
			  	return new SpriteRenderer(manager, Minecraft.getInstance().getItemRenderer());
			  }
			});
		
		// Register sprite for Magma Bomb
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MAGMA_BOMB_ENTITY.get(), new IRenderFactory<Entity>()
		{
			  @SuppressWarnings({ "rawtypes", "unchecked" })
			  public EntityRenderer<? super Entity> createRenderFor(EntityRendererManager manager)
			  {
			  	return new SpriteRenderer(manager, Minecraft.getInstance().getItemRenderer());
			  }
			});
		
	
		// Register sprite for Ender Bomb
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENDER_BOMB_ENTITY.get(), new IRenderFactory<Entity>()
		{
			  @SuppressWarnings({ "rawtypes", "unchecked" })
			  public EntityRenderer<? super Entity> createRenderFor(EntityRendererManager manager)
			  {
			  	return new SpriteRenderer(manager, Minecraft.getInstance().getItemRenderer());
			  }
			});
	}

}

