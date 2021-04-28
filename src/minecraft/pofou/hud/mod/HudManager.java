package pofou.hud.mod;

import java.util.ArrayList;

import pofou.hud.mod.impl.*;
import pofou.mods.util.ModFPS;

public class HudManager {

	public ArrayList<HudMod> hudmods = new ArrayList<>();
	
	public FpsMod fpsmod;
	public Cps cps;
	public armour ar;
	public ModFPS fps;
	
	public HudManager() {
		hudmods.add(fpsmod = new FpsMod());
		hudmods.add(cps = new Cps());
		hudmods.add(ar = new armour());
		fps = new ModFPS();
	}
	
	public void renderMods() {
		for(HudMod m : hudmods ) {
			if(m.isEnabled()) {
				m.draw();
			}
			
		}
	}
	
	
	
	
	
	
}
