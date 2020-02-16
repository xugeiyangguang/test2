package ExperienceOfferTest;

import java.io.OutputStream;
import java.util.Arrays;

public class ContinousCards {
    public static void main(String[] args) {
        ContinousCards test = new ContinousCards();
        int[] numbers = {0,0,1,3,3};
        System.out.println(test.isContinuous(numbers));

    }
    public boolean isContinuous(int [] numbers) {
        if (numbers == null||numbers.length==0){
            return false;
        }
        Arrays.sort(numbers);
        int zero = 0;
        int gap = 0;
        for (int i= 0; i<numbers.length-1;i++){
            if (numbers[i]==0){
                zero++;
                continue;
            }
            if (numbers[i] == numbers[i+1]){
                return false;
            }
            int count = 1;
            while (numbers[i]+count != numbers[i+1]){
                gap++;
                count++;
            }
            if (gap>zero){
                return false;
            }
        }
        return true;
    }
}
