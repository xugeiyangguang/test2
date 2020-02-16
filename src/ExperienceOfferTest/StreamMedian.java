package ExperienceOfferTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StreamMedian {
    ArrayList<Integer> inputArr = new ArrayList<>();
    {
        inputArr.add(5);
        inputArr.add(2);
        inputArr.add(3);
        inputArr.add(4);
        inputArr.add(1);
        inputArr.add(6);
        inputArr.add(7);
        inputArr.add(0);
        inputArr.add(8);


    }
    public static void main(String[] args) {
        StreamMedian test = new StreamMedian();
        Double re = test.GetMedian();
        System.out.println();
    }
    public void Insert(Integer num) {
        inputArr.add(num);
    }

    public Double GetMedian() {
        Collections.sort(inputArr);
        if (inputArr.size()%2==0){
            return (double)(inputArr.get(inputArr.size()/2)+inputArr.get(inputArr.size()/2-1))/2;
        }else {
            return (double)inputArr.get(inputArr.size()/2);
        }
    }
}
