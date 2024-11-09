package cn.cyanbukkit.example.listener

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

object PlayerBindsListener : Listener {

    lateinit var blockPos1: Block
    lateinit var blockPos2: Block


    fun isSet(): Boolean {
        if (!this::blockPos1.isInitialized)
            return false
        if (!this::blockPos2.isInitialized)
            return false
        return true
    }


    fun getItemStack(): ItemStack {
        val item = ItemStack(Material.NETHER_STAR)
        item.itemMeta = item.itemMeta?.apply {
            this.displayName = "§6§l绑定物品"
            this.lore = mutableListOf("§7§o左键点击第一块", "§7§o右键点击第二块", " /cyanbukkit startBreak§7§o开始破坏")
        }
        return item
    }


    @EventHandler
    fun onBlockSet(e: PlayerInteractEvent) {
        if (!e.hasItem()) return
        if (e.item.isSimilar(getItemStack())) {
            if (e.action == Action.LEFT_CLICK_BLOCK) {
                blockPos1 = e.clickedBlock!!
                e.player.sendMessage("First block set")
                e.isCancelled = true
            } else if (e.action == Action.RIGHT_CLICK_BLOCK) {
                blockPos2 = e.clickedBlock!!
                e.player.sendMessage("Second block set /cyanbukkit startBreak")
                e.isCancelled = true
            }
        }

    }


}