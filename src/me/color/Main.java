package me.color;

import me.color.gui.*;
import me.color.komendy.Komenda;
import me.color.komendy.TNTTime;
import me.color.listeners.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    public static ItemStack rzucak;


    static Main instance;

    public static FileConfiguration cfg;

    @Override
    public void onEnable() { //dodac config
        new Komenda(this);
        new TNTTime(this);
        init();
        events();
        instance = this;
        reloadConfig();

    }

    public void setDefault() {
        cfg.addDefault("TNT.TIME", Boolean.valueOf(false));
        cfg.addDefault("TNT.OD_GODZ", Integer.valueOf(16));
        cfg.addDefault("TNT.DO_GODZ", Integer.valueOf(16));
        cfg.options().copyDefaults(false);
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




}
