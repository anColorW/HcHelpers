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

public class Boyki implements Listener {


    private static Location placed;


    @EventHandler
    public void onPlacePortal(BlockPlaceEvent e){

        Player p = e.getPlayer();

        ItemStack boyfarmer = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boyfarmermeta = boyfarmer.getItemMeta();
        boyfarmermeta.setDisplayName(Utils.chat("&7Boyfarmer"));
        boyfarmer.setItemMeta(boyfarmermeta);

        if(p.getItemInHand().getType() == Material.AIR)
            return;
        if(p.getItemInHand().getItemMeta().getDisplayName() == null)
            return;

        if(p.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chat("&7Boyfarmer"))){
            if(e.getBlockPlaced().getType() == Material.ENDER_PORTAL_FRAME){
                placed = e.getBlock().getLocation();

                Location block = placed;
                Location originalLoc = block;

                p.getInventory().removeItem(boyfarmer);

                    while(block.getBlockY() > 0){
                        if(p.getWorld().getBlockAt(block).getType() == Material.BEDROCK){
                            return;
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
