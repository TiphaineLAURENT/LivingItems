package net.tiphainelaurent.livingitems.configurations;

import java.util.Arrays;
import java.util.List;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.BoundedDiscrete;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name="chestplate")
public class ChestplateConfiguration implements ConfigData
{
    @Comment("List of sentences the living helmet can say on crafting")
    public List<String> damageSentences = Arrays.asList(
      "Don't break your bones. Oh wait! I don't care as long as I am intact",
      "Watch out! You dirty me!"
    );

    @Comment("Keep this value low as hotFloors generate lot of calls")
    @BoundedDiscrete(min=0, max=100)
    public int hotFloorTalkingChance = 1;

    @Comment("Keep this value low as cactus generate lot of calls")
    @BoundedDiscrete(min=0, max=100)
    public int cactusTalkingChance = 1;
  }
