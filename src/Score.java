package src;

import java.awt.*;

public class Score {

    private int score1;
    private int score2;
    private Font scoreFont;

    public Score() {
        score1 = 0;
        score2 = 0;
        scoreFont = new Font("Arial", Font.PLAIN, 30);
    }

    public void updateScore1() {
        score1++;
    }

    public void updateScore2() {
        score2++;
    }

    public void draw(Graphics g) {
        g.setFont(scoreFont);
        g.setColor(Color.WHITE);
        g.drawString("" + score1, 75, 50);
        g.drawString("" + score2, GamePanel.GAME_WIDTH - 100, 50);
    }
}
