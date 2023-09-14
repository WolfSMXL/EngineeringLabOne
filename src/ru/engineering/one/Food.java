package ru.engineering.one;

import java.awt.*;

import static ru.engineering.one.SnakeGame.*;

public class Food extends Point {
    private static final Color[] COLORS = {Color.green, Color.blue, Color.red, Color.yellow, Color.pink};

    public Food() {
        super(-1, -1);
        this.color = COLORS[random.nextInt(COLORS.length - 1)];
    }

    public void eat() {
        this.setXY(-1, -1);
    }

    public boolean isEaten() {
        return this.getX() == -1;
    }

    public void next() {
        int x, y;
        do {
            x = random.nextInt(FILLED_WIDTH);
            y = random.nextInt(FILLED_HEIGHT);
        } while (snake.isInsideSnake(x, y));
        this.setXY(x, y);
        this.changeColor();

    }

    public void changeColor() {
        this.color = COLORS[random.nextInt(COLORS.length)];
    }
}