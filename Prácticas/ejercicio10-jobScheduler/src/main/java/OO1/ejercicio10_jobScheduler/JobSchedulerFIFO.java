package OO1.ejercicio10_jobScheduler;

public class JobSchedulerFIFO extends JobScheduler{

	public JobDescription next() {
		JobDescription nextJob = null;
		nextJob = this.getJobs().get(0);
    	this.unschedule(nextJob);
    	return nextJob;
	}
}
