package Head_First.strategy_pattern;

import java.util.ArrayDeque;

public class MiniDucksSimulator {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performQuack();
        duck.performFly();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

    }

}
