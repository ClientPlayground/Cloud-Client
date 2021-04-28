package pofou.mod;

import java.util.ArrayList;

import pofou.mod.impl.*;

	public class ModManager {

	public ToggleSprint TM;
	
	public ArrayList<Mod> mod;
	
	public ModManager() {
		mod = new ArrayList<>();
		
		//MISC
		mod.add(TM = new ToggleSprint());
	}
	
}
