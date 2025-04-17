package com.github.albardoo02;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class AssyukuGUI extends JavaPlugin {

    private GuiHandler guiHandler;
    private final Map<UUID, Integer> playerPages = new HashMap<>();

    @Override
    public void onEnable() {

        this.guiHandler = new GuiHandler(this);
        this.getCommand("ragui").setExecutor(new AssyukuGuiCommandExecutor(guiHandler));
        this.getCommand("ragui").setTabCompleter(new AssyukuGuiCommandTabCompleter(this));
        this.getServer().getPluginManager().registerEvents(guiHandler, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
