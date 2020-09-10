package net.tiphainelaurent.livingitems.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.livingitems.LivingItems;

public class LivingLeggings extends LivingArmor
{
    public static final Identifier ID = new Identifier(LivingItems.MOD_ID, "living_leggings");

    public LivingLeggings()
    {
        super(EquipmentSlot.LEGS);
    }
}
