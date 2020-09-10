package net.tiphainelaurent.livingitems.configurations;

import java.util.Arrays;
import java.util.List;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name="chestplate")
public class ChestplateConfiguration implements ConfigData
{
    @Comment("List of sentences the living helmet can say on crafting")
    public List<String> craftSentences = Arrays.asList(
      "You finally achieve to craft something",
      "You see. Even your hands are not useless"
    );
}
