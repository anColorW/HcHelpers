package me.color.komendy;

import me.color.Main;
import me.color.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTTime implements CommandExecutor {
    public static Main plugin;

    public TNTTime(Main pl) {
        plugin = pl; //bez tego cfg sie pierdoli
        pl.getCommand("tnt").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);

        if(args.length != 2){
            p.sendMessage(Utils.chat("&7&l » &cPoprawne uzycie /tnt [OD GODZINY] [DO GODZINY]"));
            return true;
        }

       if(args[0].chars().allMatch(Character::isDigit) && args[1].chars().allMatch(Character::isDigit)){

           if(first > 24 || second > 24 || first < 0 || second < 0){
               p.sendMessage(Utils.chat("&7&l » &cPoprawne uzycie /tnt [OD GODZINY] [DO GODZINY]"));
               return true;
           }
           p.sendMessage(Utils.chat("&7&l » &aPoprawnie ustawiono czas TNT. "));
           Main.getInstance().getConfig().set("TNT.OD_GODZ", first);
           Main.getInstance().saveConfig();
           Main.getInstance().getConfig().set("TNT.DO_GODZ", second);
           Main.getInstance().saveConfig();
       } else{
           p.sendMessage(Utils.chat("&7&l » &cPoprawne uzycie /tnt [OD GODZINY] [DO GODZINY]"));
           return true;
       }

        return false;
    }
}
