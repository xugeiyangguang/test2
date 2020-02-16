package HomeWork;

class Father{
    String name;
    int age;
    static int i = 1;
    public Father(){

    }
    static {
        System.out.println("父类的静态代码块！");
        i = 2;
    }

    public Father(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("父类的构造器！");
    }
    public void play(){
        System.out.println("我是父类的play方法！");
    }
    public void eat(){
        System.out.println("我是父类的eat方法！");
    }

}
public class DuotaiClass extends Father {
    static {
        System.out.println("子类的静态代码块！");
    }
    public DuotaiClass(String name, int age){
        super(name,age);
        System.out.println("子类的构造器！");
    }
    public void eat(){
        System.out.println("我是子类的eat方法！");
    }
    public void watch(){
        System.out.println("我是子类的watch方法！");
    }

    public static void main(String[] args) {
        Father a = new DuotaiClass("yang",23);
        System.out.println(a.name+":"+a.age);
        a.play();
        a.eat();   //子类重写了，进行了多态
        ((DuotaiClass) a).watch();   //子类定义了父类没有的方法，会将父类引用强制转换为子类引用
        System.out.println(i);
    }
}
