/**
 * Created by Joshua Steward on 3/24/2015.
 */
public class Job implements Comparable<Job>
{
    private int jobNo;
    private int priority;
    private int createdAtTime;
    private int timeLeft;
    private static int jobsCreated;

    public Job(int newPriority, int time, int timeCreated)
    {
        this.priority = newPriority;
        this.timeLeft = time;
        this.createdAtTime = timeCreated;
    }

    public int compareTo(Job other)
    {
        int result = 0;
        if (this.priority > other.priority)
        {
            result = 1;
        }
        else if (this.priority < other.priority)
        {
            result = -1;
        }
        return result;
    }

    public int getTimeLeft()
    {
        return this.timeLeft;
    }

    public static int getJobsCreated()
    {
        return jobsCreated;
    }

    public void update(int n)
    {

    }

    public boolean isFinished()
    {
        return false;
    }

    public String toString()
    {
        return "";
    }
}
