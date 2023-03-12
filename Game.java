public class Game
{
    Renderer renderer;
    Player playerX;
    Player playerO;
    /**
     * a constructor of a whole game
     * @param playerX player with mark X from Player type
     * @param playerO player with mark O from Player type
     * @param renderer a class that prints the board
     */
    public Game(Player playerX, Player playerO, Renderer renderer)
    {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
    }

    /**
     * a function that runs a whole game that will be ended if there is a winner or with a draw
     * @return the winner's mark if there is one, BLANK otherwise
     */
    public Mark run()
    {
        int turnCounter = 0;
        Board board = new Board();
        while (!board.gameEnded())
        {
            renderer.renderBoard(board);
            if (turnCounter % 2 == 0)
            {
                playerX.playTurn(board, Mark.X);
            }
            else
            {
                playerO.playTurn(board, Mark.O);
            }
            turnCounter ++;
        }
        renderer.renderBoard(board);
        return board.getWinner();
    }
}
