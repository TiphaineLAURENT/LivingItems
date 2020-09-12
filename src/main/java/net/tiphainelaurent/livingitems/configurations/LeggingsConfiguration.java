package net.tiphainelaurent.livingitems.configurations;

import java.util.Arrays;
import java.util.List;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.BoundedDiscrete;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name="leggings")
public class LeggingsConfiguration implements ConfigData
{
    @Comment("List of sentences the living helmet can say on crafting")
    public List<String> sprintSentences = Arrays.asList(
      "Still not out of breath ?",
      "Even my grand-mother runs faster..."
    );

    @Comment("Keep this value low as sprinting generate a lot of calls")
    @BoundedDiscrete(min=0, max=100)
    public int sprintTalkingChance = 1;
}
