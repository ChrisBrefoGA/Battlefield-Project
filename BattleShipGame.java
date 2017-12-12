/*
 *  CSC-122 SP 2017 PROJECT: BattleShip
 *  Programmer: Christopher Brefo
 *  Due Date: 4/26/2017
 *  Description: Main Settings for the working of the game
 */
package battleship;
import java.util.Scanner;
import java.util.Random;
import java.awt.*;


/**
 *
 * @author chris
 */


public class BattleShipGame 
{
    private BattleShipBoard shipBoard;
    private BattleShipBoard playerBoard;
    private Orientation position;
    private shipReport condition;
    private shipKind category;
    private Ship[] boats;
    private int turn; 
    private int r;
    private int damageU;
    private int damageA;
    private int damageF;
    private int damageC;
    private int damageD;
    private int c;
    private final int ROWS= 10;
    private final int COL= 10;
    private Player P1;
    private int sink;
    private final int MAX_SINKS =5;
    
    public BattleShipGame()
    {
        sink = 0;
        damageU = 0;
        damageA = 0;
        damageF = 0;
        damageC = 0;
        damageD = 0;
        P1 = new Player();
        r = 0;
        c = 0;
        turn = 65;
        boats = new Ship[5];
        category = shipKind.Destroyer;
        condition = shipReport.none;
        position = Orientation.Horizontal;
        playerBoard = new BattleShipBoard();
        shipBoard = new BattleShipBoard();
    }
    
/** PLAYBATTLESHIP()
  * preconditions: All Classes and Variables
  * must be appropriately set up
  * 
  * postconditions: Runs all private 
  * classes of the game
  **/
    
   public void playBattleShip()
   {
      playerSetup();
      shipSetup();
      hideShips();
     //System.out.println(shipBoard);
      takeTurn();
      checkWin();
   }
   
/** PLAYERSETUP()
  * preconditions: none
  * 
  * postconditions: Creates and Holds the
  * players name for the game
  **/
   
   private void playerSetup()
   {
       String Playa = " ";
       Scanner cin = new Scanner(System.in);
       System.out.println("Please tell me your name: ");
       Playa = cin.nextLine();
       P1.setName(Playa);
   }
 
/** SHIPSETUP()
  * preconditions: Array of ships
  * should be properly working
  * 
  * postconditions: Applies each 
  * ship it's various settings
  **/
   
   public void shipSetup()
   {
       for (int i = 0; i < boats.length; i++)
       {
           boats[i] = new Ship();
           switch (i)
           {
               case 0:
                   boats[0].setShipType(shipKind.Destroyer);
                   boats[0].setSize(2);
                   boats[0].setShipReport(shipReport.none);
                   boats[0].setSymbol("D");
                   boats[0].setHit(damageD);
                   break;
               case 1:
                   boats[1].setShipType(shipKind.Submarine);
                   boats[1].setSize(3);
                   boats[1].setShipReport(shipReport.none);
                   boats[1].setSymbol("U");
                   boats[1].setHit(damageU);
                   break;
               case 2:
                   boats[2].setShipType(shipKind.Frigate);
                   boats[2].setSize(3);
                   boats[2].setShipReport(shipReport.none);
                   boats[2].setSymbol("F");
                   boats[2].setHit(damageF);
                   break;
               case 3:
                   boats[3].setShipType(shipKind.Cruiser);
                   boats[3].setSize(4);
                   boats[3].setShipReport(shipReport.none);
                   boats[3].setSymbol("C");
                   boats[3].setHit(damageC);
                   break;
               default:
                   boats[4].setShipType(shipKind
                           .Aircraft_Carrier);
                   boats[4].setSize(5);
                   boats[4].setShipReport(shipReport.none); 
                   boats[4].setSymbol("A");
                   boats[4].setHit(damageA);
                       break;
           }
         }
       }
   
/** HIDESETUP()
  * preconditions: shipSetup() and 
  * addShip() (in the board class)
  * are appropriately working
  * 
  * postconditions: Gives all the 
  * ships it's string values on the board
  **/
   
   private void hideShips()
   {
       int way =0;
       Random rand = new Random();
       for(int i =0; i< boats.length;i++)
       {
           do
           {
               r = rand.nextInt(ROWS);
               c = rand.nextInt(COL);
              way = rand.nextInt(2);
               if ( way == 0)
               {
                   position = Orientation.Vertical;
               }
               else
               {
                   position = Orientation.Horizontal;
               }
           }while(shipBoard.addShip(boats[i],
                   position, r, c)== false);
        boats[i].setOrientation(position);
        boats[i].setStartLocationRow(r);
        boats[i].setStartLocationCol(c);
       }
   }   
   
/** TAKETURN()
  * preconditions: All methods except playBattleShip()
  * are working appropriately. 
  * postconditions: Allows the player to pick a spot on
  * the board that spot is then checked and verified by 
  * if statements. Depending on the value of that 
  * specific spot, the board will change appropriately.
  **/
   
