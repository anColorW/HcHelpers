package me.color;

import me.color.gui.*;
import me.color.komendy.Komenda;
import me.color.listeners.*;
import me.color.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Main extends JavaPlugin {

    public static ItemStack rzucak;


    static Main instance;




    @Override
    public void onEnable() {
        System.out.println("test");
        new Komenda(this);
        init();
        events();
        instance = this;
        recipe();
    }

    public static Main getInstance() {
        return instance;
    }

    public void init(){
        BoykiGui.initialize();
        RzucakGui.initialize();
        GuiGeneral.initialize();
        AfosaGui.initialize();
        SandyGui.initialize();
        StoniarkiGUI.initialize();
    }

    public void events(){
        new Rzucaki(this);
        new Autofosa(this);
        new Sandy( this);
        new Stoniarki( this);
        new Boyfarmery( this);
        new Listeners( this);
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
