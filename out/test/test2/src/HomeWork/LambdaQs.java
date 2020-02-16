package HomeWork;

public class LambdaQs {
    public void eat(Eatable e){
        System.out.println(e);
        e.taste();
    }
    public static void main(String[] args) {
        LambdaQs test = new LambdaQs();
        test.eat(()->System.out.println("apple is delicious!"));
    }
}
interface Eatable{
    void taste();
}
