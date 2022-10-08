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
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Rzucaki implements Listener {

    public static Main plugin;


    public Rzucaki(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public static void onPlace(BlockPlaceEvent e){
        Calendar calendar = GregorianCalendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        Player p = e.getPlayer();

        if(e.getBlock().getType() == Material.TNT){
            if(Main.getInstance().getConfig().getBoolean("TNT.TIME")){
                int x =  Main.getInstance().getConfig().getInt("TNT.OD_GODZ");
                int y = Main.getInstance().getConfig().getInt("TNT.DO_GODZ");

                if(y > x){ //
                    if(hour >= x && hour < y){
                        p.sendMessage(Utils.chat("&7&l » &cTNT jest wylaczone od godziny " + x +":00 do "+ y +":00"));
                        e.setCancelled(true);
                        return;
                    }
                }
                if(x > y){
                    if(hour >= x){
                        p.sendMessage(Utils.chat("&7&l » &cTNT jest wylaczone od godziny " + x +":00 do "+ y +":00"));
                        e.setCancelled(true);
                    } else{
                        if (hour >= 0 && hour < y) {
                            p.sendMessage(Utils.chat("&7&l » &cTNT jest wylaczone od godziny " + x +":00 do "+ y +":00"));
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }

    }

    @EventHandler
    public static void onInterract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(p.getItemInHand().getType() == Material.AIR)
            return;
        if(p.getItemInHand().getItemMeta().getDisplayName() == null)
            return;


        if(e.getAction().equals(e.getAction().RIGHT_CLICK_BLOCK)){


            Location block = e.getClickedBlock().getLocation();
            block.setY(block.getY() + 1);


            if(p.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chat("&4&kW &r &c&lRzucane &f&lTNT &4&kW"))){

                Calendar calendar = GregorianCalendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                if(Main.getInstance().getConfig().getBoolean("TNT.TIME")){
                    int x =  Main.getInstance().getConfig().getInt("TNT.OD_GODZ");
                    int y = Main.getInstance().getConfig().getInt("TNT.DO_GODZ");

                    if(y > x){ //
                        if(hour >= x && hour < y){
                            return;
                        }
                    }
                    if(x > y){
                        if(hour >= x){
                            return;
                        } else{
                            if (hour >= 0 && hour < y) {
                                return;
                            }
                        }
                    }
                }
                p.getWorld().spawnEntity(block, EntityType.PRIMED_TNT);


                p.getInventory().removeItem(ItemStacks.getRzucak());
                e.setCancelled(true);
            } else {
                return;
            }


        }
    }


}