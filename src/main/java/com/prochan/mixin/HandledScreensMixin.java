package com.prochan.mixin;

import com.prochan.modules.NoInventoryGUI;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HandledScreens.class)
public class HandledScreensMixin {
    @Mixin(targets = "net.minecraft.client.gui.screen.ingame.HandledScreens$Provider")
    public interface ScreenHandlerProviderMixin<T extends ScreenHandler, U extends Screen> {
        @Redirect(method = "open", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;setScreen(Lnet/minecraft/client/gui/screen/Screen;)V"))
        private void setScreen(MinecraftClient instance, Screen screen){
            NoInventoryGUI guiTools = Modules.get().get(NoInventoryGUI.class);
            if(!guiTools.isActive()) { instance.setScreen(screen); }
        }
    }

}
