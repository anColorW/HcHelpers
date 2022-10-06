package me.color.komendy;

import me.color.gui.GuiGeneral;
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
        plugin.getCommand("rzucak").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        p.getInventory().addItem(ItemStacks.getBoyki());
        p.getInventory().addItem(ItemStacks.getSandy());
        p.getInventory().addItem(ItemStacks.getRzucak());
        p.getInventory().addItem(ItemStacks.getStoniarki(1));
        p.getInventory().addItem(ItemStacks.getStoniarki(2));
        p.getInventory().addItem(ItemStacks.getFosa());


        p.openInventory(GuiGeneral.GuiMain(p));

        for(int i = 0; i < Stoniarki.StoniarkaLokacja.size(); i++){
            System.out.println(Stoniarki.StoniarkaLokacja.get(i));
        }





        return false;
    }
}
