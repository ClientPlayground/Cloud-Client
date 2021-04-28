package pofou.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import pofou.Pofou;
import pofou.event.EventManager;
import pofou.gui.hud.IRenderer;
import pofou.gui.hud.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer{ 
	
	public ModDraggable(String name) {
		super(name);
		this.name = name;
	}

	public final int getLineOffset(ScreenPosition pos, int lineNumber) {
	    return pos.getAbsoluteY() + getLineOffset(lineNumber);
	  }
	  
	  private int getLineOffset(int lineNumber) {
	    return (fr.FONT_HEIGHT + 3) * lineNumber;
	  }
}
