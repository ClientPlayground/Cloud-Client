package pofou.gui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import pofou.Pofou;
import pofou.gui.clickgui.comp.ModButton;
import pofou.gui.clickgui.comp.ModButton2;

public class ClickGUI extends GuiScreen{
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	ArrayList<ModButton2> modButtons2 = new ArrayList<>();
	
	@Override
	public void initGui() {
		super.initGui();
		this.modButtons2.add(new ModButton2(210, 60, 42, 13, Pofou.INSTANCE.hm.fps));
		this.modButtons.add(new ModButton(290, 60, 64, 13, Pofou.INSTANCE.hm.cps));
		this.modButtons.add(new ModButton(370, 60, 64, 13, Pofou.INSTANCE.hm.ar));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, new Color(0,0,0,170).getRGB());
		
		for(ModButton m : modButtons) {
			m.draw();
		}
		for(ModButton2 m2 : modButtons2) {
			m2.draw();
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
		for(ModButton2 m2: modButtons2) {
			m2.onClick(mouseX, mouseY, mouseButton);
		}
	}
	
	
}
