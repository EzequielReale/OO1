package OO1.ejercicio10_jobScheduler;

public class JobSchedulerLIFO extends JobScheduler{
	
	public JobDescription next() {
		JobDescription nextJob = null;
		nextJob = this.getJobs().get(this.getJobs().size()-1);
    	this.unschedule(nextJob);
    	return nextJob;
	}
}
