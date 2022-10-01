package me.color.listeners;

import me.color.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Stoniarki implements Listener {


    public static ArrayList<Location> StoniarkaLokacja = new ArrayList<>();


    @EventHandler
    public void stoniarka(BlockBreakEvent e){
        Player p = e.getPlayer();
        Location loc = e.getBlock().getState().getLocation();


            new BukkitRunnable() {
                @Override
                public void run() {
                    e.getBlock().setType(Material.STONE);    //Sponge lub EnderStone pod tym co bedzie dawalo sygnal temu zeby stone sie respil (zloty kilof przerywa runnable)
                }

            }.runTaskLater(Main.getInstance(), 20);




          /*
           if(e.getBlock().getType() == Material.STONE){
            if(p.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ()).getType() == Material.ENDER_STONE){

                while(loc.getBlock().getType().equals(Material.AIR)){
                    System.out.println("asd");
                }

            }


        }
           */


       }
    }





//lokalizacja array
//zloty kilof po wykopaniu endstone wypada stoniarka
//endstone (nad endstone pojawia sie stone)
//onblockbreak






