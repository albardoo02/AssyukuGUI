package com.github.albardoo02;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class GuiHandler implements Listener {

    private final AssyukuGUI plugin;
    private final Map<UUID, Integer> playerPages = new HashMap<>();
    private final Map<Integer, Map<Integer, ItemStack>> pageItems = new HashMap<>();
    public GuiHandler(AssyukuGUI plugin) {
        this.plugin = plugin;
        setupItems();
    }

    private void setupItems() {
        List<String> lore2 = new ArrayList<>();
        lore2.add(ChatColor.translateAlternateColorCodes('&', "&7圧縮に必要な数: &b2"));
        lore2.add(ChatColor.translateAlternateColorCodes('&', "&6左クリック: &f上限まで圧縮"));
        lore2.add(ChatColor.translateAlternateColorCodes('&', "&6右クリック: &f1回のみ圧縮"));

        List<String> lore9 = new ArrayList<>();
        lore9.add(ChatColor.translateAlternateColorCodes('&', "&7圧縮に必要な数: &b9"));
        lore9.add(ChatColor.translateAlternateColorCodes('&', "&6左クリック: &f上限まで圧縮"));
        lore9.add(ChatColor.translateAlternateColorCodes('&', "&6右クリック: &f1回のみ圧縮"));

        List<String> lore16 = new ArrayList<>();
        lore16.add(ChatColor.translateAlternateColorCodes('&', "&7圧縮に必要な数: &b16"));
        lore16.add(ChatColor.translateAlternateColorCodes('&', "&6左クリック: &f上限まで圧縮"));
        lore16.add(ChatColor.translateAlternateColorCodes('&', "&6右クリック: &f1回のみ圧縮"));

        List<String> lore32 = new ArrayList<>();
        lore32.add(ChatColor.translateAlternateColorCodes('&', "&7圧縮に必要な数: &b32"));
        lore32.add(ChatColor.translateAlternateColorCodes('&', "&6左クリック: &f上限まで圧縮"));
        lore32.add(ChatColor.translateAlternateColorCodes('&', "&6右クリック: &f1回のみ圧縮"));

        List<String> lore48 = new ArrayList<>();
        lore48.add(ChatColor.translateAlternateColorCodes('&', "&7圧縮に必要な数: &b48"));
        lore48.add(ChatColor.translateAlternateColorCodes('&', "&6左クリック: &f上限まで圧縮"));
        lore48.add(ChatColor.translateAlternateColorCodes('&', "&6右クリック: &f1回のみ圧縮"));

        List<String> lore64 = new ArrayList<>();
        lore64.add(ChatColor.translateAlternateColorCodes('&', "&7圧縮に必要な数: &b64"));
        lore64.add(ChatColor.translateAlternateColorCodes('&', "&6左クリック: &f上限まで圧縮"));
        lore64.add(ChatColor.translateAlternateColorCodes('&', "&6右クリック: &f1回のみ圧縮"));

        List<String> helpLore = new ArrayList<>();
        helpLore.add(ChatColor.translateAlternateColorCodes('&', "&6左クリック: &f上限まで圧縮"));
        helpLore.add(ChatColor.translateAlternateColorCodes('&', "&6右クリック: &f1回のみ圧縮"));

        List<String> closeLore = new ArrayList<>();
        closeLore.add(ChatColor.translateAlternateColorCodes('&', "&7クリックで閉じる"));

        Map<Integer, ItemStack> page1 = new HashMap<>();
        page1.put(0, createItem(Material.PAPER, "§e§l採掘系アイテム", null));
        page1.put(1, createItem(Material.STONE, null, lore64));
        page1.put(2, createItem(Material.COBBLESTONE, null, lore64));
        page1.put(3, createItem(Material.END_STONE, null, lore64));
        page1.put(4, createItem(Material.NETHERRACK, null, lore64));
        page1.put(9, createItem(Material.PAPER, "§e§l農業系アイテム", null));
        page1.put(10, createItem(Material.WHEAT, null, lore64));
        page1.put(11, createItem(Material.WHEAT_SEEDS, null, lore64));
        page1.put(12, createItem(Material.CARROT, null, lore64));
        page1.put(13, createItem(Material.POTATO, null, lore64));
        page1.put(18, createItem(Material.PAPER, "§e§l釣り系アイテム", null));
        page1.put(19, createItem(Material.COD, null, lore64));
        page1.put(20, createItem(Material.SALMON, null, lore48));
        page1.put(21, createItem(Material.TROPICAL_FISH, null, lore2));
        page1.put(22, createItem(Material.PUFFERFISH, null, lore16));
        page1.put(27, createItem(Material.PAPER, "§e§l素材系アイテム", null));
        page1.put(28, createItem(Material.ENDER_PEARL, null, lore32));
        page1.put(29, createItem(Material.ROTTEN_FLESH, null, lore64));
        page1.put(30, createItem(Material.BONE, null, lore64));
        page1.put(31, createItem(Material.GUNPOWDER, null, lore64));
        page1.put(32, createItem(Material.STRING, null, lore64));
        page1.put(36, createItem(Material.PAPER, "§e§l原木系アイテム", null));
        page1.put(37, createItem(Material.OAK_LOG, null, lore64));
        page1.put(38, createItem(Material.SPRUCE_LOG, null, lore64));
        page1.put(39, createItem(Material.BIRCH_LOG, null, lore64));
        page1.put(40, createItem(Material.JUNGLE_LOG, null, lore64));
        page1.put(41, createItem(Material.ACACIA_LOG, null, lore64));
        page1.put(42, createItem(Material.DARK_OAK_LOG, null, lore64));
        page1.put(45, createItem(Material.BOOK, "§6CraftGUIの使い方", helpLore));
        page1.put(50, createItem(Material.ARROW, "§a次のページ", null));
        page1.put(53, createItem(Material.BARRIER, "§c§l閉じる", closeLore));

        Map<Integer, ItemStack> page2 = new HashMap<>();
        page2.put(0, createItem(Material.PAPER, "§e§l鉱石系アイテム", null));
        page2.put(1, createItem(Material.REDSTONE, null, lore9));
        page2.put(2, createItem(Material.LAPIS_LAZULI, null, lore9));
        page2.put(3, createItem(Material.GOLD_INGOT, null, lore9));
        page2.put(4, createItem(Material.IRON_INGOT, null, lore9));
        page2.put(5, createItem(Material.DIAMOND, null, lore9));
        page2.put(6, createItem(Material.COAL, null, lore9));
        page2.put(7, createItem(Material.EMERALD, null, lore64));
        page2.put(9, createItem(Material.PAPER, "§e§l鉱石ブロック系アイテム", null));
        page2.put(10, createItem(Material.REDSTONE_BLOCK, null, lore9));
        page2.put(11, createItem(Material.LAPIS_BLOCK, null, lore9));
        page2.put(12, createItem(Material.GOLD_BLOCK, null, lore9));
        page2.put(13, createItem(Material.IRON_BLOCK, null, lore9));
        page2.put(14, createItem(Material.DIAMOND_BLOCK, null, lore9));
        page2.put(15, createItem(Material.COAL_BLOCK, null, lore9));
        page2.put(45, createItem(Material.BOOK, "§6CraftGUIの使い方", helpLore));
        page2.put(48, createItem(Material.ARROW, "§c前のページ", null));
        page2.put(53, createItem(Material.BARRIER, "§c§l閉じる", closeLore));

        pageItems.put(1, page1);
        pageItems.put(2, page2);
    }

    private static final Map<Material, String> ITEM_NAMES = new HashMap<>();
    static {
        ITEM_NAMES.put(Material.STONE, "石");
        ITEM_NAMES.put(Material.COBBLESTONE, "丸石");
        ITEM_NAMES.put(Material.END_STONE, "エンドストーン");
        ITEM_NAMES.put(Material.NETHERRACK, "ネザーラック");
        ITEM_NAMES.put(Material.WHEAT, "小麦");
        ITEM_NAMES.put(Material.WHEAT_SEEDS, "種");
        ITEM_NAMES.put(Material.CARROT, "ニンジン");
        ITEM_NAMES.put(Material.POTATO, "ジャガイモ");
        ITEM_NAMES.put(Material.COD, "生鱈");
        ITEM_NAMES.put(Material.SALMON, "生鮭");
        ITEM_NAMES.put(Material.TROPICAL_FISH, "熱帯魚");
        ITEM_NAMES.put(Material.PUFFERFISH, "フグ");
        ITEM_NAMES.put(Material.ENDER_PEARL, "エンダーパール");
        ITEM_NAMES.put(Material.ROTTEN_FLESH, "腐肉");
        ITEM_NAMES.put(Material.BONE, "骨");
        ITEM_NAMES.put(Material.GUNPOWDER, "火薬");
        ITEM_NAMES.put(Material.STRING, "糸");
        ITEM_NAMES.put(Material.OAK_LOG, "オークの原木");
        ITEM_NAMES.put(Material.SPRUCE_LOG, "マツの原木");
        ITEM_NAMES.put(Material.BIRCH_LOG, "シラカバの原木");
        ITEM_NAMES.put(Material.JUNGLE_LOG, "ジャングルの原木");
        ITEM_NAMES.put(Material.ACACIA_LOG, "アカシアの原木");
        ITEM_NAMES.put(Material.DARK_OAK_LOG, "ダークオークの原木");
        ITEM_NAMES.put(Material.REDSTONE, "レッドストーン");
        ITEM_NAMES.put(Material.LAPIS_LAZULI, "ラピスラズリ");
        ITEM_NAMES.put(Material.GOLD_INGOT, "金インゴット");
        ITEM_NAMES.put(Material.IRON_INGOT, "鉄インゴット");
        ITEM_NAMES.put(Material.DIAMOND, "ダイヤモンド");
        ITEM_NAMES.put(Material.COAL, "石炭");
        ITEM_NAMES.put(Material.EMERALD, "エメラルド");
        ITEM_NAMES.put(Material.REDSTONE_BLOCK, "レッドストーンブロック");
        ITEM_NAMES.put(Material.LAPIS_BLOCK, "ラピスラズリブロック");
        ITEM_NAMES.put(Material.GOLD_BLOCK, "金ブロック");
        ITEM_NAMES.put(Material.IRON_BLOCK, "鉄ブロック");
        ITEM_NAMES.put(Material.DIAMOND_BLOCK, "ダイヤモンドブロック");
        ITEM_NAMES.put(Material.COAL_BLOCK, "石炭ブロック");
    }

    private String getItemName(Material material) {
        return ITEM_NAMES.getOrDefault(material, material.toString());
    }

    private ItemStack createItem(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        return item;
    }

    /* エンチャント付きアイテムを追加する場合に使用
    private ItemStack createEnchantItem(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(lore);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }
        return item;
    }
    */

    public void openGui(Player player, int page) {
        Inventory inv = Bukkit.createInventory(null, 54, "§1CraftGUI - ページ " + page);
        if (pageItems.containsKey(page)) {
            for (Map.Entry<Integer, ItemStack> entry : pageItems.get(page).entrySet()) {
                inv.setItem(entry.getKey(), entry.getValue());
            }
        }
        playerPages.put(player.getUniqueId(), page);
        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getClickedInventory();
        ClickType clickType = event.getClick();
        Location loc = player.getLocation();

        if (inv == null) return;
        if (!event.getView().getTitle().startsWith("§1CraftGUI - ページ ")) return;
        event.setCancelled(true);

        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null || clickedItem.getType().isAir()) return;

        if (event.getSlot() == 53) {
            player.closeInventory();
        } else if (event.getSlot() == 45) {
            player.closeInventory();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a使用可能コマンド一覧:"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/rgui"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7- &bCraftGUIを開きます"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/rgui nogui"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7- &bCraftGUIを開かずに圧縮可能なアイテムをすべて圧縮します"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/rgui <アイテムID>"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7- &bCraftGUIを開かずに指定したアイテムIDをすべて圧縮します"));
            player.playSound(loc, Sound.BLOCK_STONE_BUTTON_CLICK_ON, 2, 1);
        } else if (event.getSlot() == 48) {
            openGui(player, 1);
            player.playSound(loc, Sound.BLOCK_STONE_BUTTON_CLICK_ON, 2, 1);
        } else if (event.getSlot() == 50) {
            openGui(player, 2);
            player.playSound(loc, Sound.BLOCK_STONE_BUTTON_CLICK_ON, 2, 1);
        } else if (!((event.getSlot() == 0) || (event.getSlot() == 9 || event.getSlot() == 18 || event.getSlot() == 27 || event.getSlot() == 36))) {
            if (hasCustomName(clickedItem)) {
                player.sendMessage(ChatColor.RED + "このアイテムは圧縮できません");
                player.playSound(loc, Sound.ENTITY_VILLAGER_NO, 2, 1);
            }
        }

        ItemMeta meta = clickedItem.getItemMeta();
        if (meta != null && meta.hasDisplayName()) return;

        Map<Material, Pair<String, Integer>> compressMap = new HashMap<>();
        compressMap.put(Material.STONE, new ImmutablePair<>("assyukustone", 64));
        compressMap.put(Material.COBBLESTONE, new ImmutablePair<>("isi_ticket", 64));
        compressMap.put(Material.END_STONE, new ImmutablePair<>("assyukuend", 64));
        compressMap.put(Material.NETHERRACK, new ImmutablePair<>("assyukunether", 64));
        compressMap.put(Material.WHEAT, new ImmutablePair<>("assyukuwheat", 64));
        compressMap.put(Material.WHEAT_SEEDS, new ImmutablePair<>("komugi_ticket", 64));
        compressMap.put(Material.CARROT, new ImmutablePair<>("assyukucarrot", 64));
        compressMap.put(Material.POTATO, new ImmutablePair<>("assyukupotato", 64));
        compressMap.put(Material.COD, new ImmutablePair<>("fishticketplus", 64));
        compressMap.put(Material.SALMON, new ImmutablePair<>("fishticketplus", 49));
        compressMap.put(Material.TROPICAL_FISH, new ImmutablePair<>("fishticketplus", 2));
        compressMap.put(Material.PUFFERFISH, new ImmutablePair<>("fishticketplus", 16));
        compressMap.put(Material.ENDER_PEARL, new ImmutablePair<>("pearl1", 32));
        compressMap.put(Material.ROTTEN_FLESH, new ImmutablePair<>("rotten_flesh", 64));
        compressMap.put(Material.BONE, new ImmutablePair<>("bone_break", 64));
        compressMap.put(Material.GUNPOWDER, new ImmutablePair<>("gunpowder", 64));
        compressMap.put(Material.STRING, new ImmutablePair<>("cobweb_dust", 64));
        compressMap.put(Material.OAK_LOG, new ImmutablePair<>("compressed_oak", 64));
        compressMap.put(Material.SPRUCE_LOG, new ImmutablePair<>("assyukuspruce", 64));
        compressMap.put(Material.BIRCH_LOG, new ImmutablePair<>("compressed_birch", 64));
        compressMap.put(Material.JUNGLE_LOG, new ImmutablePair<>("compressed_jungl", 64));
        compressMap.put(Material.ACACIA_LOG, new ImmutablePair<>("compressed_acacia", 64));
        compressMap.put(Material.DARK_OAK_LOG, new ImmutablePair<>("compressed_dark", 64));
        compressMap.put(Material.REDSTONE, new ImmutablePair<>("redstone_block", 9));
        compressMap.put(Material.LAPIS_LAZULI, new ImmutablePair<>("lapis_block", 9));
        compressMap.put(Material.GOLD_INGOT, new ImmutablePair<>("gold_block", 9));
        compressMap.put(Material.IRON_INGOT, new ImmutablePair<>("iron_block", 9));
        compressMap.put(Material.DIAMOND, new ImmutablePair<>("diamond_block", 9));
        compressMap.put(Material.COAL, new ImmutablePair<>("coal_block", 9));
        compressMap.put(Material.EMERALD, new ImmutablePair<>("compressed_emerald", 64));
        compressMap.put(Material.REDSTONE_BLOCK, new ImmutablePair<>("Compressed_redstone_block", 9));
        compressMap.put(Material.LAPIS_BLOCK, new ImmutablePair<>("compressed_lapis_block", 9));
        compressMap.put(Material.GOLD_BLOCK, new ImmutablePair<>("Compressed_gold_block", 9));
        compressMap.put(Material.IRON_BLOCK, new ImmutablePair<>("Compressed_iron_block", 9));
        compressMap.put(Material.DIAMOND_BLOCK, new ImmutablePair<>("compressed_diamond_block", 9));
        compressMap.put(Material.COAL_BLOCK, new ImmutablePair<>("Compressed_coal_block", 9));

        Pair<String, Integer> compressData = compressMap.get(clickedItem.getType());
        if (compressData == null) return;
        String mmItemID = compressData.getKey();
        int requiredAmount = compressData.getValue();
        int totalAmount = getTotalItemAmount(player.getInventory(), clickedItem.getType());
        int maxCompressible = totalAmount / requiredAmount;

        if (totalAmount == 0) {
            player.playSound(loc,Sound.ENTITY_VILLAGER_NO, 2, 1);
            player.sendMessage(ChatColor.RED + getItemName(clickedItem.getType()) + "を持っていません");
        } else if (totalAmount < requiredAmount) {
            int result = requiredAmount - totalAmount;
            player.playSound(loc,Sound.ENTITY_VILLAGER_NO, 2, 1);
            player.sendMessage(ChatColor.RED + getItemName(clickedItem.getType()) + "が" + result + "個不足しています (最小必要数: " + requiredAmount + "個)");
        } else {
            int compressTimes = (clickType == ClickType.LEFT) ? maxCompressible : 1;
            processCompression(player, clickedItem.getType(), mmItemID, requiredAmount, compressTimes);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        playerPages.remove(event.getPlayer().getUniqueId());
    }

    public boolean isMythicItem(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        return container.has(new NamespacedKey("mythicmobs", "mythic_type"), PersistentDataType.STRING);
    }

    public boolean hasCustomName(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.hasDisplayName();
    }

    void processCompression(Player player, Material material, String mmItemID, int requiredAmount, int times) {
        removeItems(player.getInventory(), material, requiredAmount * times);
        giveCompressedItem(player, mmItemID, times);
        player.sendMessage(ChatColor.GREEN + "" + times + "回圧縮しました");
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
    }

    int getTotalItemAmount(Inventory inventory, Material material) {
        int total = 0;
        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() == material && !isMythicItem(item) && !hasCustomName(item)) {
                total += item.getAmount();
            }
        }
        return total;
    }

    private void removeItems(Inventory inventory, Material material, int amount) {
        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() == material && !isMythicItem(item) && !hasCustomName(item)) {
                int itemAmount = item.getAmount();
                if (itemAmount > amount) {
                    item.setAmount(itemAmount - amount);
                    return;
                } else {
                    amount -= itemAmount;
                    item.setAmount(0);
                }
            }
            if (amount <= 0) break;
        }
    }

    private void giveCompressedItem(Player player, String mmItemID, int amount) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mlg " + player.getName() + " " + mmItemID + " " + amount +" 1");
    }

}