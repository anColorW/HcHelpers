package me.color.listeners;

import me.color.Main;
import me.color.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Rzucaki implements Listener {

    @EventHandler
    public static void onInterract(PlayerInteractEvent e) { //dodac tnt dziala od 22-6
        Player p = e.getPlayer();

        ItemStack rzucak = new ItemStack(Material.TNT);
        ItemMeta rzucakmeta = rzucak.getItemMeta();
        rzucakmeta.setDisplayName(Utils.chat("&4&kW &r &c&lRzucane &f&lTNT &4&kW"));
        rzucak.setItemMeta(rzucakmeta);

        if(p.getItemInHand().getType() == Material.AIR)
            return;
        if(p.getItemInHand().getItemMeta().getDisplayName() == null)
            return;


        if(e.getAction().equals(e.getAction().RIGHT_CLICK_BLOCK)){

            Location block = e.getClickedBlock().getLocation();
            block.setY(block.getY() + 1);


            if(p.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chat("&4&kW &r &c&lRzucane &f&lTNT &4&kW"))){
                p.getWorld().spawnEntity(block, EntityType.PRIMED_TNT);


                p.getInventory().removeItem(rzucak);
                e.setCancelled(true);
            } else {
                return;
            }


        }
    }


}