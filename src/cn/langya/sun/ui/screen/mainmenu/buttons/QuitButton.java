package cn.langya.sun.ui.screen.mainmenu.buttons;

import cn.langya.sun.ui.FontManager;
import cn.langya.sun.utils.render.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class QuitButton extends ImageButton {

	public QuitButton(int x, int y) {
		super("退出", new ResourceLocation("lunar/icons/exit.png"), x, y);
	}
	
	@Override
	public void drawButton(int mouseX, int mouseY) {
		boolean hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
		if (hovered) {
			if (hoverFade < 40) hoverFade += 10;
			
			drawHoverEffect();
		} else {
			if (hoverFade > 0) hoverFade -= 10;
		}
		
		RenderUtil.drawRoundedRect(this.x - 1, this.y - 1, this.width + 2, this.height + 2, 2, new Color(30, 30, 30, 60));
		RenderUtil.drawRoundedRect(this.x, this.y, this.width, this.height, 2, new Color(255, 255 - hoverFade * 4, 255 - hoverFade * 4, 38 + hoverFade));

		RenderUtil.drawRoundedOutline(this.x, this.y, this.x + this.width, this.y + this.height, 2, 3, new Color(255, 255, 255, 30).getRGB());
		
		int color = new Color(232, 232, 232, 183).getRGB();
		float f1 = (color >> 24 & 0xFF) / 255.0F;
        float f2 = (color >> 16 & 0xFF) / 255.0F;
        float f3 = (color >> 8 & 0xFF) / 255.0F;
        float f4 = (color & 0xFF) / 255.0F;
		GL11.glColor4f(f2, f3, f4, f1);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		Gui.drawModalRectWithCustomSizedTexture(this.x + 3, this.y + 3, 0, 0, 6, 6, 6, 6);
		
		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
	}
	
	@Override
	protected void drawHoverEffect() {
		int w = (int) (FontManager.getStringWidth(this.text));
		RenderUtil.drawRoundedRect(this.x + (this.width - w) / 2, this.y + 17, w, 7, 2, new Color(0, 0, 0, 126));
		FontManager.drawCenteredTextScaled(this.text, this.x + this.width / 2, this.y + 18, new Color(255, 255, 255, 135).getRGB(), 0.9F);
	}

}
