package com.sparkle;

import java.awt.Color;

public class Spark {
    public double x, y;
    public double dy;
    public final java.awt.Color color;

    public Spark(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.dy = 0;
        this.color = color;
    }
}
