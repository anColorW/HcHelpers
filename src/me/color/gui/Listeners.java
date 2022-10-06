package me.color.gui;

import me.color.Main;
import me.color.listeners.Autofosa;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import me.color.Main;

public class Listeners implements Listener {

     public Listeners(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getInventory().getTitle();
        if (title.equals(GuiGeneral.inventory_name) ||
                title.equals(RzucakGui.inventory_name) ||
                title.equals(BoykiGui.inventory_name) ||
                title.equals(AfosaGui.inventory_name) ||
                title.equals(SandyGui.inventory_name) ||
                title.equals(StoniarkiGUI.inventory_name)) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null) {
                return;
            }
        }
        if((title.equals(RzucakGui.inventory_name))){
            RzucakGui.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
        if (title.equals(GuiGeneral.inventory_name)) {
            GuiGeneral.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
        if (title.equals(BoykiGui.inventory_name)) {
            BoykiGui.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
        if (title.equals(AfosaGui.inventory_name)) {
            AfosaGui.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
        if (title.equals(SandyGui.inventory_name)) {
            SandyGui.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
        if (title.equals(StoniarkiGUI.inventory_name)) {
            StoniarkiGUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
    }
}
