package cn.cyanbukkit.example.utils

import org.bukkit.Bukkit
import org.bukkit.block.Block

data class Region(
    val world: String, val x1: Int, val y1: Int, val z1: Int, val x2: Int, val y2: Int, val z2: Int
) {


    fun getBlocks(): List<Block> {
        val blocks = mutableListOf<Block>()
        val world = Bukkit.getWorld(this.world)
        val minX = minOf(x1, x2)
        val maxX = maxOf(x1, x2)
        val minY = minOf(y1, y2)
        val maxY = maxOf(y1, y2)
        val minZ = minOf(z1, z2)
        val maxZ = maxOf(z1, z2)

        for (y in maxY downTo minY) {
            for (x in minX..maxX) {
                for (z in minZ..maxZ) {
                    blocks.add(world.getBlockAt(x, y, z))
                }
            }
        }
        return blocks
    }

}