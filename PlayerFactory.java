/**
 * a factory of different kinds of players
 */
public class PlayerFactory {
    /**
     * a function that builds a player by a giver string
     * @param str the name that represents a different kind of player
     * @return a player type if exists, null otherwise
     */
    Player buildPlayer(String str)
    {
        switch (str)
        {
            case "human":
                return new HumanPlayer();
            case "whatever":
                return new WhateverPlayer();
            case "clever":
                return new CleverPlayer();
            case "snartypamts":
                return new SnartypamtsPlayer();
            default:
                return null;
        }
    }
}
