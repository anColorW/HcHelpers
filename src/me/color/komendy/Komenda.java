package me.color.komendy;

import me.color.listeners.Stoniarki;
import me.color.utils.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.color.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Komenda implements CommandExecutor {
    public static Main plugin;

    public Komenda(Main plugin) {
        plugin.getCommand("rzucak").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;


        ItemStack rzucak = new ItemStack(Material.TNT);
        ItemMeta rzucakmeta = rzucak.getItemMeta();
        rzucakmeta.setDisplayName(Utils.chat("&4&kW &r &c&lRzucane &f&lTNT &4&kW"));
        rzucak.setItemMeta(rzucakmeta);


        ItemStack autofosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta autofosameta = autofosa.getItemMeta();
        autofosameta.setDisplayName(Utils.chat("&7Boyfarmer"));
        autofosa.setItemMeta(autofosameta);

        ItemStack sandfarmer = new ItemStack(Material.SANDSTONE);
        ItemMeta sandfarmermeta = sandfarmer.getItemMeta();
        sandfarmermeta.setDisplayName(Utils.chat("&7Sandfarmer"));
        sandfarmer.setItemMeta(sandfarmermeta);

        ItemStack boyfarmer = new ItemStack(Material.OBSIDIAN);
        ItemMeta boyfarmermeta = boyfarmer.getItemMeta();
        boyfarmermeta.setDisplayName(Utils.chat("&8Sandfarmer"));
        boyfarmer.setItemMeta(boyfarmermeta);


        ItemStack stoniarka = new ItemStack(Material.SPONGE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Utils.chat("&eStoniarka"));
        stoniarka.setItemMeta(stoniarkameta);

        ItemStack stoniarkatyp1 = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkatyp2 = stoniarkatyp1.getItemMeta();
        stoniarkatyp2.setDisplayName(Utils.chat("&eStoniarka"));
        stoniarkatyp1.setItemMeta(stoniarkatyp2);

        //wiem ze dalo sie szybciej robiac public static

        p.getInventory().addItem(boyfarmer);
        p.getInventory().addItem(sandfarmer);
        p.getInventory().addItem(rzucak);
        p.getInventory().addItem(stoniarka);
        p.getInventory().addItem(stoniarkatyp1);



        return false;
    }
}
