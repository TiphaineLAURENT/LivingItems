package net.tiphainelaurent.livingitems.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.tiphainelaurent.livingitems.LivingItems;

public class PhilosophersStone extends Item
{
    public static final Identifier ID = new Identifier(LivingItems.MOD_ID, "philosophers_stone");

    public PhilosophersStone()
    {
        super(new Settings().group(LivingItems.ITEM_GROUP).maxDamage(16));
    }

    @Override
    public void appendTooltip(final ItemStack itemStack, final World world, final List<Text> tooltips,
            final TooltipContext tooltipContext)
    {
        tooltips.add(new TranslatableText("item.livingitems.philosophers_stone.tooltip"));
    }
}
