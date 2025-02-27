package ohm.softa.a03;

public class HungryState extends State{

    public HungryState(int duration) {
        super(duration);
    }

    public State feed(Cat cat){
        // logger in State klasse muss protected statt private sein
        logger.info("You feed the cat...");
        return new DigestingState(cat.getDigest(),getTime());
    }
    @Override
    public State successor(Cat cat) {
        return new DeadState();
    }
}
