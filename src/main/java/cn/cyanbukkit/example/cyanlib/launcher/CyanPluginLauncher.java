package cn.cyanbukkit.example.cyanlib.launcher;

import cn.cyanbukkit.example.command.MyCommand;
import cn.cyanbukkit.example.cyanlib.loader.KotlinBootstrap;
import cn.cyanbukkit.example.listener.PlayerBindsListener;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

/**
 * 嵌套框架
 */

public class CyanPluginLauncher extends JavaPlugin {

    public static CyanPluginLauncher cyanPlugin;

    public CyanPluginLauncher() {
        cyanPlugin = this;
        KotlinBootstrap.init();
        JavaHandle.getJavaVersionToDownloadHikaricp();
    }


    @Override
    public void onLoad() {
    }


    @Override
    public void onEnable() {
        new MyCommand().register();
        getServer().getPluginManager().registerEvents(PlayerBindsListener.INSTANCE, this);
    }

    @Override
    public void onDisable() {

    }



}