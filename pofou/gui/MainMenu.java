package pofou.gui;

import pofou.util.FontUtils;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;



public class MainMenu extends GuiScreen {
	public int fade = 0;

	    public void drawScreen(int mouseX, int mouseY, float partialTicks)
	    {
	    	mc.getTextureManager().bindTexture(new ResourceLocation("864388.jpg"));
	    	
	    	GlStateManager.pushMatrix();
	    	
			this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
			
			GlStateManager.popMatrix();
			drawOctoVersion(mouseX, mouseY);
			GlStateManager.pushMatrix();
			GlStateManager.translate(width/2f, height/2f, 0);
			GlStateManager.scale(3, 3, 1);
			GlStateManager.translate(-(width/2f), -(height/2f), 0);
			this.drawCenteredString(mc.fontRendererObj, "Cloud Client", this.width / 2  - Minecraft.getMinecraft().fontRendererObj.getStringWidth("Cloud Client") + 90, this.height / 2 - 110, -1);
			GlStateManager.popMatrix();
					
			
	    }
	    public void drawOctoVersion(int mouseX, int mouseY) {
	    	
	    	Minecraft.getMinecraft().fontRendererObj.drawString("Cloud Client B3 Copyright Pofou" ,0 + 3, this.height - 12, -1);
	    	
	    
	    	String[] buttons = {"Singleplayer", "Multiplayer", "Option"}; 
	    	int count = 0;
	    
	    	for(String name : buttons) {
	    		boolean hovered = false;
	        	float x = this.width / 2 - 30;
	    		float y = this.height / 2 - 70 + (count * 30) + 27;
	        	if(mouseX >= x && mouseY >= y && mouseX < x + Minecraft.getMinecraft().fontRendererObj.getStringWidth(name) && mouseY < y + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT) {
	        		hovered = true;
	        	}else {
	        		hovered = false;
	        	}
	        
	        
				final Color a = new Color(255, 255, 255, this.fade);
	        	this.drawHollowRect(width /2 - 50, this.height / 2 - 70 + (count * 30) + 27, 100, 20, hovered ? 0x90000000: -1);
	        	Minecraft.getMinecraft().fontRendererObj.drawString(name,this.width /2 - 30, this.height / 2 - 70 + (count * 30) + 30, hovered ? 0x90000000: -1);
	    		count ++;
			}

	    	
			
	    	}
	    private void drawHollowRect(int x, int y, int w, int h, int color) {
			this.drawHorizontalLine(x, x+w, y, color);
			this.drawHorizontalLine(x, x+w, y + h, color);
			
			this.drawVerticalLine(x, y + h, y, color);
			this.drawVerticalLine(x + w, y + h, y, color);
			
			
		}

	    /**
	     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
	     */
	    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	    
	    {
	    	
	    	
	    	String[] buttons = {"Singleplayer", "Multiplayer", "Options"}; 
	    	int count = 0;
	    	
	    	for(String name : buttons) {
	    		float x = this.width /2 - 30;
	    		float y = this.height / 2 - 70 + (count * 30) + 27;
	    		if(mouseX >= x && mouseY >= y && mouseX < x + Minecraft.getMinecraft().fontRendererObj.getStringWidth(name) && mouseY < y + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT) {
	    			switch(name) {
	    			case "Singleplayer":
	    				mc.displayGuiScreen(new GuiSelectWorld(this));
	    				break;
	    			case "Multiplayer":
	    				mc.displayGuiScreen(new GuiMultiplayer(this));
	    				break;
	    			case "Options":
	    				mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
	    				break;
	    		
	    			}
	    		}
	    		count++;
			}
	    	
	    	
	    }
}
