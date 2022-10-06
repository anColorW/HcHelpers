package me.color.komendy;

import me.color.gui.*;
import me.color.listeners.ItemStacks;
import me.color.listeners.Stoniarki;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.color.Main;
import org.bukkit.entity.Player;

public class Komenda implements CommandExecutor {
    public static Main plugin;

    public Komenda(Main plugin) {
        plugin.getCommand("craftingi").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(cmd.getLabel().equalsIgnoreCase("craftingi")){
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("rzucaki"))
                    p.openInventory(RzucakGui.RzucakGui(p));
                if(args[0].equalsIgnoreCase("autofosa"))
                    p.openInventory(AfosaGui.FosaGui(p));
                if(args[0].equalsIgnoreCase("sandfarmer"))
                    p.openInventory(SandyGui.SandGui(p));
                if(args[0].equalsIgnoreCase("boyfarmer"))
                    p.openInventory(BoykiGui.BoykiGui(p));
                if(args[0].equalsIgnoreCase("stoniarki"))
                    p.openInventory(StoniarkiGUI.Sgui(p));
            } else {
                p.openInventory(GuiGeneral.GuiMain(p));
            }
        }
        return false;
    }
}
