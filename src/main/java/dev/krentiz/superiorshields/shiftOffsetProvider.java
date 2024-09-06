package dev.krentiz.superiorshields;

import java.util.Optional;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

public class shiftOffsetProvider {
    private static final String SUPERIOR_SHIELD_CURIO = "superior_shield";

    private static int yShift = 0;

    private static void shiftOffset(Player playerEntity) {
        Optional<ICuriosItemHandler> handler = CuriosApi.getCuriosInventory(playerEntity).resolve();
        handler.ifPresent(itemHandler -> itemHandler.getStacksHandler(SUPERIOR_SHIELD_CURIO)
                .ifPresent(stackHandler -> {
                    ItemStack stack = stackHandler.getStacks().getStackInSlot(0);
                    if (!stack.isEmpty()) {
                        if (playerEntity.getArmorValue() > 0
                                && (playerEntity.getAirSupply() == playerEntity.getMaxAirSupply()
                                        || playerEntity.getAbsorptionAmount() > 0)) {
                            yShift = 10;
                            return;
                        }
                    }
                    yShift = 0;
                }));
    }

    public static int getShiftOffset() {
        Minecraft minecraft = Minecraft.getInstance();
        Player playerEntity = minecraft.player;
        if (playerEntity instanceof Player && CuriosApi.getCuriosInventory(playerEntity).isPresent()) {
            if (minecraft.gameMode != null && minecraft.gameMode.canHurtPlayer())
                shiftOffset(playerEntity);
        }

        return yShift;
    }

}