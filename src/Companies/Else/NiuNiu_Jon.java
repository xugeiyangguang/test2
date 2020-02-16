package Companies.Else;

import java.util.*;

public class NiuNiu_Jon {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int job_num = scanner.nextInt();
        int person_num = scanner.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int level;//工作的难度
        int money;//报酬
        for(int i =0 ;i<job_num;i++){
            level = scanner.nextInt(); //工作难度
            money = scanner.nextInt(); //报酬
            //工作难度相同，存储报酬多的，即不录入该行记录
            if (hashMap.containsKey(level) && hashMap.get(level) > money) {
                continue;
            }
            hashMap.put(level, money);
        }
        //录入人的能力信息
        int[] person = new int[person_num];
        for(int i = 0;i<person_num;i++){
            //直接插入工作表中
            person[i] = scanner.nextInt();
            if (!hashMap.containsKey(person[i])){
                hashMap.put(person[i], 0);
            }
        }
        Set<Integer> key_set = hashMap.keySet();
        List<Integer> temp = new ArrayList<>();
        temp.addAll(key_set);
        Collections.sort(temp);
        //找到每个难度能得到的最高报酬
        int max = 0;
        for (int i = 0; i < temp.size(); i++) {
            max = Math.max(max, hashMap.get(temp.get(i)));
            hashMap.put(temp.get(i), max);
        }
        for(int j=0;j<person_num;j++){
            System.out.println(hashMap.get(person[j]));
        }
        /*for(int i= 0;i<person_num;i++){
            for(int j=0;j<temp.size();j++){
                //能力刚好匹配
                if(temp.get(j)==person[i]){
                    System.out.println(hashMap.get(temp.get(j)));
                    break;
                }
                //能力比不上当前工作，选低一档
                if(temp.get(j)>person[i]){
                    if(j==0){
                        System.out.println(0);
                        break;
                    }
                    System.out.println(hashMap.get(temp.get(j - 1)));
                    break;
                }
                //能力超过当前的工作
            }
        }*/

    }
}
