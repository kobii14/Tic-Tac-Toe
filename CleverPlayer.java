/**
 * a class that represents a clever player and implements the Player interface
 */
public class CleverPlayer implements Player
{
    /**
     * plays a turn as a clever player by filling in the rows
     * @param board a board to play on
     * @param playerMark X or O for the specific player
     */
    public void playTurn(Board board, Mark playerMark)
    {
        for (int row = 0; row < Board.SIZE; row++)
        {
            for (int col = 0; col < Board.SIZE; col++)
            {
                if (board.getMark(row, col) == Mark.BLANK)
                {
                    board.putMark(playerMark, row, col);
                    return;
                }
            }
        }
    }
}
