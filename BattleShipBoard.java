/*
 *  CSC-122 SP 2017 PROJECT: BattleShip
 *  Programmer: Christopher Brefo
 *  Due Date: 04/26/2017
 *  Description: Board for the BattleShip Game
 */
package battleship;

/**
 *
 * @author chris
 */
public class BattleShipBoard
{
    private final int MAX_ROW = 10;
    private final int MAX_COL = 10;
    private String[][] Board;
     
    
  public BattleShipBoard()
    { 
      
       Board = new String[MAX_ROW][MAX_COL];
       for( int r = 0; r < MAX_ROW; r++)
       {
           for(int c = 0; c < MAX_COL; c++)
           {
               Board[r][c] = "^";
           }
       }
    }
   public String toString()
   {
       String output = "";
       output += ("  1    2    3    4    5    6    7    8    9   10\n");
        for (int r = 0; r < Board.length; r++)
        {
            output += (r+1+" ");
            for (int c = 0; c < Board.length; c++)
            {
                output += ( Board[r][c]+"    ");
            }
            output += "\n\n";
        }
        return output;
   }
   
  /** SETSQURE()
  * preconditions: none
  * postconditions: Assigns a specific spot it's value
  */
   
    public void setSquare (int inR, int inC, String value)
    {
        Board [inR][inC] = value;
    }
    
    /** GETSQURE()
  * preconditions: setSquare()
  * postconditions: Allows us to get the value of that
  * specific spot
  */
    
    public String getSquare (int r, int c)
    {
        return Board[r][c];
    }
    
  /** ADDSHIP()
  * preconditions: SHIP Class is made right, 
  * enum for direction, and row and column ints in 
  * the game class
  * postconditions: Constructs/Intializes the variables
  */
    
    public boolean addShip(Ship type, 
            Orientation position, int r, int c)
{
      boolean success = true;
      int size = type.getSize();
      
      if(position == Orientation.Vertical){
         if (r + size >= MAX_ROW)  // ship won’t fit here
             success = false;
         else                   // ship has room for placement
         {
            for ( int i = 0; i < size; i++) //check each square
            {
               if (getSquare(r+1, c) != "^") // if not empty
               {
                  success = false;          // can’t put ship here
               }
            }
            if (success)  { // ship can be placed, put on board
               for (int i = 0; i < size; i++)
               {
                  setSquare((r+i),c, type.getSymbol());
               }
            }
         }
      }
      else // direction is horizontal  {
         if (c + size >= MAX_COL) //won’t fit on board
             success = false;
         else  // should fit on board
         {
            for ( int i = 0; i < size; i++) // check each square
            {
               if (getSquare( r,(i + c)) != "^") // if not open
               {
                  success = false;      // there is an obstruction
               }
            }
            if (success) {   // no obstructions, put on board
               for (int i = 0; i < size; i++)
               {
                  setSquare(r,(c+i), type.getSymbol());
               }
            }
         }
      return success;
    }   
 }

