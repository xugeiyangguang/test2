package HomeWork;


class Human{
}
class Man extends Human{
}
class Woman extends Human{
}

public class FenPai{

    public void say(Human hum){
        System.out.println("I am human");
    }
    public void say(Man hum){
        System.out.println("I am man");
    }
    public void say(Woman hum){
        System.out.println("I am woman");
    }

    public static void main(String[] args){
        Human man = new Man();
        Human woman = new Woman();
        FenPai sp = new FenPai();
        sp.say(man);
        sp.say(woman);
    }


}


