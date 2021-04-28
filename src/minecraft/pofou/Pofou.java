package pofou;

import java.awt.Color;

import org.lwjgl.opengl.Display;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import pofou.event.EventManager;
import pofou.event.EventTarget;
import pofou.event.impl.EventTick;
import pofou.gui.clickgui.ClickGUI;
import pofou.gui.hud.HUDManager;
import pofou.hud.HudConfigScreen;
import pofou.hud.mod.HudManager;
import pofou.mod.ModManager;
import pofou.mods.ModInstances;

public class Pofou {

	public EventManager EM;
	
	public static String Name = "Cloud Client", Version = "b3";
	public static Pofou INSTANCE = new Pofou();
	public static Minecraft mc = Minecraft.getMinecraft();
	public static ModManager mm;
	public static HudManager hm;
	
	private HUDManager hud;
	
	public void startup() {
		hm = new HudManager();
		EM = new EventManager();
		mm = new ModManager();
		Display.setTitle("Cloud Client b3");
		
		ModInstances.register(hud);
		EM.register(this);
		
	}
	
	public void init() {
		hud = new HUDManager();
		ModInstances.register(hud);

	}
	
	public void ingameGUI() {
		GlStateManager.scale(2, 2, 5);
		mc.fontRendererObj.drawStringWithShadow("Cloud Client b3", 1, 1, Color.RED.getRGB());
		GlStateManager.scale(2, 2, 5);
	}
	
	public void shutdown() {
		EM = new EventManager();
		
		EM.unregister(this);
	}
	
	@EventTarget
	public void onTick(EventTick event) {
		if(mc.gameSettings.TOGGLESPRINT.isPressed()) {
			mm.TM.toggle();
		}
		if(mc.gameSettings.CLIENT_POS.isPressed()) {
			mc.displayGuiScreen(new HudConfigScreen());
		}
		if(mc.gameSettings.CLIENT_HUD.isPressed()) {
			mc.displayGuiScreen(new ClickGUI());
		}
		if(mc.gameSettings.CLIENT_MOD_POS.isPressed()) {
			hud.openConfigScreen();
		}
		
		
	}
	
}
