package com.sparkle;

import java.awt.*;

public class Renderer {

    public void draw(Graphics g, Spark s) {
        g.setColor(s.color);
        g.fillRect((int)s.x, (int)s.y, 3, 3);

        g.setColor(new Color(s.color.getRed(), s.color.getGreen(), s.color.getBlue(), 40));
        g.fillRect((int)s.x - 1, (int)s.y - 1, 5, 5);
    }
}

