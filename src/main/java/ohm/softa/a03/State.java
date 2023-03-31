package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    private final int duration;
	private int t;

    protected static final Logger logger = LogManager.getLogger();

    protected State(int duration) {
        this.duration = duration;
    }

    public int getTime(){
        return t;
    }

    public int getDuration() {
        return duration;
    }

    public abstract State successor(Cat cat);

    public State tick(Cat cat){
        t = t+1;
        if (t >= duration) {
          return this.successor(cat);
        }
        else {
            return this;
        }

    }

}
