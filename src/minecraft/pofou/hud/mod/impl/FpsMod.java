package pofou.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import pofou.hud.mod.HudMod;

public class FpsMod extends HudMod{

	public int FPS = mc.debugFPS;
	
	public FpsMod() {
		super("FPS Mod", 10, 10);
	}

	@Override
	public void draw() {
		fr.drawStringWithShadow("§7[" + "§fFPS: §f" + mc.debugFPS + "§7]", getX(), getY(), 0x595959);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawStringWithShadow("§7[" + "§fFPS: §f" + "69" + "§7]", getX(), getY(), 0x595959);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	
	@Override
	public int getWidth() {
		return fr.getStringWidth(name);
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
}
