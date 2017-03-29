/**
 * A class that represents a train passenger.
 *
 * @author Joshua Steward
 * @version 3/3/2015
 */
public class Passenger
{
    private int startedWaiting;
    private int boardedAt;
    private boolean boardedTrain;
    private int startStation;
    private int destination;

    Passenger(int start, int dest, int createdAt)
    {
        this.startedWaiting = createdAt;
        this.startStation = start;
        this.destination = dest;
        this.boardedTrain = false;
        System.out.println("\tCreated passenger at station " + start + " heading to " + dest);
    }

    public int getDestination()
    {
        return this.destination;
    }

    public void boardTrain(int clock)
    {
        this.boardedAt = clock;
        this.boardedTrain = true;
    }

    public int waitTime(int clock)
    {
        int result = clock - this.startedWaiting;
        if (this.boardedTrain)
            result = this.boardedAt - this.startedWaiting;

        return result;
    }

    public boolean boarded()
    {
        return this.boardedTrain;
    }
}
