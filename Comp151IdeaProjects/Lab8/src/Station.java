import java.util.*;
import java.util.concurrent.*;

/**
 * A class that represents a train station
 * where passengers will wait.
 *
 * @author Joshua Steward
 * @version 3/3/2015
 */
public class Station
{
    private Queue<Passenger> waiting;
    private int timeToNextStation;

    /**
     * Constructor for objects of class Station
     */
    public Station(int timeToNext)
    {
        this.waiting = new LinkedBlockingQueue<>();
        this.timeToNextStation = timeToNext;
    }

    public void addPassenger(Passenger rider)
    {
        this.waiting.offer(rider);
    }

    public boolean isWaiting()
    {
        return !(this.waiting.isEmpty());
    }

    public Passenger getPassenger()
    {
        return this.waiting.poll();
    }

    public int getTimeToNextStation()
    {
        return this.timeToNextStation;
    }
}