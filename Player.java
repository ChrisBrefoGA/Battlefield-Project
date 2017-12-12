/*
 *  CSC-122 SP 2017 PROJECT: BattleShip
 *  Programmer: Christopher Brefo
 *  Due Date: 4/26/2017
 *  Description: Setter's and Getter's for the player file
 */
package battleship;

/**
 *
 * @author chris
 */
public class Player 
{
    String name;
    
    
    public Player()
    {
        name = " ";
    }
public Player(String Player)
{
    name = Player;
}

public void setName(String Player)
{
    name = Player;
}

public String getName()
{
    return name;
}
}
