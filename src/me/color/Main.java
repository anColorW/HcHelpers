package me.color;

import me.color.komendy.Komenda;
import me.color.listeners.Autofosa;
import me.color.listeners.Rzucaki;
import me.color.listeners.Sandy;
import me.color.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static ItemStack rzucak;

    @Override
    public void onEnable() {
        System.out.println("test");
        new Komenda(this);
        getServer().getPluginManager().registerEvents(new Rzucaki(), this);
        getServer().getPluginManager().registerEvents(new Autofosa(), this);
        getServer().getPluginManager().registerEvents(new Sandy(), this);
        recipe();
    }

    private void recipe()
    {
         rzucak = new ItemStack(Material.TNT);
        ItemMeta rzucakmeta = rzucak.getItemMeta();
        rzucakmeta.setDisplayName(Utils.chat("&4&kW &r &c&lRzucane &f&lTNT &4&kW"));
        rzucak.setItemMeta(rzucakmeta);


        ItemStack ilosc = new ItemStack(Material.TNT);

        ShapelessRecipe rzucanetnt = new ShapelessRecipe(rzucak);
        rzucanetnt.addIngredient(9, Material.TNT);
        //jebac te craftingi

        Bukkit.getServer().addRecipe(rzucanetnt);
    }

}
