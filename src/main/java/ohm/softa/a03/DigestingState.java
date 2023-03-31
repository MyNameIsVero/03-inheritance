package ohm.softa.a03;

public class DigestingState extends State{

    private int remainingAwake;

    public DigestingState(int duration, int remainingAwake) {
        super(duration);
        this.remainingAwake = remainingAwake;
    }

    @Override
    public State successor(Cat cat) {
        return new PlayfulState(remainingAwake - cat.getDigest());
    }
}
