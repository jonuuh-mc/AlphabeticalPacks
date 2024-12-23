package io.jonuuh.alphabeticalpacks.mixins;

import io.jonuuh.alphabeticalpacks.PackComparator;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import net.minecraft.client.resources.ResourcePackListEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GuiScreenResourcePacks.class)
public abstract class MixinGuiScreenResourcePacks extends GuiScreen
{
    @Shadow
    private List<ResourcePackListEntry> availableResourcePacks;

    @Inject(method = "initGui", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/GuiScreenResourcePacks;availableResourcePacksList:Lnet/minecraft/client/gui/GuiResourcePackAvailable;", ordinal = 0))
    private void AlphabeticalPacks$sortAvailablePacks(CallbackInfo ci)
    {
        availableResourcePacks.sort(new PackComparator());
    }
}
