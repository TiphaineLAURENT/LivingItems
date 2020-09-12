package net.tiphainelaurent.livingitems.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.tiphainelaurent.livingitems.LivingItems;
import net.tiphainelaurent.livingitems.configurations.ChestplateConfiguration;

@Mixin(PlayerEntity.class)
public class OnTakeDamage
{

    final ChestplateConfiguration configuration = LivingItems.config.chestplate;

	@Environment(EnvType.CLIENT)
	@Inject(method = "damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", at = @At(value = "TAIL", target = "net/minecraft/entity/player/PlayerEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
	private boolean onTakeDamage(final DamageSource damageSource, final float amount, final CallbackInfoReturnable<Boolean> info)
	{
        final PlayerEntity player = (PlayerEntity)(Object)this;
        if (player.hasStackEquipped(EquipmentSlot.CHEST))
		{
            int talkingChance = LivingItems.config.general.talkingChance;
            final String sourceName = damageSource.getName();
            if (sourceName == "hotFloor")
            {
                talkingChance = configuration.hotFloorTalkingChance;
            }
            else if (sourceName == "cactus")
            {
                talkingChance = configuration.cactusTalkingChance;
            }
			final ItemStack chestplate = player.getEquippedStack(EquipmentSlot.HEAD);
			final CompoundTag chestplate_tag = chestplate.getTag();
			if (chestplate_tag.contains("livings") && LivingItems.random.nextInt(100) <= talkingChance)
			{
				final String sentence = configuration.damageSentences.get(LivingItems.random.nextInt(configuration.damageSentences.size()));
				player.sendMessage(Text.of(sentence), false);
			}
        }
        return true;
    }
}
