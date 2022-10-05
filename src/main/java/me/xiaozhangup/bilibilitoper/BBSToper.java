package me.xiaozhangup.bilibilitoper;

import me.xiaozhangup.bilibilitoper.utils.items.IBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import static me.xiaozhangup.bilibilitoper.BiliBiliToper.mm;

public class BBSToper implements Listener, InventoryHolder {

    public static final ItemStack bbs = IBuilder.buildItem(Material.BROWN_DYE, "&x&c&a&8&1&4&cMCBBS使用提升卡顶贴", "", "&7这一项适用于拥有MCBBS账号", "&7且账号等级大于4级的玩家使用");
    public static final ItemStack bili = IBuilder.buildItem(Material.BLUE_DYE, "&x&0&1&a&1&d&6哔哩哔哩实况", "", "&7你可以录制服务器的游玩实况", "&7并发布到BiliBili,即可获取奖励");
    private static final ItemStack board = IBuilder.getBorder(Material.GRAY_STAINED_GLASS_PANE);
    public static Inventory bbstoper = Bukkit.createInventory(new BBSToper(), 27, mm.deserialize("你想如何支持我们?"));

    public static void open(Player p) {
        p.openInventory(bbstoper);
    }

    public static void setup() {
        for (int i = 0; i < 27; i++) {
            bbstoper.setItem(i, board);
            bbstoper.setItem(11, bbs);
            bbstoper.setItem(15, bili);
        }
    }

    public Inventory getInventory() {
        return null;
    }

    @EventHandler
    public void onPlayerClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player p && e.getInventory().getHolder() instanceof BBSToper) {
            e.setCancelled(true);
            switch (e.getRawSlot()) {
                case 11 -> {
                    Bukkit.dispatchCommand(p, "bt");
                }
                case 15 -> {
                    ToperUI.open(p);
                }
            }
        }
    }
}
