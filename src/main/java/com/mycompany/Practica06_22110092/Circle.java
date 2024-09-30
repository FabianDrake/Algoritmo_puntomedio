
package com.mycompany.Practica06_22110092;

import java.awt.*;

public class Circle extends Figure {
    private int centerX, centerY, radius;

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.MAGENTA); // Color para círculo
        drawCircle(g, centerX, centerY, radius);
    }

    private void drawCircle(Graphics g, int centerX, int centerY, int radius) {
        int x = radius, y = 0;
        int p = 1 - radius; // p0

        while (x > y) {
            g.fillRect(centerX + x, centerY + y, 1, 1);
            g.fillRect(centerX - x, centerY + y, 1, 1);
            g.fillRect(centerX + x, centerY - y, 1, 1);
            g.fillRect(centerX - x, centerY - y, 1, 1);
            g.fillRect(centerX + y, centerY + x, 1, 1);
            g.fillRect(centerX - y, centerY + x, 1, 1);
            g.fillRect(centerX + y, centerY - x, 1, 1);
            g.fillRect(centerX - y, centerY - x, 1, 1);
            y++;

            // Decide the next point
            if (p < 0) {
                p += 2 * y + 1;
            } else {
                x--;
                p += 2 * y - 2 * x + 1;
            }
        }
    }
}
