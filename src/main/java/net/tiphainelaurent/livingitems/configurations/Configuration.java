package net.tiphainelaurent.livingitems.configurations;

import me.sargunvohra.mcmods.autoconfig1u.serializer.PartitioningSerializer;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.TransitiveObject;

import net.tiphainelaurent.livingitems.LivingItems;

@Config(name=LivingItems.MOD_ID)
public class Configuration extends PartitioningSerializer.GlobalData
{
    @TransitiveObject
    public GeneralConfiguration general = new GeneralConfiguration();

    @TransitiveObject
    public HelmetConfiguration helmet = new HelmetConfiguration();

    @TransitiveObject
    public ChestplateConfiguration chestplate = new ChestplateConfiguration();

    @TransitiveObject
    public LeggingsConfiguration leggings = new LeggingsConfiguration();

    @TransitiveObject
    public BootsConfiguration boots = new BootsConfiguration();
}
