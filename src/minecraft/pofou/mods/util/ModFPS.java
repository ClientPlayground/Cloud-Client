package pofou.mods.util;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import pofou.gui.hud.ScreenPosition;
import pofou.mods.ModDraggable;

public class ModFPS extends ModDraggable{

public int FPS = mc.debugFPS;
	
private ScreenPosition pos;

	public ModFPS() {
		super("FpsMod");
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("Test {Dummy}");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		fr.drawString("Test{Dummy}", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
		
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
			fr.drawString("Test {Dummy}", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
	}

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
		
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}
	

	

}
