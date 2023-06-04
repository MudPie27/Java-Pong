import java.awt.*;

public class Score {

    // variables
    private int score1, score2;
    private String winMessage;
    public static boolean gameOver;

    // font objects
    private Font scoreFont;
    private Font winFont;

    // constructor
    public Score() {
        // font details
        scoreFont = new Font("Arial", Font.PLAIN, 30);
        winFont = new Font("Arial", Font.BOLD, 50);

        // set variables
        score1 = 0;
        score2 = 0;
        gameOver = false;
    }

    // method that returns the scores
    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    // methods that counts the scores and checks if the game is over
    public void updateScore1() {
        score1++;
        gameOver();
    }

    public void updateScore2() {
        score2++;
        gameOver();
    }

    // if either player hits 5 points, they win
    private void gameOver() {

        if (score1 == 5) {
            gameOver = true;
            winMessage = "Player 1 Won!";
        } else if (score2 == 5) {
            gameOver = true;
            winMessage = "Player 2 Won!";
        }
    }

    // display the scores
    public void draw(Graphics g) {
        g.setFont(scoreFont);
        g.drawString("" + score1, 75, 50);
        g.drawString("" + score2, GamePanel.GAME_WIDTH - 100, 50);

        // if a player won, display winning message
        if (gameOver) {
            g.setFont(winFont);
            g.drawString(winMessage, ((GamePanel.GAME_WIDTH - 330) / 2), (GamePanel.GAME_HEIGHT / 3));
        }
    }
}
