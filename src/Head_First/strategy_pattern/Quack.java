package Head_First.strategy_pattern;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack!!!");
    }
}
