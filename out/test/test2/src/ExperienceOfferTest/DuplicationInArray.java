package ExperienceOfferTest;

public class DuplicationInArray {
    public static void main(String[] args) {
        DuplicationInArray test = new DuplicationInArray();
        int[] numbers = {2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        System.out.println(test.duplicate(numbers,7,duplication));

    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null||numbers.length==0||length<=0){
            return false;
        }
        for (int i = 0;i<length;i++){
            if (numbers[i]>=length){
                return false;
            }
        }
        int temp;
        for (int i = 0;i<length;i++){
            while (numbers[i]!=i){
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
