package OO1.ejercicio10_jobScheduler;

public class JobSchedulerHighestPriority extends JobScheduler{

	public  JobDescription next() {
		JobDescription nextJob = null;
		nextJob = getJobs().stream()
			.max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
			.orElse(null);
    	this.unschedule(nextJob);
    	return nextJob;
	}
}
