package Head_First.strategy_pattern;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("i cannot fly!!!");
    }
}
