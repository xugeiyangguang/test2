package ExperienceOfferTest2;

public class A51_duplicate {
    public static void main(String[] args) {
        A51_duplicate test = new A51_duplicate();
        int numbers[] = {2, 6, 1, 0, 4, 5, 3};
        int[] duplication = new int[1];
        boolean re = test.duplicate(numbers, 7, duplication);
        System.out.println();
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
            i++;
        }
        return false;
    }
}
