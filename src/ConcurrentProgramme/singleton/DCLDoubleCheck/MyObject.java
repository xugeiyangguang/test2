package ConcurrentProgramme.singleton.DCLDoubleCheck;
//DCL双检查机制
public class MyObject {
    private volatile static MyObject myObject;
    private MyObject() {
    }

    public static MyObject getInstance() {
        try {
            if (myObject != null) {
            } else {
                Thread.sleep(3000);
                synchronized (MyObject.class) {
                    if (myObject == null) {
                        myObject = new MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}

//静态内置类实现饿汉模式
class MyObject1 {
    private static class MyObjectHandler {
        private static MyObject1 myObject1 = new MyObject1();
    }

    public static MyObject1 getInstance() {
        return MyObjectHandler.myObject1;
    }

    private MyObject1() {

    }
}

//使用static代码块
class MyObject2{
    private static MyObject2 instance = null;

    public MyObject2() {

    }

    static {
        instance = new MyObject2();
    }

    public static MyObject2 getInstance() {
        return instance;
    }
}
//基于枚举类型
enum MyObject3{
    INSTANCE;
    MyObject3() {
    }
}
