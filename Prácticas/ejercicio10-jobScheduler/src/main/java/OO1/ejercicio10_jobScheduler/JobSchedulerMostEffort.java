package OO1.ejercicio10_jobScheduler;

public class JobSchedulerMostEffort extends JobScheduler{

	public  JobDescription next() {
		JobDescription nextJob = null;
	    nextJob = this.getJobs().stream()
 			.max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
 			.orElse(null);
	    this.unschedule(nextJob);
	    return nextJob;
	}
}
