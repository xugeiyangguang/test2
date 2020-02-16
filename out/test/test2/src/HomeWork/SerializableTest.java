/*
package HomeWork;

import ConcurrentProgramme.OneProduceToOneClient.P;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String name;
    protected transient int age;

    public Person() {
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString()
    {
        return "this is person:"+"name:"+this.name+"——age:"+this.age;
    }

}

class User extends Person {
    private static final long serialVersionUID = 1L;

    private String name;
    private String password;

    public User() {

    }

    public User(String name,String password,int age)
    {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString()
    {
        return "this is user:"+"name:"+this.name+"——password:"+this.password+"——age:"+this.age;
    }

}
public class SerializableTest {
    public static void main(String[] args) {
        Person p1 = (Person)deSerialByte(serialByte(new User("user","1234",15)));

        Person p2 = (Person)deSerialByte(serialByte(new Person("person",10)));

        System.out.println("p1:"+p1.toString());

        System.out.println("p2:"+p2.toString());

    }
    //序列化一个对象（可以存储到一个文件也可以存储到字节数组）这里存储到自己数组
    public static byte[] serialByte(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    //反序列化一个对象
    public static Object deSerialByte(byte[] by) {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new ByteArrayInputStream(by));
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
*/
