package cn.cyanbukkit.example.command;

import cn.cyanbukkit.example.Example;
import cn.cyanbukkit.example.cyanlib.command.CyanCommand;
import cn.cyanbukkit.example.cyanlib.command.RegisterCommand;
import cn.cyanbukkit.example.cyanlib.command.RegisterSubCommand;
import cn.cyanbukkit.example.cyanlib.inventory.SmartInventory;
import cn.cyanbukkit.example.listener.PlayerBindsListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RegisterCommand(name = "CyanBukkit", permission = "CyanBukkit.dev")
public class MyCommand extends CyanCommand {


    @Override
    public void mainExecute(CommandSender sender, String commandLabel, String[] args) {

    }


    @RegisterSubCommand(subName = "test")
    public void subCommand(CommandSender sender, String commandLabel, String[] args) {
        sender.sendMessage("§8这是一个子指令");
    }


    @RegisterSubCommand(subName = "give")
    public void gui(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().addItem(PlayerBindsListener.INSTANCE.getItemStack());
            player.sendMessage(ChatColor.GREEN + "你获得了一个绑定物品");
        }
    }


    @RegisterSubCommand(subName = "startBreak")
    public void startBreak(CommandSender sender, String commandLabel, String[] args) {
        Example.INSTANCE.startBreak((Player)sender);
    }


}
