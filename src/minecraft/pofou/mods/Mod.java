package pofou.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import pofou.Pofou;
import pofou.event.EventManager;

public class Mod {
	
	public boolean isEnabled = true;
	
	protected final Minecraft mc;
	protected final FontRenderer fr;
	protected final Pofou client;
	public String name;
	
	public Mod(String name) {
		this.name = name;
		this.mc = Minecraft.getMinecraft();
		this.fr = this.mc.fontRendererObj;
		this.client = Pofou.INSTANCE;
		
		setEnabled(isEnabled);
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		
		if(isEnabled) {
			EventManager.register(this);
		}else {
			EventManager.unregister(this);
		}
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

}
