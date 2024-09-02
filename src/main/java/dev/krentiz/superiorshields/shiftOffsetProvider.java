package dev.krentiz.superiorshields;

import net.minecraft.client.Minecraft;
// import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class shiftOffsetProvider {
    public static int shiftOffset() {
        Minecraft minecraft = Minecraft.getInstance();
        Player playerEntity = minecraft.player;
        int offset = 0;
        if (!(playerEntity == null)) {
            // CompoundTag entityNBT = playerEntity.serializeNBT();
            if (playerEntity.getArmorValue() > 0) {
                offset += 10;
            }
        }
        return offset;
    }
}