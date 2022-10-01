package me.color.listeners;

import me.color.Main;
import me.color.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Stoniarki implements Listener {


    public static ArrayList<Location> StoniarkaLokacja = new ArrayList<>();


    @EventHandler
    public void stoniarkatyp1(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Location loc = e.getBlock().getState().getLocation();

        if (e.getBlock().getType() == Material.STONE) {
            if (p.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ()).getType() == Material.ENDER_STONE) {

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        e.getBlock().setType(Material.STONE);    //Sponge lub EnderStone pod tym co bedzie dawalo sygnal temu zeby stone sie respil (zloty kilof przerywa runnable)
                    }

                }.runTaskLater(Main.getInstance(), 20);

            }
        }
    }

    @EventHandler
    public void enderPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        ItemStack stoniarkatyp1 = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkatyp2 = stoniarkatyp1.getItemMeta();
        stoniarkatyp2.setDisplayName(Utils.chat("&eStoniarka"));
        stoniarkatyp1.setItemMeta(stoniarkatyp2);

        if(p.getItemInHand().getType() == Material.AIR)
            return;
        if(p.getItemInHand().getItemMeta().getDisplayName() == null)
            return;

        if(p.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chat("&eStoniarka"))){
            if(e.getBlockPlaced().getType() == Material.ENDER_STONE){
                if(!(p.getWorld().getBlockAt(e.getBlock().getX(), e.getBlock().getY() + 1, e.getBlock().getZ()).getType() == Material.AIR))
                    return;

                p.getWorld().getBlockAt(e.getBlock().getX(), e.getBlock().getY() + 1, e.getBlock().getZ()).setType(Material.STONE);
            }
        }
    }


    @EventHandler
    public void spongePlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        ItemStack stoniarka = new ItemStack(Material.SPONGE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Utils.chat("&eStoniarka"));
        stoniarka.setItemMeta(stoniarkameta);


        if(p.getItemInHand().getType() == Material.AIR)
            return;
        if(p.getItemInHand().getItemMeta().getDisplayName() == null)
            return;

        if(p.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chat("&eStoniarka"))){
            if(e.getBlockPlaced().getType() == Material.SPONGE){
                p.getInventory().removeItem(stoniarka);
                e.getBlockPlaced().setType(Material.STONE);
                StoniarkaLokacja.add(e.getBlockPlaced().getLocation());
            }


        }
    }




    @EventHandler
    public void stoniarkatyp2(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Location loc = e.getBlock().getState().getLocation();

        ItemStack stoniarka = new ItemStack(Material.SPONGE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Utils.chat("&eStoniarka"));
        stoniarka.setItemMeta(stoniarkameta);

        if (e.getBlock().getType() == Material.STONE) {
            if(StoniarkaLokacja.contains(e.getBlock().getLocation())){
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(p.getItemInHand().getType().equals(Material.GOLD_PICKAXE)){
                            p.getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(stoniarka));
                            StoniarkaLokacja.remove(e.getBlock().getLocation());
                            cancel();
                            return;
                        }
                        e.getBlock().setType(Material.STONE);    //Sponge lub EnderStone pod tym co bedzie dawalo sygnal temu zeby stone sie respil (zloty kilof przerywa runnable)
                    }

                }.runTaskLater(Main.getInstance(), 20); //szybsza stoniarka mniejsza wartosc 20 = 1sec (zrobic nowy itemstack np SUPER SZYBKA STONIARKA, i stone bedzie sie respic co 0,5 sec)
            }
        }
    }



}





//lokalizacja array
//zloty kilof po wykopaniu endstone wypada stoniarka
//endstone (nad endstone pojawia sie stone)
//onblockbreak






