package net.fabricmc.example;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Menu")); }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderInGameBackground(context);
        int y = 40;
        for (Module m : ModuleManager.getModules()) {
            int color = m.isEnabled() ? 0xFF00FF00 : 0xFFFF0000;
            context.fill(20, y, 120, y + 20, 0x80000000);
            context.drawTextWithShadow(this.textRenderer, m.getName(), 25, y + 6, color);
            y += 25;
        }
        super.render(context, mouseX, mouseY, delta);
    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int y = 40;
        for (Module m : ModuleManager.getModules()) {
            if (mouseX >= 20 && mouseX <= 120 && mouseY >= y && mouseY <= y + 20) {
                m.toggle();
                return true;
            }
            y += 25;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
    @Override
    public boolean shouldPause() { return false; }
}
