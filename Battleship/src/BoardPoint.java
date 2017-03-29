/**
 * Created by Joshua Steward on 1/10/2015.
 */
public class BoardPoint
{
    private int row;
    private int column;
    private char point;
    private boolean hasBeenHit;
    private boolean hasShip;

    public BoardPoint(int newRow, int newColumn)
    {
        setRow(newRow);
        setColumn(newColumn);
        setPoint('o');
        setHasBeenHit(false);
        setHasShip(false);
    }

    public int getRow()
    {
        return this.row;
    }

    public int getColumn()
    {
        return this.column;
    }

    public char getPoint()
    {
        return this.point;
    }

    public void setRow( int newRow)
    {
        this.row = newRow;
    }

    public void setColumn( int newColumn)
    {
        this.column = newColumn;
    }

    public void setPoint ( char newPoint)
    {
        this.point = newPoint;
    }

    public boolean getHasBeenHit()
    {
        return this.hasBeenHit;
    }

    public boolean getHasShip()
    {
        return this.hasShip;
    }

    public void setHasBeenHit(boolean newHasBeenHit)
    {
        this.hasBeenHit = newHasBeenHit;
    }

    public void setHasShip(boolean newHasShip)
    {
        this.hasShip = newHasShip;
    }

    public String toString()
    {
        return point + " ";
    }
}
