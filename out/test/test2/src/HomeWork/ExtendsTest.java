package HomeWork;

/**
 * 继承，封装，多态，
 */
class Transportation{
    public String species;
    public String color;
    public String way;

    public Transportation(String species, String color, String way){
        this.species = species;
        this.color= color;
        this.way = way;
    }

    public void state(){
        System.out.println("我是父类交通工具！");
    }
}
class Car extends Transportation{
    public int size;

    public Car(String species, String color, String way, int size){
        super(species,color,way);
        this.size = size;
    }

    public void state(){
        System.out.println("我是子类汽车！");
    }
}
class Train extends Transportation{
    public int length;

    public Train(String species, String color, String way, int length){
        super(species,color,way);
        this.length = length;
    }

    public void state(){
        System.out.println("我是子类火车！");
    }
}
class Plane extends Transportation{
    public String number;

    public Plane(String species, String color, String way, String number){
        super(species,color,way);
        this.number = number;
    }

    public void state(){
        System.out.println("我是子类飞机！");
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        Transportation transportation = new Transportation("car","white","ground");
        transportation.state();
        Transportation car = new Car("car","white","ground",24);
        car.state();
        Car car1 = new  Car("car","white","ground",24);
        car1.state();
    }
}
