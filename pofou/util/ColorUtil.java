package pofou.util;

import java.awt.Color;

public class ColorUtil {

    public static int getRaibow(float seconds, float saturation, float brightness) {
        float hue = (System.currentTimeMillis() % (int)(seconds * 1000) / (float) (seconds * 1000f));
        int color = Color.HSBtoRGB(hue, saturation, brightness);
        return color;
    }

    public static int getRaibow(float seconds, float saturation, float brightness, long index) {
        float hue = ((System.currentTimeMillis() + index) % (int)(seconds * 1000) / (float) (seconds * 1000f));
        int color = Color.HSBtoRGB(hue, saturation, brightness);
        return color;
    }
}
