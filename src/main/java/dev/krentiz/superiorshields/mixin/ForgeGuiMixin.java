package dev.krentiz.superiorshields.mixin;

import net.minecraftforge.client.gui.overlay.ForgeGui;
import dev.krentiz.superiorshields.shiftOffsetProvider;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ForgeGui.class)
public abstract class ForgeGuiMixin {

    @ModifyVariable(method = "renderRecordOverlay(IIFLnet/minecraft/client/gui/GuiGraphics;)V", at = @At("STORE"), ordinal = 3, remap = false)
    private int shiftRecordOverlay(int shiftOffset) {
        return shiftOffset + shiftOffsetProvider.shiftOffset();
    }
}