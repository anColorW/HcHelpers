package me.color.gui;

import me.color.Main;
import me.color.listeners.ItemStacks;
import me.color.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AutofosaGui {

    public static Main plugin;

    public AutofosaGui(Main pl) {
        plugin = pl;
    }

    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 6*9;

    public static void initialize() {
        inventory_name = Utils.chat("&8&lAutoFosa...");

        inv = Bukkit.createInventory(null, inv_rows);
    }


    public static Inventory FosaGui(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);


        for (int a = 1; a <= inv_rows; a++) {
            Utils.createItemByte(inv, 160, 15, 1, a, "&8&m--।--", "&8» &cPuste Pole!", "&8» &cWybierz inna pozycja!");
        }

        for (int b = 1; b <= inv_rows; b++) {
            switch (b){
                case 11: case 12: case 13: case 20: case 22: case 29: case 30: case 31:
                    Utils.createItemByte(inv, 49, 15, 64, b, "&7", "&8» &7Przedmiot wymagany do stworzenia RzucanegoTNT!");
                    break;
                case 21:
                    Utils.createItemByte(inv, 322, 1, 64, b, "&7", "&8» &7Przedmiot wymagany do stworzenia RzucanegoTNT!");
            }
        }

        int amount =  Utils.CountItemInInventory(p,new ItemStack(Material.OBSIDIAN));
        int amount2 =  Utils.CountItemInInventory(p, new ItemStack(Material.GOLDEN_APPLE, 1, (short)1));
        String message = amount >= 8 && amount2 >= 1 ?  "&8» &aMozesz stworzyc przedmiot!"  : "&8» &cBrakuje Ci przedmiotow do stworzenia przedmiotu!";

        Utils.createItem(inv, 166, 1, 50, "   &4&l » &cPowrot do Menu &4&l«", false);


        Utils.createItem(inv, 49, 1, 25, "            &7&lBoyfarmer        ", true,
                "&8» &7Kliknij aby stworzyc przedmiot. ",
                message);


        //"   &4&l » &cPowrot do Menu &4&l«"
        //Utils.createItem(inv, 266, 1 , 12, "&d&lZloto", Main.Config.golddrop, "&r&fSzansa: &d&l" + Main.Config.GoldChance + "%", "&fDrop: " + gold);

        toReturn.setContents(inv.getContents());
        return toReturn;

    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("   &4&l » &cPowrot do Menu &4&l«"))){
            p.closeInventory();
            p.openInventory(GuiGeneral.GuiMain(p));
        }
        if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("            &7&lBoyfarmer        "))){
            if(Utils.CountItemInInventory(p, new ItemStack(Material.OBSIDIAN)) >= 8 && Utils.CountItemInInventory(p, new ItemStack(Material.GOLDEN_APPLE, 1, (short)1)) >= 1){
                p.getInventory().addItem(ItemStacks.getBoyki());
                p.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
                p.getInventory().removeItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short)1));
                p.sendMessage(Utils.chat("&8» &aPomyslnie stworzono przedmiot!"));
                p.closeInventory();
            } else{
                p.closeInventory();
                p.sendMessage(Utils.chat("&8» &cBrakuje Ci przedmiotow do stworzenia!"));
            }
        }


    }


}
