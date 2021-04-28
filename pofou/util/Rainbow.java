package pofou.util;
 
import java.awt.Color;

import net.minecraft.client.Minecraft;
 
public class Rainbow {
   
    public static Color rainbowEffect(long offset, float fade){
        float hue = (float) (System.nanoTime() + offset) / 1.0E10F % 1.0F;
        long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 1.0F, 1.0F)).intValue()), 16);
        Color c = new Color((int) color);
        return new Color(c.getRed()/255.0F*fade, c.getGreen()/255.0F*fade, c.getBlue()/255.0F*fade, c.getAlpha()/255.0F);
    }
    
    public static Color rainbowEffectFast(long offset, float fade){
        float hue = (float) (System.nanoTime() + offset) / 1.0E10F % 1.0F;
        long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 1.0F, 1.0F)).intValue()), 19);
        Color c = new Color((int) color);
        return new Color(c.getRed()/255.0F*fade, c.getGreen()/255.0F*fade, c.getBlue()/255.0F*fade, c.getAlpha()/255.0F);
    }
    
    public static class RainbowColor
    {
        public static int getColor() {
            final long l = System.currentTimeMillis();
            return Color.HSBtoRGB(l % 2000L / 2000.0f, 0.8f, 0.8f);
        }
    }
    
    public static Color colorLerpv2(Color start, Color end, float ratio) {
        int red = (int)Math.abs((ratio * start.getRed()) + ((1 - ratio) * end.getRed()));
        int green = (int)Math.abs((ratio * start.getGreen()) + ((1 - ratio) * end.getGreen()));
        int blue = (int)Math.abs((ratio * start.getBlue()) + ((1 - ratio) * end.getBlue()));
        
        return new Color(red, green, blue);
    }
    
    public static void drawChromaString(String string, int x, int y, boolean shadow) {
        Minecraft mc = Minecraft.getMinecraft();

        int xTmp = x;
        for (char textChar : string.toCharArray()) {
            long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
            int i = Color.HSBtoRGB(l % (int) 2000.0F / 2000.0F, 0.8F, 0.8F);
            String tmp = String.valueOf(textChar);
            mc.fontRendererObj.drawString(tmp, xTmp, y, i, shadow);
            xTmp += mc.fontRendererObj.getCharWidth(textChar);
        }
    }
    
    public static int getChromaColor() {
        Minecraft mc = Minecraft.getMinecraft();

        int xTmp = 1;
            long l = System.currentTimeMillis() - (xTmp * 10 - 1 * 10);
            int i = Color.HSBtoRGB(l % (int) 2000.0F / 2000.0F, 0.8F, 0.8F);
            return i;
        
    }
}