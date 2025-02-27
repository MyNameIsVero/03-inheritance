package ohm.softa.a03;

public class PlayfulState extends State{
    public PlayfulState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        return new SleepingState(cat.getSleep());
    }
}
