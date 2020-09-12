package net.tiphainelaurent.livingitems.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.screen.slot.CraftingResultSlot;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.tiphainelaurent.livingitems.LivingItems;

@Mixin(CraftingResultSlot.class)
public class OnCrafted
{
	@Shadow
	@Final
	private PlayerEntity player;

	@Environment(EnvType.CLIENT)
	@Inject(method = "onCrafted(Lnet/minecraft/item/ItemStack;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;onCraft(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;I)V"))
	private void onCrafted(final ItemStack itemStack, final CallbackInfo info)
	{
		if (player.hasStackEquipped(EquipmentSlot.HEAD))
		{
			final ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
			final CompoundTag helmet_tag = helmet.getTag();
			if (helmet_tag.contains("livings") && LivingItems.random.nextInt(100) <= LivingItems.config.general.talkingChance)
			{
				final String sentence = LivingItems.config.helmet.craftSentences.get(LivingItems.random.nextInt(LivingItems.config.helmet.craftSentences.size()));
				player.sendMessage(Text.of(sentence), false);
			}
		}

		if (player.hasStackEquipped(EquipmentSlot.LEGS))
		{
			final ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
			final CompoundTag helmet_tag = helmet.getTag();
			if (helmet_tag.contains("livings") && LivingItems.random.nextInt(100) <= LivingItems.config.general.talkingChance)
			{
				final String sentence = LivingItems.config.leggings.craftSentences.get(LivingItems.random.nextInt(LivingItems.config.helmet.craftSentences.size()));
				player.sendMessage(Text.of(sentence), false);
			}
		}

		if (player.hasStackEquipped(EquipmentSlot.FEET))
		{
			final ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
			final CompoundTag helmet_tag = helmet.getTag();
			if (helmet_tag.contains("livings") && LivingItems.random.nextInt(100) <= LivingItems.config.general.talkingChance)
			{
				final String sentence = LivingItems.config.boots.craftSentences.get(LivingItems.random.nextInt(LivingItems.config.helmet.craftSentences.size()));
				player.sendMessage(Text.of(sentence), false);
			}
		}
	}
}
