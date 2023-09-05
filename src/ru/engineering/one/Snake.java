package ru.engineering.one;

import java.awt.*;
import java.util.ArrayList;

import static ru.engineering.one.SnakeGame.*;

public  class Snake {
    ArrayList<Point> snake = new ArrayList<Point>();
    int direction;
    final String TITLE_OF_PROGRAM = "Classic Game Snake";

    public Snake(int x, int y, int length, int direction){
        for(int i = 0; i<length; i++){
            Point point = new Point(x-i, y);
            snake.add(point);
        }
        this.direction = direction;
    }
    boolean isInsideSnake(int x, int y){
        for(Point point : snake){
            if((point.getX() == x) && (point.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    boolean isFood (Point food) {
        return ((snake.get(0).getX() == food.getX()) && (snake.get(0).getY() == food.getY()));
    }
    void move(){
        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        if(direction == LEFT){x--;}
        if(direction == RIGHT){x++;}
        if(direction == UP){y--;}
        if(direction == DOWN){y++;}
        if(x > FILLED_WIDTH - 1){x=0;}
        if(x < 0){x = FILLED_WIDTH-1;}
        if(y > FILLED_WIDTH - 1){y=0;}
        if(y < 0){y = FILLED_HEIGHT-1;}
        gameOver = isInsideSnake(x,y);//check for cross itselves
        snake.add(0, new Point(x,y));
    }

    void setDirection(int direction){
        if ((direction>=LEFT) && (direction<=DOWN)){
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    void paint (Graphics g){
        for(Point point : snake) {
            point.paint(g);
        }
    }
}