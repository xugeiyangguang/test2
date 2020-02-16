package Companies.aiqiyi;

import java.util.ArrayList;
import java.util.Scanner;

public class One {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String[] b = s.nextLine().split(" ");
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = i+1;
        }
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        func(re,0,a);
        int count = re.size();
        for(int i=0;i<re.size();i++){
            ArrayList<Integer> tmp = re.get(i);
            for(int j=0;j<tmp.size()-1;j++){
                if(b[j].equals("1")){
                    if(j+1<tmp.size()&&tmp.get(j)<tmp.get(j+1)){
                        count--;
                        break;
                    }
                }
                if(b[j].equals("0")){
                    if(j+1<tmp.size()&&tmp.get(j)>tmp.get(j+1)){
                        count--;
                        break;
                    }
                }
            }
        }
        System.out.println(count%(1000000000+7));
    }
    public static void func(ArrayList<ArrayList<Integer>> re,int index,int[] a){
        if(index==a.length-1){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0;i<a.length;i++){
                tmp.add(a[i]);
            }
            re.add(tmp);
        }
        for(int i=index;i<a.length;i++){
            int tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
            func(re,index+1,a);
            tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
        }
    }
}