   private void takeTurn()
    {
        int Pr = 0;
        int Pc = 0;
        Scanner Prow = new Scanner(System.in);
        Scanner Pcol = new Scanner(System.in);
      do
       {  
        System.out.println(playerBoard);
        System.out.println("You have "+ 
              turn +" turns left.");
        System.out.println("Please pick a column (top #'s): ");
             Pc = Pcol.nextInt()-1;  
        System.out.println("Please pick a row(side #'s): ");
             Pr = Prow.nextInt()-1;   
             
     if (Pc < 10 && Pc >=0 && Pr < 10 && Pr >= 0)
     {
        if(shipBoard.getSquare(Pr, Pc) == "D"
           && playerBoard.getSquare(Pr, Pc)!= "H")
           {
            playerBoard.setSquare(Pr, Pc, "H");
            
            Toolkit.getDefaultToolkit().beep();
            
            boats[0].setHit(boats[0].getHit()+1);
            
            sinkCheck(boats[0]);
            
            boardUpdate(boats[0]);
           } 
        else if(shipBoard.getSquare(Pr, Pc) == "U"
                && playerBoard.getSquare(Pr, Pc)!= "H")
           {
             playerBoard.setSquare(Pr, Pc, "H");
             
            Toolkit.getDefaultToolkit().beep();
            
            boats[1].setHit(boats[1].getHit()+1);
            
            sinkCheck(boats[1]);
            
            boardUpdate(boats[1]);
           }
         else if(shipBoard.getSquare(Pr, Pc) == "F"
                 && playerBoard.getSquare(Pr, Pc)!= "H")
           {
             playerBoard.setSquare(Pr, Pc, "H");
             
            Toolkit.getDefaultToolkit().beep();
            
            boats[2].setHit(boats[2].getHit()+1);
            
            sinkCheck(boats[2]);
            
            boardUpdate(boats[2]);
           }      
         else if(shipBoard.getSquare(Pr, Pc) == "C"
                 && playerBoard.getSquare(Pr, Pc)!= "H")
           {
             playerBoard.setSquare(Pr, Pc, "H");
             
            Toolkit.getDefaultToolkit().beep();
            
            boats[3].setHit(boats[3].getHit()+1);
            
            sinkCheck(boats[3]);
            
            boardUpdate(boats[3]);
           }
         else if(shipBoard.getSquare(Pr, Pc) == "A"
                 && playerBoard.getSquare(Pr, Pc)!= "H")
           {
            playerBoard.setSquare(Pr, Pc, "H");
            Toolkit.getDefaultToolkit().beep();
            boats[4].setHit(boats[4].getHit()+1);
            sinkCheck(boats[4]);
            boardUpdate(boats[4]);
           }
         else if(playerBoard.getSquare(Pr, Pc) == "H" 
                 || playerBoard.getSquare(Pr, Pc)=="G")
           {
               System.out.println("You already"
                       + " picked that spot"
                       + " and you "
                       + "have wasted a turn.");
               
           }
        else
            playerBoard.setSquare(Pr, Pc, "G");
           
        turn--;
     }
   
        }while(turn != 0&& sink != MAX_SINKS);
    }
  
/**  SINKCHECK()
  * preconditions: takeTurn(), shipSetup()
  * postconditions: Simply checks the status of whatever
  * has been selected
  **/
   
   private void sinkCheck(Ship type)
   {
       if (type.getHit() == type.getSize())
       {
         System.out.println("You have Sunk the "+
         type.getShipType()+".");
         type.setSymbol("S");
         type.setShipReport(shipReport.Sunk); 
         sink++;
       }
    }
   
/** BOARDUPDATE()
  * preconditions: Array of ships is right and 
  * takeTurn() is working right
  * postconditions: Checks whether or not the
  * a ship is sunk
  * if it is it updates the board to S's 
  * if not it does nothing
  **/
   
private void boardUpdate(Ship type)
{
    if(type.getShipReport() == shipReport.Sunk)
    {
     if (type.getOrientation() == Orientation.Horizontal)
       {    
           for(int i = 0; i < type.getSize();i++)
           {
           playerBoard.setSquare((type.getStartLocationRow()),
                    type.getStartLocationCol()+i
                   , type.getSymbol());
           }      
       }
     else if(type.getOrientation() == Orientation.Vertical)
       {
           for(int i = 0; i< type.getSize();i++)
           {
                playerBoard.setSquare(
                   (type.getStartLocationRow()+i),
                   (type.getStartLocationCol())
                   , type.getSymbol());
           }
       }
    }
}

/** 
  * CHECKWIN()
  * preconditions: takeTurn()
  * postconditions: Verifies how the game ended 
  **/

private void checkWin()
{
    if(sink == MAX_SINKS)
    {
        System.out.println("\f CONGRATZ "+P1.getName()
                + "!! YOU"
                + "HAVE SUNK ALL THE SHIPS!!\f");
        System.out.println(playerBoard);
    }
    else
    {
        System.out.println("SORRY "+P1.getName()+" YOU DID"
                + "NOT WIN THE GAME. HERE ARE THE "
                + "SHIPS YOU MISSED"); 
        System.out.println(shipBoard);
    }
}

}

