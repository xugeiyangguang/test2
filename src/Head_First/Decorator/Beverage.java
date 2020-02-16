package Head_First.Decorator;

import java.util.concurrent.locks.Condition;

public abstract class Beverage {
    String description;

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}
class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "DarkRoast";
    }

    public double cost() {
        return 1.99;
    }
}

class Decat extends Beverage {
    public Decat() {
        description = "Decat";
    }

    public double cost() {
        return 1.99;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    public double cost() {
        return 0.89;
    }
}

class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

}
class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

}

class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

}

