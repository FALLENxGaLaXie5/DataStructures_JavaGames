import java.util.Random;

/**
 * Created by Joshua Steward on 1/10/2015.
 */
public class Board
{
    private BoardPoint [][] gameBoard;
    private int boardSize;
    private Ship ship1;
    private Ship ship2;
    private Ship ship3;
    private Ship ship4;
    private Ship ship5;
    private Ship ship6;
    private Ship ship7;
    private Ship ship8;
    private Ship ship9;
    private Ship ship10;




    public Board( int newSize)
    {
        this.boardSize = newSize;
        this.gameBoard = new BoardPoint[this.boardSize][this.boardSize];
        for (int r = 0; r < this.gameBoard.length; r++)
        {
            for (int c = 0; c < this.gameBoard[r].length; c++)
            {
                this.gameBoard[r][c] = new BoardPoint(r, c);
            }
        }

        shipCreator(this.ship1, 5, this.boardSize);
        shipCreator(this.ship2, 4, this.boardSize);
        shipCreator(this.ship3, 3, this.boardSize);
        shipCreator(this.ship4, 2, this.boardSize);
        shipCreator(this.ship5, 1, this.boardSize);
        //shipCreator(this.ship6, 6, this.boardSize);
        //shipCreator(this.ship7, 7, this.boardSize);
        //shipCreator(this.ship8, 8, this.boardSize);
        //shipCreator(this.ship9, 9, this.boardSize);
        //shipCreator(this.ship10, 10, this.boardSize);
    }
    public void shipCreator(Ship newShip, int shipSize,int boardSize)
    {
        Random random = new Random();
        newShip = new Ship(boardSize);
        int initialShipPointRow = newShip.getInitialPointRow();
        int initialShipPointCollumn = newShip.getInitialPointCollumn();
        if (initialShipPointRow < (boardSize/2) && initialShipPointCollumn < boardSize/2)
        {
            shipExtenderRightOrDown(newShip, shipSize);
        }

        else if (initialShipPointRow < (boardSize/2) && initialShipPointCollumn > boardSize/2)
        {
            shipExtenderLeftOrDown(newShip, shipSize);
        }

        else if (initialShipPointRow > (boardSize/2) && initialShipPointCollumn < boardSize/2)
        {
            shipExtenderUpOrRight(newShip, shipSize);
        }
        else if (initialShipPointRow > boardSize/2 && initialShipPointCollumn > boardSize/2)
        {
            shipExtenderUpOrLeft(newShip, shipSize);
        }
        else
        {
            shipExtenderRandom(newShip, shipSize);
        }


        /**
         * I like to see the whan haaaaan, in my life as if I were a poppy budder, budding like nawbuddy ever bud b4.
         * Cause I'm a G6, a motherfucking G6 HAHAHAHAHA, a G6 mothafucka, G6 yoyoyo. So when I kill my partner in crime, I know
         * I will never be the same. Hahahahaha. So why do I even try with you, my favorite mothafucka YAYAYA. So when I want
         * to fell youuouuuuuuu. And then I see your mama in the MIRRORRRRRRR.
         */
        //boolean goodInput = false;
        //aLoopName: do {
            //boolean newGoodInput = true;
            //try
            //{

            /*newShip = new Ship(shipSize, boardSize);
            for (int i = 0; i < newShip.getShip().size(); i++) {
                for (int r = 0; r < this.gameBoard.length; r++) {
                    for (int c = 0; c < this.gameBoard[r].length; c++) {
                        BoardPoint currentPoint = newShip.getShip().get(i);
                        if (this.gameBoard[r][c].getHasShip())
                        {
                            continue aLoopName;
                            //newShip = new Ship(shipSize, boardSize);
                        }

                        if (currentPoint.getRow() == this.gameBoard[r][c].getRow() && currentPoint.getColumn() == this.gameBoard[r][c].getColumn()) {
                            this.gameBoard[r][c].setHasShip(true);

                        }

                    }
                }
            }
            */
            //goodInput = true;
            //for (int i = 0; i < newShip.getShip().size(); i++)
            //{
            //    for (int r = 0; r < this.gameBoard.length; r++)
            //    {
            //        for (int c = 0; c < this.gameBoard[r].length; c++)
            //        {
            //
            //        }
            //    }
            //}

            //if (newGoodInput)
            //{
            //    goodInput = true;
            //}
            //}
            //catch (IndexOutOfBoundsException ioe)
            //{
            //Ship superDuperNewShip = new Ship(shipSize, boardSize);
            //shipCreator(superDuperNewShip, shipSize, boardSize);
            //}
        //} while (!goodInput);
    }

