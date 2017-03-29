import java.util.*;
import java.util.concurrent.*;

/**
 * A class that represents a train in a simulation.
 *
 * @author Joshua Steward
 * @version 3/3/2015
 */
public class Train
{
    private Queue<Passenger> onTrain;
    private int numberOnTrain;
    private int capacity;
    private int nextStation;
    private int timeToArrivalAtNextStation;
    private int trainNo;
    private static int trainsCreated = 0;

    public Train(int capacity)
    {
        this.onTrain = new LinkedBlockingQueue<>();
        this.numberOnTrain = 0;
        this.capacity = capacity;

        // Will arrive at the first station in 1 min
        this.nextStation = 0;
        this.timeToArrivalAtNextStation = 1;

        trainsCreated++;
        this.trainNo = trainsCreated;
        System.out.println("\tCreated train " + this.trainNo);
    }

    public int nextStation()
    {
        return this.nextStation;
    }

    public int timeToNext()
    {
        return this.timeToArrivalAtNextStation;
    }

    public void move()
    {
        this.timeToArrivalAtNextStation--;
    }

    public void updateStation(int timeToNext)
    {
        this.timeToArrivalAtNextStation = timeToNext;
        this.nextStation++;
    }

    public int unloadPassengers(int station)
    {
        int count = this.numberOnTrain;
        for (int i = 0; i < count; i++)
        {
            Passenger person = this.onTrain.poll();
            if (person.getDestination() != station)
            {
                // Not there yet, put them back
                this.onTrain.offer(person);
            }
            else
            {
                // They arrived
                this.numberOnTrain--;
            }
        }

        int passengersLeaving = count - this.numberOnTrain;
        System.out.println("\tTrain " + this.trainNo + " unloaded "
                + passengersLeaving + " passengers at station " + station);
        return passengersLeaving;
    }

    public int loadPassengers(Station station, int clock)
    {
        int count = this.numberOnTrain;
        boolean passengerWaiting = station.isWaiting();

        while ((this.numberOnTrain < this.capacity) && passengerWaiting)
        {
            Passenger boarder = station.getPassenger();
            this.onTrain.offer(boarder);
            boarder.boardTrain(clock);
            passengerWaiting = station.isWaiting();
            this.numberOnTrain++;
        }

        int passengersEntering = this.numberOnTrain - count;
        System.out.print("\t\tloaded " + passengersEntering + " passengers");
        System.out.println("; Space left " + (this.capacity - this.numberOnTrain));

        return passengersEntering;
    }
}
