package ru.engineering.one;

import static ru.engineering.one.SnakeGame.*;
import java.awt.*;

public class Point {
    int x,y;
    Color color = Color.blue;

    public Point(int x, int y) {
        this.setXY(x, y);
    }
    void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x * POINT_RADIUS, y*POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }

    int getX() {
        return x;
    }
    int getY() {
        return y;
    }

    void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
}
