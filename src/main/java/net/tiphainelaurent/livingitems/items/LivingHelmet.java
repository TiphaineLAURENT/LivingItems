package net.tiphainelaurent.livingitems.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.livingitems.LivingItems;

public class LivingHelmet extends LivingArmor
{
    public static final Identifier ID = new Identifier(LivingItems.MOD_ID, "living_helmet");

    public LivingHelmet()
    {
        super(EquipmentSlot.HEAD);
    }
}
