public class Board {
    public static final int SIZE = 6;
    public static final int WIN_STREAK = 4;
    Mark[][] board;
    private int counter;
    private Mark winner;

    /**
     * a board constructor that initializes the values and returns nothing
     */
    public Board()
    {
        this.winner = Mark.BLANK;
        this.counter = 0;
        this.board = new Mark[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * gets coordination and a mark and checks the validity of the turn
     * @param playerMark X O - the mark of the player
     * @param row - the row's index
     * @param col - column index
     * @return true if the mark was valid, false otherwise
     */
    public boolean putMark(Mark playerMark, int row, int col)
    {
        if (row > SIZE - 1 || row < 0 || col > SIZE - 1 || col < 0
                || this.board[row][col] != Mark.BLANK)
        {
            return false;
        }
        this.board[row][col] = playerMark;
        this.counter ++;
        this.winner = winCalculator(row, col, playerMark);
        return true;
    }

    /**
     * calculates if there is a winner by looking for streaks in the board
     * @param lastRow row coordinate
     * @param lastCol column coordinate
     * @param lastMark mark to look for
     * @return return the winner if there is one - X or O, otherwise returns BLANK
     */
    private Mark winCalculator(int lastRow, int lastCol, Mark lastMark)
    {
        int [] count_arr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int num1 = -1;
        for (int i = -1; i < 2; i++)
        {
            for (int j = -1; j < 2; j++)
            {
                num1 ++;
                if (i == 0 && j == 0)
                {
                    continue;
                }
                count_arr[num1] = countMarkInDirection(lastRow, lastCol, i, j, lastMark);
            }
        }
        if ((count_arr[0] + count_arr[8] - 1 >= WIN_STREAK) ||
                (count_arr[1] + count_arr[7] - 1 >= WIN_STREAK) ||
                (count_arr[2] + count_arr[6] - 1 >= WIN_STREAK) ||
                (count_arr[3] + count_arr[5] - 1 >= WIN_STREAK))
        {
            return lastMark;
        }
        return Mark.BLANK;
    }

    /**
     * checks validity and returns the mark in the specific coordinates
     * @param row row coordinate
     * @param col column coordinate
     * @return the mark in the coordinates if valid, BLANK otherwise
     */
    public Mark getMark(int row, int col)
    {
        if (row > SIZE - 1 || row < 0 || col > SIZE - 1 || col < 0)
        {
            return Mark.BLANK;
        }
        return this.board[row][col];
    }

    /**
     * checks if the game ended by the number of marks and if there is a winner
     * @return true if ended, false otherwise
     */
    public boolean gameEnded()
    {
        if (this.winner != Mark.BLANK)
        {
            return true;
        }
        return this.counter == SIZE * SIZE;
    }

    /**
     * checks if there is a streak of the same mark
     * @param row row coordinate
     * @param col column coordinate
     * @param rowDelta direction
     * @param colDelta direction
     * @param mark the player's mark to be checked
     * @return the winning mark if there is one, BLANK otherwise
     */
    private int countMarkInDirection(int row, int col, int rowDelta, int colDelta, Mark mark)
    {
        int count = 0;
        while(row < SIZE && row >= 0 && col < SIZE && col >= 0 && board[row][col] == mark)
        {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    }

    /**
     * gets the winner's mark if there is one, BLANK otherwise
     * @return the winner
     */
    public Mark getWinner()
    {
        return this.winner;
    }
}
