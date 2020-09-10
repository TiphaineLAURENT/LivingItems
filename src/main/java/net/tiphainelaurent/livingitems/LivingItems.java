package net.tiphainelaurent.livingitems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import java.util.Random;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.PartitioningSerializer;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;

import net.tiphainelaurent.livingitems.configurations.Configuration;
import net.tiphainelaurent.livingitems.items.LivingBoots;
import net.tiphainelaurent.livingitems.items.LivingChestplate;
import net.tiphainelaurent.livingitems.items.LivingHelmet;
import net.tiphainelaurent.livingitems.items.LivingLeggings;

public class LivingItems implements ModInitializer
{
	public static final String MOD_ID = "livingitems";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID))
																	 .icon(() -> new ItemStack(Items.DEAD_FIRE_CORAL))
																	 .build();

	public static Configuration config;
	public static final Random random = new Random();

	@Override
	public void onInitialize()
	{
		AutoConfig.register(Configuration.class, PartitioningSerializer.wrap(Toml4jConfigSerializer::new));
		config = AutoConfig.getConfigHolder(Configuration.class).getConfig();

		Registry.register(Registry.ITEM, LivingHelmet.ID, new LivingHelmet());
		Registry.register(Registry.ITEM, LivingChestplate.ID, new LivingChestplate());
		Registry.register(Registry.ITEM, LivingLeggings.ID, new LivingLeggings());
		Registry.register(Registry.ITEM, LivingBoots.ID, new LivingBoots());
	}
}
