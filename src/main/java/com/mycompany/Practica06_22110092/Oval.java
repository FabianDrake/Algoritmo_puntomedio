
package com.mycompany.Practica06_22110092;

import java.awt.*;

public class Oval extends Figure {
    private int centerX, centerY, width, height;

    public Oval(int centerX, int centerY, int width, int height) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.ORANGE); // Color para óvalo
        g.drawOval(centerX - width / 2, centerY - height / 2, width, height);
    }
}

