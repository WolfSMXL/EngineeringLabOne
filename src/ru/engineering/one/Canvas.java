package ru.engineering.one;

import javax.swing.*;
import java.awt.*;

import static ru.engineering.one.SnakeGame.*;

public class Canvas extends JPanel {
    final String GAME_OVER_MSG = "ИГРА ОКОНЧЕНА!";
    final int FILLED_DX = 6;
    @Override
    public void paint (Graphics q) {
        super.paint(q);
        snake.paint(q);
        food.paint(q);
        if (gameOver) {
            q.setColor(Color.red);
            q.setFont(new Font("Arial", Font.BOLD, 38));
            FontMetrics fm = q.getFontMetrics();
            q.drawString(GAME_OVER_MSG, (FILLED_WIDTH * POINT_RADIUS + FILLED_DX - fm.stringWidth(GAME_OVER_MSG))/2, (FILLED_HEIGHT * POINT_RADIUS + FILLED_DY)/2);
        }
    }

}
