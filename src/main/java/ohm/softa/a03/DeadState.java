package ohm.softa.a03;

public class DeadState extends State{
    public DeadState() {
        super(0);
    }

    @Override
    public State successor(Cat cat) {
        return this;
    }
}
