package net.fabricmc.example;
import net.minecraft.client.MinecraftClient;

public class FullBright extends Module {
    public FullBright() { super("FullBright"); }
    @Override
    public void onEnable() {
        if (MinecraftClient.getInstance().options != null) {
            MinecraftClient.getInstance().options.getGamma().setValue(100.0);
        }
    }
    @Override
    public void onDisable() {
        if (MinecraftClient.getInstance().options != null) {
            MinecraftClient.getInstance().options.getGamma().setValue(1.0);
        }
    }
}

