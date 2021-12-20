package feature;

public class Feature {
	private long maxAcquiredTimeSmallWindow;
	private long maxAcquiredTimeMediumWindow;
	private long maxAcquiredTimeLargeWindow;
	private long maxWaitingTime;
	private long acquireLatch;
	private long latchAcquired;
	private long latchReleased;
	private long acquirerNum;

	public void setMaxAcquiredTime(long sm, long md, long lg) {
		maxAcquiredTimeSmallWindow = sm;
		maxAcquiredTimeMediumWindow = md;
		maxAcquiredTimeLargeWindow = lg;
	}

	public void setMaxWaitingTime(long maxWaitingTime) {
		this.maxWaitingTime = maxWaitingTime;
	}

	public long setAcquireLatchTime() {
		acquireLatch = System.nanoTime();
		return acquireLatch;
	}

	public long setLatchAcquiredTime() {
		latchAcquired = System.nanoTime();

		return latchAcquired;
	}

	public void setLatchReleasedTime() {
		latchReleased = System.nanoTime();
	}

	public void setAcquirerNum(long num) {
		acquirerNum = num;
	}

	public String toString() {
		return acquireLatch + "," + latchAcquired + "," + latchReleased + "," + acquirerNum + "," + maxWaitingTime + ","
				+ maxAcquiredTimeSmallWindow + "," + maxAcquiredTimeMediumWindow + "," + maxAcquiredTimeLargeWindow;
	}

	public static String header() {
		return "acquire latch,latch acquired,latch released,acquirer number,max waiting time,max acquired time (sm),max acquired time (md),max acquired time (lg)";
	}
}
