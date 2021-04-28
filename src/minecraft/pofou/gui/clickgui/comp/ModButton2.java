package pofou.gui.clickgui.comp;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import pofou.hud.mod.HudMod;
import pofou.mods.ModDraggable;
import pofou.util.FontUtils;

public class ModButton2 {
	
	public FontUtils font;
		
	public int x, y, w, h;
	public ModDraggable m;
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public ModButton2(int x, int y, int w, int h, ModDraggable m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
	}
	
	public void draw() {
		font = FontUtils.getFontOnPC("Comfortaa", 15 );
		Gui.drawRect(x, y, x + w, y + h, new Color(0, 0, 0, 50).getRGB());
		font.drawStringWithShadow(m.name, x +  2, y + 2, getColor());
	}
	
	public int getColor() {
		if(m.isEnabled()) {
			return new Color(0, 255, 0, 255).getRGB();
		} else {
			
		}return new Color(255, 0, 0, 255).getRGB();
		
	}
	
	
	public void onClick(int mouseX, int mouseY, int button) {
		if(mouseX >= x && mouseX <= x+ w && mouseY >= y && mouseY <= y + h) {
			if(m.isEnabled()) {
				m.setEnabled(false);
				
			} else {
				m.setEnabled(true);
				
			}
			
		}
	}
	
}
