package net.tiphainelaurent.livingitems.items;

import java.util.function.Supplier;
import java.lang.String;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.minecraft.item.Items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public enum LivingArmorMaterials implements ArmorMaterial
{
    LIVING("living", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    });

    private static final int[] baseDurability = {15, 17, 18, 13};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorValues;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredient;

    LivingArmorMaterials(String name, int durabilityMultiplier, int[] armorValueArr, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient)
    {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorValues = armorValueArr;
        this.enchantability = enchantability;
        this.equipSound = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    public int getDurability(EquipmentSlot equipmentSlot_1) {
        return LivingArmorMaterials.baseDurability[equipmentSlot_1.getEntitySlotId()] * this.durabilityMultiplier;
    }
 
    public int getProtectionAmount(EquipmentSlot equipmentSlot_1) {
        return this.armorValues[equipmentSlot_1.getEntitySlotId()];
    }
 
    public int getEnchantability() {
        return this.enchantability;
    }
 
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }
 
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
 
    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }
 
    public float getToughness() {
        return this.toughness;
    }
 
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
