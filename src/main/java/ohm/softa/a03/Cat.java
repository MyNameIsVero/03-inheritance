package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Cat {
	private static final Logger logger = LogManager.getLogger();

	private State currentState;
	// valid states

	// initially, animals are sleeping
	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	private int time = 0;
	private int timeDigesting = 0;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.currentState = new SleepingState(sleep);
	}

	public int getAwake(){return awake;}
	public int getSleep(){return sleep;}
	public int getDigest(){return digest;}

	public void tick(){
		logger.info("tick()");
		time = time + 1;



		logger.info(currentState.getClass().getName());

	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");
		currentState = ((HungryState) currentState).feed(this);
	}

	public boolean isAsleep() {
		return currentState instanceof SleepingState;
	}

	public boolean isPlayful() {
		return currentState instanceof PlayfulState;
	}

	public boolean isHungry() {
		return currentState instanceof HungryState;
	}

	public boolean isDigesting() {
		return currentState instanceof DigestingState;
	}

	public boolean isDead() {
		return currentState instanceof DeadState;
	}

	@Override
	public String toString() {
		return name;
	}

}

