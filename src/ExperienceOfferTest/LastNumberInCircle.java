package ExperienceOfferTest;

import java.util.LinkedList;

public class LastNumberInCircle {
    public static void main(String[] args) {
        LastNumberInCircle test = new LastNumberInCircle();
        System.out.println(test.LastRemaining_Solution(5,3));
    }
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0){
            return -1;
        }
        LinkedList<Integer> s = new LinkedList<>();
        for (int i= 0;i<n;i++){
            s.add(i);
        }
        int start = 0;
        /*while (s.size()!=1){
            for (int i = 1;i < m;i++ ){
                start++;
                if (start >= s.size()){
                    start = 0;
                }

            }
            System.out.print(s.get(start));
            s.remove(start);
            if (start >= s.size()){
                start = 0;
            }
        }*/
        int bt=0;
        while (s.size()!=1){
            bt = (bt+m-1)%s.size();
            s.remove(bt);
        }
        return s.getFirst();
    }
}