    public void shipExtenderRandom(Ship newShip, int newShipSize)
    {
        Random random = new Random();
        int randomNum = random.nextInt(4);
        int addOn = 1;
        int initialShipPointRow = newShip.getInitialPointRow();
        int initialShipPointCollumn = newShip.getInitialPointCollumn();
        switch (randomNum)
            {
                case 0:
                    this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);
                    while (addOn < newShipSize)
                    {
                        if (this.gameBoard[initialShipPointRow + addOn][initialShipPointCollumn].getHasShip())
                        {
                            shipCreator(newShip, newShipSize, this.boardSize);
                            return;
                        }

                        addOn++;
                    }
                    while (addOn < newShipSize)
                    {
                        this.gameBoard[initialShipPointRow + addOn][initialShipPointCollumn].setHasShip(true);
                        addOn++;
                    }
                    break;
                case 1:
                    this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);
                    while (addOn < newShipSize)
                    {
                        if (this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].getHasShip())
                        {
                            shipCreator(newShip, newShipSize, this.boardSize);
                            return;
                        }

                        addOn++;
                    }
                    while (addOn < newShipSize)
                    {
                        this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].setHasShip(true);
                        addOn++;
                    }
                    break;
                case 2:
                    this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);
                    while (addOn < newShipSize)
                    {
                        if (this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].getHasShip())
                        {
                            shipCreator(newShip, newShipSize, this.boardSize);
                            return;
                        }

                        addOn++;
                    }
                    while (addOn < newShipSize)
                    {

                        this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].setHasShip(true);
                        addOn++;
                    }
                    break;
                case 3:
                    this.gameBoard[initialShipPointRow - addOn][initialShipPointCollumn].setHasShip(true);
                    while (addOn < newShipSize)
                    {
                        if (this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].getHasShip())
                        {
                            shipCreator(newShip, newShipSize, this.boardSize);
                            return;
                        }

                        addOn++;
                    }
                    while (addOn < newShipSize)
                    {
                        this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].setHasShip(true);
                        addOn++;
                    }
                    break;
                default:
                    this.gameBoard[initialShipPointRow][initialShipPointCollumn - addOn].setHasShip(true);
                    while (addOn < newShipSize)
                    {
                        if (this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].getHasShip())
                        {
                            shipCreator(newShip, newShipSize, this.boardSize);
                            return;
                        }

                        addOn++;
                    }
                    while (addOn < newShipSize)
                    {

                        this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].setHasShip(true);
                        addOn++;
                    }
                    break;
            }
    }

    public void shipExtenderRightOrDown (Ship newShip, int newShipSize)
    {
        Random random = new Random();
        int randomNum = random.nextInt(2);
        int addOn = 1;
        int initialShipPointRow = newShip.getInitialPointRow();
        int initialShipPointCollumn = newShip.getInitialPointCollumn();
        switch (randomNum)
        {
            case 0:
                this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);

                while (addOn < newShipSize)
                {
                    if (this.gameBoard[initialShipPointRow + addOn][initialShipPointCollumn].getHasShip())
                    {
                        shipCreator(newShip, newShipSize, this.boardSize);
                        return;
                    }

                    addOn++;
                }
                while (addOn < newShipSize)
                {
                    this.gameBoard[initialShipPointRow + addOn][initialShipPointCollumn].setHasShip(true);
                    addOn++;
                }
                break;
            case 1:
                this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);
                while (addOn < newShipSize)
                {
                    if (this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].getHasShip())
                    {
                        shipCreator(newShip, newShipSize, this.boardSize);
                        return;
                    }

                    addOn++;
                }
                while (addOn < newShipSize)
                {
                    this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].setHasShip(true);
                    addOn++;
                }
                break;

        }
    }

    public void shipExtenderLeftOrDown (Ship newShip, int newShipSize)
    {
        Random random = new Random();
        int randomNum = random.nextInt(2);
        int addOn = 1;
        int initialShipPointRow = newShip.getInitialPointRow();
        int initialShipPointCollumn = newShip.getInitialPointCollumn();
        switch (randomNum)
        {
            case 0:
                this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);

                while (addOn < newShipSize)
                {
                    if (this.gameBoard[initialShipPointRow + addOn][initialShipPointCollumn].getHasShip())
                    {
                        shipCreator(newShip, newShipSize, this.boardSize);
                        return;
                    }

                    addOn++;
                }
                while (addOn < newShipSize)
                {

                    this.gameBoard[initialShipPointRow + addOn][initialShipPointCollumn].setHasShip(true);
                    addOn++;
                }
                break;
            case 1:
                this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);
                while (addOn < newShipSize)
                {
                    if (this.gameBoard[initialShipPointRow][initialShipPointCollumn - addOn].getHasShip())
                    {
                        shipCreator(newShip, newShipSize, this.boardSize);
                        return;
                    }
                    addOn++;
                }
                while (addOn < newShipSize)
                {
                    this.gameBoard[initialShipPointRow][initialShipPointCollumn - addOn].setHasShip(true);
                    addOn++;
                }
                break;

        }
    }

    public void shipExtenderUpOrRight(Ship newShip, int newShipSize)
    {
        Random random = new Random();
        int randomNum = random.nextInt(2);
        int addOn = 1;
        int initialShipPointRow = newShip.getInitialPointRow();
        int initialShipPointCollumn = newShip.getInitialPointCollumn();
        switch (randomNum)
        {
            case 0:
                this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);

                while (addOn < newShipSize)
                {
                    if (this.gameBoard[initialShipPointRow - addOn][initialShipPointCollumn].getHasShip())
                    {
                        shipCreator(newShip, newShipSize, this.boardSize);
                        return;
                    }

                    addOn++;
                }
                while (addOn < newShipSize)
                {

                    this.gameBoard[initialShipPointRow - addOn][initialShipPointCollumn].setHasShip(true);
                    addOn++;
                }
                break;
            case 1:
                this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);
                while (addOn < newShipSize)
                {
                    if (this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].getHasShip())
                    {
                        shipCreator(newShip, newShipSize, this.boardSize);
                        return;
                    }

                    addOn++;
                }
                while (addOn < newShipSize)
                {
                    this.gameBoard[initialShipPointRow][initialShipPointCollumn + addOn].setHasShip(true);
                    addOn++;
                }
                break;

        }
    }

    public void shipExtenderUpOrLeft(Ship newShip, int newShipSize)
    {
        Random random = new Random();
        int randomNum = random.nextInt(2);
        int addOn = 1;
        int initialShipPointRow = newShip.getInitialPointRow();
        int initialShipPointCollumn = newShip.getInitialPointCollumn();
        switch (randomNum)
        {
            case 0:
                this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);

                while (addOn < newShipSize)
                {
                    if (this.gameBoard[initialShipPointRow - addOn][initialShipPointCollumn].getHasShip())
                    {
                        shipCreator(newShip, newShipSize, this.boardSize);
                        return;
                    }

                    addOn++;
                }
                while (addOn < newShipSize)
                {

                    this.gameBoard[initialShipPointRow - addOn][initialShipPointCollumn].setHasShip(true);
                    addOn++;
                }
                break;
            case 1:
                this.gameBoard[initialShipPointRow][initialShipPointCollumn].setHasShip(true);
                while (addOn < newShipSize)
                {
                    if (this.gameBoard[initialShipPointRow][initialShipPointCollumn - addOn].getHasShip())
                    {
                        shipCreator(newShip, newShipSize, this.boardSize);
                        return;
                    }

                    addOn++;
                }
                while (addOn < newShipSize)
                {

                    this.gameBoard[initialShipPointRow][initialShipPointCollumn - addOn].setHasShip(true);
                    addOn++;
                }
                break;
        }
    }




    public BoardPoint [][] getGameBoard()
    {
        return this.gameBoard;
    }

    public void setGameBoard( BoardPoint [][] newGameBoard)
    {
        this.gameBoard = newGameBoard;
    }

    public int getBoardSize()
    {
        return this.boardSize;
    }

    public void setBoardSize(int newBoardSize)
    {
        this.boardSize = newBoardSize;
    }

    public void printBoard()
    {
        for (int r = 0; r < this.gameBoard.length; r++)
        {
            System.out.println();
            for (int c = 0; c < this.gameBoard[r].length; c++)
            {
                if(this.gameBoard[r][c].getHasShip())
                {
                    this.gameBoard[r][c].setPoint('S');
                }
                System.out.print(this.gameBoard[r][c] + " ");
            }
        }
    }
}
