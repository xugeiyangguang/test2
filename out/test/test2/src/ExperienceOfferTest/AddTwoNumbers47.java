package ExperienceOfferTest;

public class AddTwoNumbers47 {
    public static void main(String[] args) {
        AddTwoNumbers47 test = new AddTwoNumbers47();
        System.out.println(test.Add(-1,3));
    }
    public int Add(int num1,int num2) {
        do{
            int sum = num1 ^ num2;
            int carry = (num1&num2)<<1;

            num1 = sum;
            num2 = carry;
        }while (num2!=0);
        return num1;
    }
}
