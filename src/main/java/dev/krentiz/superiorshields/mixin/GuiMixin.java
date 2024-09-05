package dev.krentiz.superiorshields.mixin;

import dev.krentiz.superiorshields.shiftOffsetProvider;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Gui.class)
public abstract class GuiMixin {

    @ModifyVariable(method = "renderSelectedItemName(Lnet/minecraft/client/gui/GuiGraphics;I)V", at = @At("STORE"), ordinal = 3, remap = false)
    private int shiftSelectedItemNameGui(int shiftOffset) {
        return shiftOffset - shiftOffsetProvider.getShiftOffset();
    }

}