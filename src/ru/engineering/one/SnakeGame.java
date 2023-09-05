package ru.engineering.one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakeGame {

    //game constants
    final String TITLE_OF_PROGRAM = "Classic Game Snake";
    static final int POINT_RADIUS = 20; // in pix
    static final int FILLED_WIDTH = 30; //in point
    static final int FILLED_HEIGHT = 20; // in point
    final int FILLED_DX = 6;
    static final int FILLED_DY = 28;
    static final int LEFT = 37;
    static final int UP = 38;
    static final int RIGHT = 39;
    static final int DOWN = 40;
    static Snake snake;
    static JFrame frame;
    static Canvas canvasPanel;
    static Random random = new Random();
    static boolean gameOver = false;
    final int START_LOCATION = 200;
    final int START_SNAKE_SIZE = 6;
    final int START_SNAKE_X = 10;
    final int START_SNAKE_Y = 10;
    final int SHOW_DEALAY = 150;
    final int START_DIRECTION = RIGHT;


    public static void main(String[] args) {
        new SnakeGame().go();
    }
    void go(){
        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FILLED_WIDTH * POINT_RADIUS + FILLED_DX, FILLED_HEIGHT * POINT_RADIUS + FILLED_DY);
        frame.setLocation(START_LOCATION,START_LOCATION);
        frame.setResizable(false);

        canvasPanel = new Canvas();
        canvasPanel.setBackground(Color.white);

        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });
        frame.setVisible(true);

        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);

        while(!gameOver) {
            snake.move();
            canvasPanel.repaint();
            try {
                Thread.sleep(SHOW_DEALAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
