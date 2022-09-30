package me.color.listeners;

import me.color.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Boyfarmery implements Listener {

    @EventHandler
    public void onSandPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();

        ItemStack boyfarmer = new ItemStack(Material.OBSIDIAN);
        ItemMeta boyfarmermeta = boyfarmer.getItemMeta();
        boyfarmermeta.setDisplayName(Utils.chat("&8Sandfarmer"));
        boyfarmer.setItemMeta(boyfarmermeta);

        if(p.getItemInHand().getType() == Material.AIR)
            return;
        if(p.getItemInHand().getItemMeta().getDisplayName() == null)
            return;

        if(p.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chat("&7Sandfarmer"))){
            if(e.getBlockPlaced().getType() == Material.SANDSTONE){


                Location block = e.getBlock().getLocation();
                Location originalLoc = block;

                int blocks = 10;
                int x = 0;

                p.getInventory().removeItem(boyfarmer);

                while(block.getBlockY() > 0){
                    if(p.getWorld().getBlockAt(block).getType() == Material.BEDROCK){
                        return;
                    }
                    //mozna tu przepisac limit kratek do ktorych dzialaja sandy

                    p.getWorld().getBlockAt(block).setType(Material.OBSIDIAN);

                    block.setY(block.getBlockY() - 1);
                }

                e.setCancelled(true);
            }
        }

    }
}