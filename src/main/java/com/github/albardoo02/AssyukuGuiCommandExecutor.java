package com.github.albardoo02;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class AssyukuGuiCommandExecutor implements CommandExecutor {

    private final GuiHandler guiHandler;
    private final Map<Material, Pair<String, Integer>> compressMap;
    private final Map<Material, String> ItemNameMap;

    public AssyukuGuiCommandExecutor(GuiHandler guiHandler) {
        this.guiHandler = guiHandler;
        this.compressMap = initializeCompressMap();
        this.ItemNameMap = initializeNameMap();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String CommandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "このコマンドはプレイヤーのみ実行可能です");
            return true;
        }
        if (args.length == 0) {
            Player player = (Player) sender;
            guiHandler.openGui(player, 1);
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("nogui")) {
                compressItems(player);
                return true;
            }
            else if (args[0].equalsIgnoreCase(args[0])) {
                Material targetMaterial = Material.getMaterial(args[0].toUpperCase());
                if (targetMaterial == null) {
                    player.sendMessage(ChatColor.RED + "指定されたアイテムID:" + args[0] + "は見つかりませんでした");
                    return true;
                }
                compressSpecificItem(player, targetMaterial);
                return true;
            }
         }
        return true;
    }

    private Map<Material, Pair<String, Integer>> initializeCompressMap() {
        Map<Material, Pair<String, Integer>> compressMap = new HashMap<>();
        compressMap.put(Material.STONE, new ImmutablePair<>("assyukustone", 64));
        compressMap.put(Material.COBBLESTONE, new ImmutablePair<>("isi_ticket", 64));
        compressMap.put(Material.END_STONE, new ImmutablePair<>("assyukuend", 64));
        compressMap.put(Material.NETHERRACK, new ImmutablePair<>("assyukunether", 64));
        compressMap.put(Material.WHEAT, new ImmutablePair<>("assyukuwheat", 64));
        compressMap.put(Material.WHEAT_SEEDS, new ImmutablePair<>("komugi_ticket", 64));
        compressMap.put(Material.CARROT, new ImmutablePair<>("assyukucarrot", 64));
        compressMap.put(Material.POTATO, new ImmutablePair<>("assyukupotato", 64));
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
        return compressMap;
    }

    private Map<Material, String> initializeNameMap() {
        Map<Material, String> ITEM_NAMES = new HashMap<>();
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
        return ITEM_NAMES;
    }

    private String getItemName(Material material) {
        return ItemNameMap.getOrDefault(material, material.name());
    }

    private void compressItems(Player player) {
        boolean compressed = false;
        boolean inventoryFull = false;

        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                if (guiHandler.isMythicItem(item) && guiHandler.hasCustomName(item)) {
                    continue;
                }
                Pair<String, Integer> compressData = compressMap.get(item.getType());
                if (compressData != null) {
                    String mmItemID = compressData.getKey();
                    int requiredAmount = compressData.getValue();
                    int totalAmount = guiHandler.getTotalItemAmount(player.getInventory(), item.getType());
                    int maxCompressible = totalAmount / requiredAmount;

                    if (maxCompressible > 0) {
                        if (player.getInventory().firstEmpty() == -1) {
                            player.sendMessage(ChatColor.GOLD + "インベントリに空きがないので変換できません");
                            inventoryFull = true;
                            break;
                        }
                        guiHandler.processCompression(player, item.getType(), mmItemID, requiredAmount, maxCompressible);
                        compressed = true;
                    }
                }
            }
        }
        if (!compressed && !inventoryFull) {
            player.sendMessage(ChatColor.RED + "圧縮可能なアイテムがインベントリ内にありません");
        }
    }

    private void compressSpecificItem(Player player, Material targetMaterial) {
        Pair<String, Integer> compressData = compressMap.get(targetMaterial);
        if (compressData == null) {
            player.sendMessage(ChatColor.RED + getItemName(targetMaterial) + "は圧縮できません");
            return;
        }

        String mmItemID = compressData.getKey();
        int requiredAmount = compressData.getValue();
        int totalAmount = guiHandler.getTotalItemAmount(player.getInventory(), targetMaterial);
        int maxCompressible = totalAmount / requiredAmount;

        if (totalAmount < requiredAmount) {
            player.sendMessage(ChatColor.RED + getItemName(targetMaterial) + "が" + (requiredAmount - totalAmount) + "個不足しています（最小必要数: " + requiredAmount + "個）");
            return;
        }
        if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage(ChatColor.GOLD + "インベントリに空きがないので変換できません");
            return;
        }
        guiHandler.processCompression(player, targetMaterial, mmItemID, requiredAmount, maxCompressible);
    }
}
