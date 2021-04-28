package pofou.hud;

import net.minecraft.client.gui.GuiScreen;
import pofou.Pofou;
import pofou.hud.mod.HudMod;

public class HudConfigScreen extends GuiScreen {

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		for(HudMod m : Pofou.INSTANCE.hm.hudmods) {
			if(m.isEnabled()) {
				m.renderDummy(mouseX, mouseY);
			}
			
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
}
