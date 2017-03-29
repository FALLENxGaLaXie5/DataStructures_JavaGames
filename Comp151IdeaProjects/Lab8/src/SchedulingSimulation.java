import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;
/**
 * Created by Joshua Steward on 3/24/2015.
 */
public class SchedulingSimulation
{
    private PriorityQueue<Job> waitingJobs;
    private LinkedBlockingQueue<Job> allJobs;
    private Job currentJob;
    private int priorityMode;
    private final int TIME_SLICE_PER_JOB = 3;
    private final int SIMULATION_DURATION = 100;
    private final int JOB_PROBABILITY = 30;
    private final int JOB_PRIORITY = 4;
    private final int JOB_MIN_TIME = 1;
    private final int JOB_MAX_TIME = 5;
    private static final int SORT_BY_PRIORITY = 0;
    private static final int SORT_BY_LENGTH = 1;
    public Random generator;

    public SchedulingSimulation(int sortNum)
    {
        generator = new Random();
        if (sortNum == SORT_BY_PRIORITY)
        {
            this.waitingJobs = new PriorityQueue<>();
        }
        else
        {
            this.waitingJobs = new PriorityQueue<>(10, new Comparator<Job>()
            {
                @Override
                public int compare(Job job1, Job job2)
                {
                    return job1.getTimeLeft() - job2.getTimeLeft();
                }
            }
            );
        }
    }

    public void runSimulation()
    {
        int jobsLeft = this.allJobs.size();
        Job job;
        Job otherJob;
        for (int i = 0; i < jobsLeft; i++)
        {
            job = this.allJobs.poll();
            otherJob = this.allJobs.poll();
            job.update(TIME_SLICE_PER_JOB);
            if (job.compareTo(otherJob) == 1)
            {
                this.waitingJobs.poll();
            }
            else if (job.compareTo(otherJob) == -1)
            {

            }
        }
    }

    public void generateJob(int clock)
    {
        this.priorityMode = generator.nextInt(JOB_PRIORITY) + 1;
            Job newJob = new Job(this.priorityMode, TIME_SLICE_PER_JOB, clock);
            this.allJobs.offer(newJob);
    }

    public void currentReport(int n)
    {

    }

    public void finalReport()
    {

    }

    public static void main(String args[])
    {
        System.out.println("***STARTING THE SIMULATION WITH PRIORITY MODE SET TO SORT_BY_PRIORITY***");
        SchedulingSimulation simulator = new SchedulingSimulation(0);

        for (int clock = 0; clock < simulator.SIMULATION_DURATION; clock++)
        {
            simulator.runSimulation();
            simulator.generateJob(clock);
            simulator.currentReport(clock);
        }
        simulator.finalReport();
    }
}
