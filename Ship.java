/*
 *  CSC-122 SP 2017 PROJECT: BattleShip
 *  Programmer: Christopher Brefo
 *  Due Date: 4/26/2017
 *  Description: Setters and Getters for the different ships
 */
package battleship;

/**
 *
 * @author chris
 */
public class Ship 
{
    private int Size;
    private int hitcount;
    private int startlocationR;
    private int startlocationC;
    private shipKind Type;
    private shipReport Status;
    private Orientation Direction;
    private String Symbol;
    
    public Ship()
    {
        Size = 0;
        hitcount = 0;
        startlocationR = 0;
        startlocationC = 0;
        Type = shipKind.Destroyer;
        Status = shipReport.none;
        Direction = Orientation.Vertical;
        Symbol = " ";  
    }
    
 public void setSize(int Width)
 {
     Size = Width;
 }
 public void setHit(int Damage)
 {
     hitcount = Damage;
 }
 public void setShipType(shipKind Brand)
 {
     Type = Brand;
 }
 public void setShipReport(shipReport State) 
 {
     Status = State;
 }
 public void setSymbol(String Symb)
 {
     Symbol = Symb;
 }
 public void setStartLocationRow(int spotr)
 {
     startlocationR = spotr;
 }
 public void setStartLocationCol(int spotc)
 {
     startlocationC = spotc;
 }
 public void setOrientation(Orientation Way)
 {
     Direction = Way;
 }
 public int getSize()
 {
     return Size;
 }
 public int getHit()
 {
     return hitcount;
 }
 public shipKind getShipType()
 {
     return Type;
 }
 public shipReport getShipReport()
 {
     return Status;
 }
 public String getSymbol()
 {
     return Symbol;
 }
 public Orientation getOrientation()
 {
     return Direction;
 }
 public int getStartLocationRow()
 {
     return startlocationR;
 }
 public int getStartLocationCol()
 {
     return startlocationC;
 }
}
