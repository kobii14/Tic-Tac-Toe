import java.util.Scanner;
/**
 * a class that represents a human player that chooses manually his next move
 */
public class HumanPlayer implements Player
{
    /**
     * a turn of a player
     * @param board a board to play with
     * @param playerMark the mark of the specific player - X or O
     */
    private static final String INVALID_MESSAGE = "Invalid coordinates, type again: ";
    public void playTurn(Board board, Mark playerMark)
    {
        boolean flag = false;
        System.out.print("Player " + playerMark + ", type coordinates: ");
        while (!flag)
        {
            Scanner scanner = new Scanner(System.in);
            int coordinates = scanner.nextInt();
            int col = coordinates % 10 - 1;
            int row = (coordinates - col) / 10 - 1;
            flag = board.putMark(playerMark, row, col);
            if (!flag)
            {
                System.out.print(INVALID_MESSAGE);
            }
        }
    }

}



