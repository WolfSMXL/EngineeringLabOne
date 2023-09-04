package ru.engineering.one;

import javax.swing.*;
import java.awt.*;

public class SnakeGame {


    final String TITLE_OF_PROGRAM = "Змейка";
    static final int POINT_RADIUS = 20;
    static final int FILLED_WIDTH = 30;
    static final int FILLED_HEIGHT = 20;
    final int FILLED_DX = 6;
    static final int FILLED_DY = 28;
    static JFrame frame;
    static Canvas canvasPanel;
    static boolean gameOver = false;
    final int START_LOCATION = 200;
    final int START_SNAKE_SIZE = 6;
    final int SHOW_DEALAY = 150;


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
        frame.setVisible(true);


        while(!gameOver) {
            canvasPanel.repaint();
            try {
                Thread.sleep(SHOW_DEALAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
