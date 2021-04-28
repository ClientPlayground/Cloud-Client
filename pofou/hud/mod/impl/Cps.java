package pofou.hud.mod.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.Gui;
import pofou.hud.mod.HudMod;

public class Cps extends HudMod{

	public int FPS = mc.debugFPS;
	
	public Cps() {
		super("Cps Counter", 50, 50);
	}
	
	private List<Long> clicks = new ArrayList<Long>();
	private boolean wasPressed;
	private long lastPressed;
	
	private List<Long> clicks2 = new ArrayList<Long>();
	private boolean wasPressed2;
	private long lastPressed2;

	@Override
	public void draw() {
		final boolean lpressed = Mouse.isButtonDown(0);
		final boolean rpressed = Mouse.isButtonDown(1);
		
		if(lpressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis() + 10;
			this.wasPressed = lpressed;
			if(lpressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		
		if(rpressed != this.wasPressed2) {
			this.lastPressed2 = System.currentTimeMillis() + 10;
			this.wasPressed2 = rpressed;
			if(rpressed) {
				this.clicks2.add(this.lastPressed2);
			}
		}
		
			fr.drawStringWithShadow("§7[" + "§fCPS§f:" + " " + getCPS() + ":" + getCPS2() + "§7]", getX() + 1, getY() + 1, 0x595959);
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawStringWithShadow("§7[" + "§fCPS:§f 6:9" + "§7]", getX() + 1, getY() + 1, 0x595959);
		super.renderDummy(mouseX, mouseY);
	}
	
	private int getCPS() {
		final long time = System.currentTimeMillis();
		this.clicks.removeIf(aLong -> aLong + 1000 < time);
		return this.clicks.size();
	}
	
	private int getCPS2() {
		final long time2 = System.currentTimeMillis();
		this.clicks2.removeIf(aLong2 -> aLong2 + 1000 < time2);
		return this.clicks2.size();
	}
	
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("§7[" + "§fCPS§f:  2:2" + "§7]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
}
