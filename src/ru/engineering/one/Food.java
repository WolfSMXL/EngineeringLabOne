package ru.engineering.one;

import java.awt.*;

import static ru.engineering.one.SnakeGame.*;

public class Food extends Point {

    public Food() {
        super(-1,-1);
        this.color = Color.green;
    }

    public void eat(){
        this.setXY(-1,-1);
    }

    public boolean isEaten() {
        return this.getX() == -1;
    }

    public void next() {
        int x, y;
        do {
            x = random.nextInt(FILLED_WIDTH);
            y = random.nextInt(FILLED_HEIGHT);
        }while(snake.isInsideSnake(x,y));
        this.setXY(x,y);

    }


}