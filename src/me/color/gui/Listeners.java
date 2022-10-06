package me.color.gui;

import me.color.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import me.color.Main;

public class Listeners implements Listener {

    /*
     public Listeners(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

     */
    @EventHandler
    public void onClick(InventoryClickEvent e) {

        String title = e.getInventory().getTitle();
        if (title.equals(GuiGeneral.inventory_name)) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null) {
                return;
            }

        } if (title.equals(GuiGeneral.inventory_name)) {
            GuiGeneral.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent e)
    {
        Player p = (Player) e.getPlayer();

    }
}
