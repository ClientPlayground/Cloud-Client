package pofou.mods;

import pofou.gui.hud.HUDManager;
import pofou.mods.util.ModFPS;

public class ModInstances {

	public static ModFPS fps;
	
	public static void register(HUDManager api) {
		fps = new ModFPS();
		api.register(fps);
	}
	
	private static ModFPS getModFPS() {
		return fps;
		

	}
	
}
