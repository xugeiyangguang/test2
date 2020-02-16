package ExperienceOfferTest2;

public class A47_Add {
    public int Add(int num1,int num2) {
        int sum, carray;
        do {
            sum = num1 ^ num2;
            carray = (num1 & num2) << 1;

            num1 = sum;
            num2 = carray;
        } while (num2 != 0);
        return num1;
    }
}
