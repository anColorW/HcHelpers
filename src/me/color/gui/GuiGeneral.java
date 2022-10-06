package me.color.gui;

import me.color.listeners.Autofosa;
import me.color.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import me.color.Main;

public class GuiGeneral {

    public static Main plugin;

        public GuiGeneral(Main pl) {
            plugin = pl;
        }

        public static Inventory inv;
        public static String inventory_name;
        public static int inv_rows =  9;

        public static void initialize() {
            inventory_name = Utils.chat("&fCraftingi");

            inv = Bukkit.createInventory(null, inv_rows);
        }



        public static Inventory GuiMain (Player p) {
            Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);



            for (int a = 1; a <= inv_rows; a++) {
                Utils.createItemByte(inv, 160, 15, 1, a, "&8&m--।--", "&8» &cPuste Pole!", "&8» &cWybierz inna pozycja!");
            }


            Utils.createItem(inv, 46, 1 , 1, Utils.chat("&8&m&l----------------------"), true,
                    "             &f&lCrafting         " ,
                    "       &4&kW &r &c&lRzucane &f&lTNT &4&kW" ,
                    "&8&m&l----------------------"
            );

            Utils.createItem(inv, 120, 1 , 3, Utils.chat("&8&m&l----------------------"), true,
                    "             &f&lCrafting         " ,
                    "             &7&lAutofosa         " ,
                    "&8&m&l----------------------"
            );

            Utils.createItem(inv, 24, 1 , 5, Utils.chat("&8&m&l----------------------"), true,
                    "             &f&lCrafting         " ,
                    "            &7&lSandfarmer       " ,
                    "&8&m&l----------------------"
            );

            Utils.createItem(inv, 49, 1 , 7, Utils.chat("&8&m&l----------------------"), true,
                    "             &f&lCrafting         " ,
                    "            &7&lBoyfarmer        " ,
                    "&8&m&l----------------------"
            );

            Utils.createItem(inv, 121, 1 , 9, Utils.chat("&8&m&l----------------------"), true,
                    "             &f&lCrafting         " ,
                    "            &7&lStoniarki        " ,
                    "&8&m&l----------------------"
            );


            //Utils.createItem(inv, 266, 1 , 12, "&d&lZloto", Main.Config.golddrop, "&r&fSzansa: &d&l" + Main.Config.GoldChance + "%", "&fDrop: " + gold);

            toReturn.setContents(inv.getContents());
            return toReturn;

        }

        public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
            if (clicked.getItemMeta().getLore().get(1).equalsIgnoreCase(Utils.chat("       &4&kW &r &c&lRzucane &f&lTNT &4&kW"))) {
           /*   int amount =  Utils.CountItemInInventory(p, Material.TNT);
              int left = (64 * 9) - amount;
              int staki = left / 64;
              int reszta = left % 64;
              String message = staki == 0 ? "Brakuje ci " + reszta + " tnt!" : "Brakuje ci " + staki + " stakow, oraz " + reszta + " TNT";
              p.sendMessage(message);*/
                p.closeInventory();
              p.openInventory(RzucakGui.RzucakGui(p));
            }
            if (clicked.getItemMeta().getLore().get(1).equalsIgnoreCase(Utils.chat("             &7&lAutofosa         "))) {
                p.closeInventory();
                p.openInventory(AfosaGui.FosaGui(p));
            }
            if (clicked.getItemMeta().getLore().get(1).equalsIgnoreCase(Utils.chat( "            &7&lSandfarmer       "))) {
                p.closeInventory();
                p.openInventory(SandyGui.SandGui(p));
            }
            if (clicked.getItemMeta().getLore().get(1).equalsIgnoreCase(Utils.chat("            &7&lBoyfarmer        "))) {
                p.closeInventory();
                p.openInventory(BoykiGui.BoykiGui(p));
            }
            if (clicked.getItemMeta().getLore().get(1).equalsIgnoreCase(Utils.chat("            &7&lStoniarki        "))) {
                p.closeInventory();
                p.openInventory(StoniarkiGUI.Sgui(p));
            }

        }
}
