package com.alitapan.kaboom;

import com.alitapan.kaboom.init.ModEntityTypes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("kaboom")
public class Kaboom
{
    public static final String MOD_ID = "kaboom";
    public static Kaboom instance;
 
    public Kaboom() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	
    	// Register entity types
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        
        instance= this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){}
    private void doClientStuff(final FMLClientSetupEvent event) {}
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {}

}
