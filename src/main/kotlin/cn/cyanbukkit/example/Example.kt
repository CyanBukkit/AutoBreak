package cn.cyanbukkit.example

import cn.cyanbukkit.example.cyanlib.launcher.CyanPluginLauncher.cyanPlugin
import cn.cyanbukkit.example.listener.PlayerBindsListener
import cn.cyanbukkit.example.utils.Region
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*

object Example {

    var taskID = 0

    fun startBreak(p: Player) {
        if (PlayerBindsListener.isSet()) {
            val pos1 = PlayerBindsListener.blockPos1
            val pos2 = PlayerBindsListener.blockPos2
            val regionBlocks = Region(
                pos1.world.name,
                pos1.x, pos1.y, pos1.z,
                pos2.x, pos2.y, pos2.z
            ).getBlocks().toMutableList()
            if (taskID != 0) {
                p.sendMessage("§c§l任务已启动，请勿重复操作！")
                return
            }
            // 启动runnable 每秒一个blockautoBreak
            taskID = Bukkit.getScheduler().runTaskTimer(cyanPlugin, {
                if (regionBlocks.isEmpty()) {
                    Bukkit.getScheduler().cancelTask(taskID)
                    return@runTaskTimer
                }
                val b = regionBlocks.removeAt(0)
                b.breakNaturally()
            }, 0, 20).taskId
        }
    }

}