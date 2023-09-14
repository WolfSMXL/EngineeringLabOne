package ru.engineering.one;

import java.awt.*;

import static ru.engineering.one.SnakeGame.POINT_RADIUS;

public class Point {
    int x, y;
    Color color = Color.cyan;

    public Point(int x, int y) {
        this.setXY(x, y);
    }

    void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
