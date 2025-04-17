package com.github.albardoo02;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class AssyukuGuiCommandTabCompleter implements TabCompleter {

    AssyukuGUI plugin;
    public AssyukuGuiCommandTabCompleter(AssyukuGUI plugin){
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String commandLable, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("nogui");
            completions.add("stone");
            completions.add("cobblestone");
            completions.add("end_stone");
            completions.add("netherrack");
            completions.add("wheat");
            completions.add("wheat_seeds");
            completions.add("carrot");
            completions.add("potato");
            completions.add("cod");
            completions.add("salmon");
            completions.add("tropical_fish");
            completions.add("pufferfish");
            completions.add("ender_pearl");
            completions.add("rotten_flesh");
            completions.add("bone");
            completions.add("gunpowder");
            completions.add("string");
            completions.add("oak_log");
            completions.add("spruce_log");
            completions.add("birch_log");
            completions.add("jungle_log");
            completions.add("acacia_log");
            completions.add("dark_oak_log");
            completions.add("redstone");
            completions.add("lapis_lazuli");
            completions.add("gold_ingot");
            completions.add("iron_ingot");
            completions.add("diamond");
            completions.add("coal");
            completions.add("emerald");
            completions.add("redstone_block");
            completions.add("lapis_block");
            completions.add("gold_block");
            completions.add("iron_block");
            completions.add("diamond_block");
            completions.add("coal_block");
        }
        return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
    }
}
