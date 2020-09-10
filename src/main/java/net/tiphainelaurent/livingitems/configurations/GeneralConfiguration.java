package net.tiphainelaurent.livingitems.configurations;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.BoundedDiscrete;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name="general")
public class GeneralConfiguration implements ConfigData
{
    @Comment("Chance [0-100] a living item will talk")
    @BoundedDiscrete(min=0, max=100)
    public int talkingChance = 5;
}
