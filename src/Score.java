package src;

import java.awt.*;

public class Score {

    private int score1, score2;
    private String winnerText;

    private Font scoreFont;
    private Font gameOverFont;

    private boolean gameOver;

    public Score() {

        scoreFont = new Font("Arial", Font.PLAIN, 30);
        gameOver = false;
        gameOverFont = new Font("Arial", Font.BOLD, 50);

        score1 = 0;
        score2 = 0;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void updateScore1() {
        score1++;
        gameOver();
    }

    public void updateScore2() {
        score2++;
        gameOver();
    }

    private void gameOver() {
        if (score1 == 1) {
            gameOver = true;
            winnerText = "Player 1 Won!";
        } else if (score2 == 1) {
            gameOver = true;
            winnerText = "Player 2 Won!";
        }
    }

    public void draw(Graphics g) {
        g.setFont(scoreFont);
        g.setColor(Color.WHITE);
        g.drawString("" + score1, 75, 50);
        g.drawString("" + score2, GamePanel.GAME_WIDTH - 100, 50);

        if (gameOver) {
            g.setFont(gameOverFont);
            FontMetrics fontMetrics = g.getFontMetrics();
            int textWidth = fontMetrics.stringWidth(winnerText);
            int x = ((GamePanel.GAME_WIDTH - textWidth) / 2);
            int y = (GamePanel.GAME_HEIGHT / 3);
            g.drawString(winnerText, x, y);
        }
    }
}
