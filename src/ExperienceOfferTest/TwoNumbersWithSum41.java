package ExperienceOfferTest;

import java.util.ArrayList;

public class TwoNumbersWithSum41 {
    public static void main(String[] args) {
        TwoNumbersWithSum41 test =new TwoNumbersWithSum41();
        ArrayList<ArrayList<Integer>> r = test.FindContinuousSequence(5);
        if (r!=null){
            for (ArrayList<Integer> i : r
            ) {
                for (int k: i
                ) {
                    System.out.print(k);
                }
                System.out.println();
            }
        }
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start = 1;
        int end = 2;
        int total = 0;
        while (start<=sum/2) {
            total = (start+end)*(end-start+1)/2;

            if (total> sum) {
                start++;
            }else if (total<sum){
                end++;
            }else {
                storeNumber(result,start,end);
                start++;
            }
        }
        return result;
    }

    public void storeNumber(ArrayList<ArrayList<Integer>> result,int start,int end){
        ArrayList<Integer> a = new ArrayList<>();
        for (int i=start;i<=end;i++){
            a.add(i);
        }
        result.add(a);
    }
}
