package HomeWork;

public class Student {
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String address;
    private String email;
    public Student(){

    }
    public Student(String name, int age, String gender, String phone,String address,String email){
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.phone = phone;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void eat(){
        System.out.println("我在吃东西");
    }
    public void drink(){
        System.out.println("我在喝水");
    }
    public void play(){
        System.out.println("我在玩");
    }
    public void sleep(){
        System.out.println("我在睡觉");
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("xuyang",23,"female","12345","电子科技大学","271244108@qq.com");
        for (Student i: students
             ) {
            if (i.name == "xuyang"){
                System.out.println("找到该同学，邮箱是：" + i.email);
                break;
            }
        }
    }
}
