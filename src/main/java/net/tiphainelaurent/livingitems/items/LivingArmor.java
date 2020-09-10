package net.tiphainelaurent.livingitems.items;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.item.ArmorItem;

import net.tiphainelaurent.livingitems.LivingItems;

public class LivingArmor extends ArmorItem
{
    public LivingArmor(final EquipmentSlot slot) {
        super(LivingArmorMaterials.LIVING, slot,
                new Item.Settings().group(ItemGroup.COMBAT).group(LivingItems.ITEM_GROUP));
    }

    @Override
    public void appendTooltip(final ItemStack itemStack, final World world, final List<Text> tooltips,
            final TooltipContext tooltipContext) {
        tooltips.add(new TranslatableText("item.livingitems.armors.tooltip"));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendStacks(final ItemGroup itemGroup, final DefaultedList<ItemStack> stacks)
    {
        if (!this.isIn(itemGroup))
        {
            return;
        }

        final ItemStack stack = new ItemStack(this);
        final CompoundTag tag = new CompoundTag();
        tag.putBoolean("livings", true);
        stack.setTag(tag);

        stacks.add(stack);
    }
}
