package me.color.listeners;

import me.color.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Autofosa implements Listener { //AUTOFOSA NIE BOYFARMERY

    public static boolean limit = false;

    @EventHandler
    public void onPlacePortal(BlockPlaceEvent e){

        Player p = e.getPlayer();

        ItemStack autofosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta autofosameta = autofosa.getItemMeta();
        autofosameta.setDisplayName(Utils.chat("&7Boyfarmer"));
        autofosa.setItemMeta(autofosameta);

        if(p.getItemInHand().getType() == Material.AIR)
            return;
        if(p.getItemInHand().getItemMeta().getDisplayName() == null)
            return;

        if(p.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chat("&7Boyfarmer"))){
            if(e.getBlockPlaced().getType() == Material.ENDER_PORTAL_FRAME){


                Location block = e.getBlock().getLocation();
                Location originalLoc = block;

                int blocks = 10;
                int x = 0;

                p.getInventory().removeItem(autofosa);

                while(block.getBlockY() > 0){
                    if(p.getWorld().getBlockAt(block).getType() == Material.BEDROCK){
                        return;
                    }

                    if(limit){
                        if(x == blocks){
                            return;
                        }
                        x = x + 1;
                    }

                    p.getWorld().getBlockAt(block).setType(Material.AIR);
                    p.getWorld().getBlockAt(originalLoc).setType(Material.AIR);
                    block.setY(block.getBlockY() - 1);
                }

                e.setCancelled(true);
            }
        }

    }
}
