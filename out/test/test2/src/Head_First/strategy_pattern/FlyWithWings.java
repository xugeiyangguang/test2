package Head_First.strategy_pattern;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("im fling!!");
    }
}
