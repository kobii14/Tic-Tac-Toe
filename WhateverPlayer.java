import java.util.Random;
/**
 * a class that represents a Whatever player that play by random choices
 */
public class WhateverPlayer implements Player
{
    private Random random = new Random();

    /**
     * a function that plays a turn
     * @param board a board to play on
     * @param playerMark X or O
     */
    public void playTurn(Board board, Mark playerMark)
    {
        boolean flag = false;
        while (!flag)
        {
            int randInt1 = random.nextInt(Board.SIZE);
            int randInt2 = random.nextInt(Board.SIZE);
            flag = board.putMark(playerMark, randInt1, randInt2);
        }
    }
}
