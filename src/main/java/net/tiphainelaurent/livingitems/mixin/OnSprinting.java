package net.tiphainelaurent.livingitems.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.tiphainelaurent.livingitems.LivingItems;

@Mixin(PlayerEntity.class)
public class OnSprinting
{

	@Environment(EnvType.CLIENT)
	@Inject(method = "increaseStat(Lnet/minecraft/util/Identifier;I)V", at = @At(value = "TAIL"))
	private void onSprinting(final Identifier stat, final int amount, final CallbackInfo info)
	{
        final PlayerEntity player = PlayerEntity.class.cast(this);
        if (stat == Stats.SPRINT_ONE_CM)
        {
            if (player.hasStackEquipped(EquipmentSlot.LEGS))
            {
                final ItemStack leggings = player.getEquippedStack(EquipmentSlot.HEAD);
                final CompoundTag leggings_tag = leggings.getTag();
                if (leggings_tag.contains("livings") && LivingItems.random.nextInt(100) <= LivingItems.config.leggings.sprintTalkingChance)
                {
                    final String sentence = LivingItems.config.leggings.sprintSentences.get(LivingItems.random.nextInt(LivingItems.config.leggings.sprintSentences.size()));
                    player.sendMessage(Text.of(sentence), false);
                }
            }
        }
    }
}
