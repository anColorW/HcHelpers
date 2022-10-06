package me.color;

import me.color.gui.AutofosaGui;
import me.color.gui.GuiGeneral;
import me.color.gui.Listeners;
import me.color.gui.RzucakGui;
import me.color.komendy.Komenda;
import me.color.listeners.*;
import me.color.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static ItemStack rzucak;


    static Main instance;




    @Override
    public void onEnable() {
        System.out.println("test");
        new Komenda(this);
        AutofosaGui.initialize();
        RzucakGui.initialize();
        GuiGeneral.initialize();
        getServer().getPluginManager().registerEvents(new Rzucaki(), this);
        getServer().getPluginManager().registerEvents(new Autofosa(), this);
        getServer().getPluginManager().registerEvents(new Sandy(), this);
        new Stoniarki( this);
        getServer().getPluginManager().registerEvents(new Boyfarmery(), this);
        getServer().getPluginManager().registerEvents(new Listeners(), this);



        instance = this;
        recipe();
    }

    public static Main getInstance() {
        return instance;
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
