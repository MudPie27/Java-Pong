package src;

import java.awt.*;

public class Score {

    private int score1;
    private int score2;
    private Font scoreFont;
    private boolean gameOver;
    private String winnerText;
    private Font gameOverFont;

    public Score() {
        score1 = 0;
        score2 = 0;
        scoreFont = new Font("Arial", Font.PLAIN, 30);
        gameOver = false;
        winnerText = "";
        gameOverFont = new Font("Arial", Font.BOLD, 50);
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void updateScore1() {
        score1++;
        checkGameOver();
    }

    public void updateScore2() {
        score2++;
        checkGameOver();
    }

    private void checkGameOver() {
        if (score1 == 3) {
            gameOver = true;
            winnerText = "Player 1 Won!";
        } else if (score2 == 3) {
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
