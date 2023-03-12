/**
 * a class that runs a tournament
 */
public class Tournament {
    private int _rounds;
    private Renderer _renderer;
    private Player _player1;
    private Player _player2;
    private static final String FINAL_RESULTS = "=== player 1: %d | player 2: %d | Draws: %d ===\r";

    /**
     * a constructor for the tournament
     * @param rounds number of rounds
     * @param renderer type of renderer
     * @param players array of 2 players to play with each other
     */
    public Tournament(int rounds, Renderer renderer, Player [] players)
    {
        this._rounds = rounds;
        this._renderer = renderer;
        this._player1 = players[0];
        this._player2 = players[1];
    }

    /**
     * a function that runs a tournament
     */
    public void playTournament()
    {
        // player1 --> results[0]
        // player2 --> results[1]
        // draw --> results[2]
        int [] results = {0, 0, 0};
        for (int i = 0; i < _rounds; i++)
        {
            Game game;
            // player1 is X, player2 is O
            if (i % 2 == 0)
            {
                game = new Game(_player1, _player2, _renderer);
            }
            // player1 is O, player2 is X
            else
            {
                game = new Game(_player2, _player1, _renderer);
            }
            Mark win = game.run();
            //Draw
            if (win == Mark.BLANK)
            {
                results[2] ++;
            }
            else if (win == Mark.X)
            {
                if (i % 2 == 0)
                {
                    results[0] ++;
                }
                else
                {
                    results[1] ++;
                }
            }
            else if (win == Mark.O)
            {
                if (i % 2 == 1)
                {
                    results[0] ++;
                }
                else
                {
                    results[1] ++;
                }
            }
        }
        System.out.format(FINAL_RESULTS, results[0], results[1], results[2]);
    }

    public static void main(String[] args)
    {
        if (args.length != 4)
        {
            System.err.println("[/Usage: java Tournament [round count] [render target: console/none]\n" +
                    " [/player1: human/clever/whatever/snartypamts] " +
                    "[player2: human/clever/whatever/snartypamts]");
        }
        PlayerFactory playerF = new PlayerFactory();
        Player player1 = playerF.buildPlayer(args[2]);
        Player player2 = playerF.buildPlayer(args[3]);
        Player [] players_arr = {player1, player2};
        RendererFactory rendererF = new RendererFactory();
        Renderer renderer = rendererF.buildRenderer(args[1]);
        int rounds = Integer.parseInt(args[0]);
        Tournament tournament = new Tournament(rounds, renderer, players_arr);
        tournament.playTournament();
    }
}
