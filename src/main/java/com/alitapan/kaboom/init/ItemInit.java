package com.alitapan.kaboom.init;

import com.alitapan.kaboom.Kaboom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Kaboom.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Kaboom.MOD_ID)
public class ItemInit {
	

	// Item Bombs
	public static final Item iron_bomb = null;
	public static final Item magma_bomb = null;
	public static final Item ender_bomb = null;
	
	// Block Bombs
	public static final Item highly_reactive_entity = null;
	
	
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		
		// Firebombs
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("iron_bomb"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("magma_bomb"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ender_bomb"));

		
	}

}
