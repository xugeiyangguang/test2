package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TreeSumZero {
    public static void main(String[] args) {
        int[] num = {-2,0,0,2,2};
        ArrayList<ArrayList<Integer>> re = threeSum(num);
        System.out.println();

    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if(num.length<3){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<num.length;i++){
            if(map.containsKey(num[i])){
                map.put(num[i],map.get(num[i])+1);
            }else{
                map.put(num[i],1);
            }
        }
        for(int i = 0;i<num.length;i++){

            for(int j=0;j<num.length;j++){
                if(i!=j){
                    map.put(num[i],map.get(num[i])-1);
                    map.put(num[j],map.get(num[j])-1);
                    int k = 0-num[i]-num[j];
                    if(map.containsKey(k)&&map.get(k)>=1){
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(k);
                        Collections.sort(tmp);
                        if (!re.contains(tmp)){
                            re.add(tmp);
                        }

                    }
                    map.put(num[j],map.get(num[j])+1);
                }

            }
            map.put(num[i],map.get(num[i])+1);
        }

        return re;
    }
}
