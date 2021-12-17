package task.cputask;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

import feature.Feature;
import feature.FeatureCollector;
import latch.Latch;
import task.Task;

public class CpuTask extends Task {
	private static final int origin = 10_000;
	private static final int bound = 100_000_000;

	private static Latch latch = new Latch();
	private static FeatureCollector featureCollector = new FeatureCollector();
	private static Boolean stop = false;
	
	public static FeatureCollector featureCollector() {
		return featureCollector;
	}

	public static int sumValue(int load, Feature feature) {
		try {
			latch.lock(feature);
			int sum = 0;
			for (int i = 0; i < load; i++) {
				if (i % 2 == 0) {
					sum += i;
				} else {
					sum -= i;
				}
			}

			return sum;
		} finally {
			latch.unLock(feature);
		}
	}

	public void run() {
		while (!stop) {
			Feature feature = new Feature();
			int load = ThreadLocalRandom.current().nextInt(origin, bound);
			sumValue(load, feature);
			featureCollector.addFeature(feature);
		}
	}
	
	public static void stop() {
		stop = true;
	}
}
