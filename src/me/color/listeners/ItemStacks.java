package me.color.listeners;

import me.color.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStacks {

    public static ItemStack getFosa() {
        ItemStack autofosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta autofosameta = autofosa.getItemMeta();
        autofosameta.setDisplayName(Utils.chat("&7Autofosa"));
        autofosa.setItemMeta(autofosameta);
        return autofosa;
    }

    public static ItemStack getBoyki(){
        ItemStack boyfarmer = new ItemStack(Material.OBSIDIAN);
        ItemMeta boyfarmermeta = boyfarmer.getItemMeta();
        boyfarmermeta.setDisplayName(Utils.chat("&8Boyfarmer"));
        boyfarmer.setItemMeta(boyfarmermeta);
        return boyfarmer;
    }

    public static ItemStack getRzucak(){
        ItemStack rzucak = new ItemStack(Material.TNT);
        ItemMeta rzucakmeta = rzucak.getItemMeta();
        rzucakmeta.setDisplayName(Utils.chat("&4&kW &r &c&lRzucane &f&lTNT &4&kW"));
        rzucak.setItemMeta(rzucakmeta);

        return rzucak;
    }

    public static ItemStack getSandy(){
        ItemStack sandfarmer = new ItemStack(Material.SANDSTONE);
        ItemMeta sandfarmermeta = sandfarmer.getItemMeta();
        sandfarmermeta.setDisplayName(Utils.chat("&7Sandfarmer"));
        sandfarmer.setItemMeta(sandfarmermeta);

        return sandfarmer;
    }

    public static ItemStack getStoniarki(int typ){
        if(typ == 1){
            ItemStack stoniarkatyp1 = new ItemStack(Material.ENDER_STONE);
            ItemMeta stoniarkatyp2 = stoniarkatyp1.getItemMeta();
            stoniarkatyp2.setDisplayName(Utils.chat("&eStoniarka"));
            stoniarkatyp1.setItemMeta(stoniarkatyp2);
            return stoniarkatyp1;
        }
        if(typ == 2){
            ItemStack stoniarka = new ItemStack(Material.SPONGE);
            ItemMeta stoniarkameta = stoniarka.getItemMeta();
            stoniarkameta.setDisplayName(Utils.chat("&eStoniarka"));
            stoniarka.setItemMeta(stoniarkameta);
            return stoniarka;
        }
        return null;
    }

}
