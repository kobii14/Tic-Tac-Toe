/**
 * a class that represents the smartest player
 */
public class SnartypamtsPlayer implements Player
{
    /**
     * a function that plays a turn
     * @param board a board to play on
     * @param playerMark X or O
     */
    public void playTurn(Board board, Mark playerMark)
    {
        for (int row = 1; row < Board.SIZE - 1; row++)
        {
            for (int col = 0; col < Board.SIZE - 1; col++)
            {
                if (board.getMark(col, row) == Mark.BLANK)
                {
                    board.putMark(playerMark, col, row);
                    return;
                }
            }
        }
    }
}
