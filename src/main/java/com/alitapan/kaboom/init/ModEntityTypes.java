package com.alitapan.kaboom.init;


import com.alitapan.kaboom.Kaboom;
import com.alitapan.kaboom.entities.EnderBombEntity;
import com.alitapan.kaboom.entities.IronBombEntity;
import com.alitapan.kaboom.entities.MagmaBombEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Kaboom.MOD_ID);
	
	public static final RegistryObject<EntityType<? extends IronBombEntity>> IRON_BOMB_ENTITY = ENTITY_TYPES.register("iron_bomb", () -> EntityType.Builder.<IronBombEntity>create(IronBombEntity::new, EntityClassification.MISC)
			.size(0.9f, 1.3f)
			.build(new ResourceLocation(Kaboom.MOD_ID, "iron_bomb").toString()));
	
	public static final RegistryObject<EntityType<? extends MagmaBombEntity>> MAGMA_BOMB_ENTITY = ENTITY_TYPES.register("magma_bomb", () -> EntityType.Builder.<MagmaBombEntity>create(MagmaBombEntity::new, EntityClassification.MISC)
			.size(0.9f, 1.3f)
			.build(new ResourceLocation(Kaboom.MOD_ID, "magma_bomb").toString()));
	
	public static final RegistryObject<EntityType<? extends EnderBombEntity>> ENDER_BOMB_ENTITY = ENTITY_TYPES.register("ender_bomb", () -> EntityType.Builder.<EnderBombEntity>create(EnderBombEntity::new, EntityClassification.MISC)
			.size(0.9f, 1.3f)
			.build(new ResourceLocation(Kaboom.MOD_ID, "ender_bomb").toString()));
	
}
