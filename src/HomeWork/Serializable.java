package HomeWork;

import java.io.*;

public class Serializable {
    public static void main(String[] args) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\xuyangtest\\object.txt"))) {
            person a = new person("xuyang", 23);
            outputStream.writeObject(a);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\xuyangtest\\object.txt"))) {
            person a = (person) inputStream.readObject();
            System.out.println(a.name + ":" + a.age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class person implements java.io.Serializable {
    String name;
    transient int age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
