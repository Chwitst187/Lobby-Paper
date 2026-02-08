package org.bukkit.craftbukkit.event.block;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.material.MaterialData;

public class CraftFurnaceExtractEvent extends CraftBlockExpEvent implements FurnaceExtractEvent {

    private final Player player;
    private final Material itemType;
    private final int itemAmount;

    public CraftFurnaceExtractEvent(final Player player, final Block block, final Material itemType, final int itemAmount, final int exp) {
        super(block, exp);
        this.player = player;
        if (itemType != null && itemType.isLegacy()) {
            this.itemType = Bukkit.getUnsafe().fromLegacy(new MaterialData(itemType), true);
        } else {
            this.itemType = itemType;
        }
        this.itemAmount = itemAmount;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public Material getItemType() {
        return this.itemType;
    }

    @Override
    public int getItemAmount() {
        return this.itemAmount;
    }
}
