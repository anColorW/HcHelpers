package me.color.listeners;

import me.color.Main;
import me.color.utils.Utils;
import org.bukkit.Bukkit;
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

    public static Main plugin;

    public Autofosa(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }



    @EventHandler
    public void onPlacePortal(BlockPlaceEvent e){

        Player p = e.getPlayer();



        if(p.getItemInHand().getType() == Material.AIR)
            return;
        if(p.getItemInHand().getItemMeta().getDisplayName() == null)
            return;

        if(p.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chat("&7Autofosa"))){
            if(e.getBlockPlaced().getType() == Material.ENDER_PORTAL_FRAME){


                Location block = e.getBlock().getLocation();
                Location originalLoc = block;

                int blocks = 10;
                int x = 0;

                p.getInventory().removeItem(ItemStacks.getFosa());

                while(block.getBlockY() > 0){
                    if(p.getWorld().getBlockAt(block).getType() == Material.BEDROCK){
                        return;
                    }

                    if(limit){ //limit kratek
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
