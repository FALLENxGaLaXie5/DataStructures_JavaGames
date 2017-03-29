import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Joshua Steward on 1/10/2015.
 */
public class Ship {
    //private ArrayList<BoardPoint> ship;
    private int initialPointRow;
    private int initialPointCollumn;


    public Ship(int boardSize) {

        Random random = new Random();
        //this.ship = new ArrayList<BoardPoint>(shipSize);

        this.initialPointRow = random.nextInt(boardSize);
        this.initialPointCollumn = random.nextInt(boardSize);
        //while (randomRow < shipSize || randomRow > (boardSize - shipSize))
        //{
        //    randomRow = random.nextInt(boardSize);
        //}
        //while (randomCollumn < shipSize || randomCollumn > (boardSize - shipSize))
        //{
        //    randomCollumn = random.nextInt(boardSize);
        //}
        //this.initialPoint = new BoardPoint(randomRow, randomCollumn);
        //this.initialPoint.setHasShip(true);

        //int roll = random.nextInt(4);

        //Generating the direction in which the ship will extend.
        //Extending ship in random direction.
        //switch (roll)
        //{
        //    case 0:
        //        this.ship.add(this.initialPoint);
        //        int addOn = 1;
        //        while (addOn < shipSize)
        //        {
        //            BoardPoint newBoardyPoint = new BoardPoint(this.initialPoint.getRow() + addOn, this.initialPoint.getColumn());
        //            this.ship.add(newBoardyPoint);
        //            //this.ship.get(i).setHasShip(true);
        //            addOn++;
        //        }
        //        break;
        //    case 1:
        //        this.ship.add(this.initialPoint);
        //        int addOn1 = 1;
        //        while (addOn1 < shipSize)
        //        {
        //            BoardPoint newBoardPoint1 = new BoardPoint(this.initialPoint.getRow(), this.initialPoint.getColumn() + addOn1);
        //            this.ship.add(newBoardPoint1);
        //            //this.ship.get(i).setHasShip(true);
        //            addOn1++;
        //        }
        //        break;
        //    case 2:
        //        this.ship.add(this.initialPoint);
        //        int addOn2 = 1;
        //        while (addOn2 < shipSize)
        //        {
        //            BoardPoint newBoardPoint2 = new BoardPoint(this.initialPoint.getRow() - addOn2, this.initialPoint.getColumn());
        //            this.ship.add(newBoardPoint2);
        //            //this.ship.get(i).setHasShip(true);
        //            addOn2++;
        //        }
        //        break;
        //    case 3:
        //        this.ship.add(this.initialPoint);
        //        int addOn3 = 1;
        //        while (addOn3 < shipSize)
        //        {
        //            BoardPoint newPoint = new BoardPoint (this.initialPoint.getRow(), this.initialPoint.getColumn() - addOn3);
        //            this.ship.add(newPoint);
        //this.ship.get(i).setHasShip(true);
        //            addOn3 ++;
        //        }
        //        break;
        //    default:
        //        this.ship.add(this.initialPoint);
        //        int addOn4 = 1;
        //        while (addOn4 < shipSize)
        //        {
        //            BoardPoint newBoardPoint = new BoardPoint(this.initialPoint.getRow(), this.initialPoint.getColumn() - addOn4);
        //            this.ship.add(newBoardPoint);
        //            //this.ship.get(i).setHasShip(true);
        //            addOn4 ++;
        //        }
        //      break;
        // }

        //for (BoardPoint currentPoint : this.ship)
        //{
        //    currentPoint.setHasShip(true);
        //}
        //}

        //public  ArrayList<BoardPoint> getShip()
        //{
        //    return this.ship;
        //}

        //public void setShip(ArrayList<BoardPoint> newShip)
        //{
        //    this.ship = newShip;
        //}

        //public BoardPoint getInitialPoint()
        //{
        //    return this.initialPoint;
        //}

        //public void setInitialPoint(BoardPoint newInitialPoint)
        //{
        //    this.initialPoint = newInitialPoint;
        //}
    }

    public int getInitialPointRow()
    {
        return this.initialPointRow;
    }

    public void setInitialPointRow(int newInitialPointRow)
    {
        this.initialPointRow = newInitialPointRow;
    }

    public int getInitialPointCollumn ()
    {
        return this.initialPointCollumn;
    }

    public void setInitialPointCollumn(int newInitialPointCollumn)
    {
        this.initialPointCollumn = newInitialPointCollumn;
    }
}