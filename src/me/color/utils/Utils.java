package me.color.utils;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static String chat (String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static ItemStack createItem(Inventory inv, int materialId, int amount, int invSlot, String displayName, boolean glow, String... loreString) {

        ItemStack item;
        List<String> lore = new ArrayList<String>();


        item = new ItemStack(materialId, amount);


        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString) {
            lore.add(Utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);


        if(glow) {
            item = addGlow(item);
        }


        inv.setItem(invSlot - 1, item);

        return item;
    }

    public static ItemStack addGlow(ItemStack item){
        net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = null;
        if (!nmsStack.hasTag()) {
            tag = new NBTTagCompound();
            nmsStack.setTag(tag);
        }
        if (tag == null) tag = nmsStack.getTag();
        NBTTagList ench = new NBTTagList();
        tag.set("ench", ench);
        nmsStack.setTag(tag);
        return CraftItemStack.asCraftMirror(nmsStack);
    }

    @SuppressWarnings("deprecation")
    public static ItemStack createItemByte(Inventory inv, int materialId, int byteId,  int amount, int invSlot, String displayName, String... loreString) {

        ItemStack item;
        List<String> lore = new ArrayList<String>();

        item = new ItemStack(materialId, amount, (short) byteId);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString) {
            lore.add(Utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot - 1, item);

        return item;
    }

    public static int CountItemInInventory(Player p, Material block){
        int amount = 0;
        for (int i2 = 0; i2 < 36; i2++) {
            ItemStack slot = p.getInventory().getItem(i2);
            if (slot == null || !slot.isSimilar(new ItemStack(block)))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }

}
