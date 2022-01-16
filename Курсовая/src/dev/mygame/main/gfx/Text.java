package dev.mygame.main.gfx;

import java.awt.*;
import java.io.Serializable;

public class Text {

    public static void drawString(Graphics g,String text,  int xpos, int ypos, Color c, Font font) {
        g.setColor(c);
        g.setFont(font);
        int x = xpos;
        int y = ypos;

        g.drawString(text, x, y);
    }

}
