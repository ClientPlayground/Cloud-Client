package pofou.mod.impl;

import pofou.mod.Category;
import pofou.mod.Mod;
import pofou.event.*;
import pofou.event.impl.*;

public class ToggleSprint extends Mod {

	public ToggleSprint() {
		super("ToggleSprint", "ToggleSprint Toggles Your sprint!", Category.WORLD);
		// TODO Auto-generated constructor stub
	}
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if(this.isEnabled() && !mc.thePlayer.isBlocking() && !mc.thePlayer.isSneaking() && !mc.thePlayer.isUsingItem()) {
		  mc.thePlayer.setSprinting(true);
		}
	}
	
	
}
