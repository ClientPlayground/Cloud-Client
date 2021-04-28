package pofou.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import pofou.hud.mod.HudMod;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class armour extends HudMod{

	public int FPS = mc.debugFPS;
	
	public armour() {
		super("Armour Status", 50, 50);
	}

	@Override
	public void draw() {
		for (int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; i++) {
		      ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
		      renderItemStack(i, itemStack);
		     
		    } 
		super.draw();
	}
	
	 private void renderItemStack( int i, ItemStack itemStack) {
		    if (itemStack == null)
		      return; 
		    GlStateManager.pushMatrix();
		    int yAdd = -16 * i + 48;
		    if (itemStack.getItem().isDamageable())
		      this.fr.drawStringWithShadow(String.valueOf(itemStack.getMaxDamage() - itemStack.getItemDamage()), (getX() + 20), (getY() + yAdd + 5), -1); 
		    RenderHelper.enableGUIStandardItemLighting();
		    this.mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, getX(), getY() + yAdd);
		    GlStateManager.popMatrix();
		  }
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		renderItemStack( 3, new ItemStack((Item)Items.diamond_helmet));
	    renderItemStack( 2, new ItemStack((Item)Items.diamond_chestplate));
	    renderItemStack( 1, new ItemStack((Item)Items.diamond_leggings));
	    renderItemStack( 0, new ItemStack((Item)Items.diamond_boots));
		super.renderDummy(mouseX, mouseY);
	}
	
	
	@Override
	public int getWidth() {
		 return 40;
	}
	
	@Override
	public int getHeight() {
		 return 60;
	}
	
}
