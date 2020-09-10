package net.tiphainelaurent.livingitems.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

import net.tiphainelaurent.livingitems.LivingItems;

public class LivingBoots extends LivingArmor
{
    public static final Identifier ID = new Identifier(LivingItems.MOD_ID, "living_boots");

    public LivingBoots()
    {
        super(EquipmentSlot.FEET);
    }
}
