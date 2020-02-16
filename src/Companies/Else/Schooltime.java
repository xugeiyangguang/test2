package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Schooltime {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> clock = new ArrayList<>();
        for(int i =0 ;i<n;i++){
            List<Integer> l = new ArrayList<>();
            l.add(scanner.nextInt());
            l.add(scanner.nextInt());
            clock.add(l);
        }
       // Collections.sort(clock);

        //需要的中间时间
        int need_time = scanner.nextInt();
        //学校上学的时间
        List<Integer> ok = new ArrayList<>();
        ok.add(scanner.nextInt());
        ok.add(scanner.nextInt());
        int oktime = ok.get(0)*60+ok.get(1);

        int re = 0;
        int newhour = 0;
        int newmin = 0;
        int minok = Integer.MAX_VALUE;
        int minok_temp = 0;
        for(int i=0;i<n;i++){
            //对时要小于标准的考虑
            if(clock.get(i).get(0)<=ok.get(0)){
                newmin = clock.get(i).get(1) + need_time;
                newhour = clock.get(i).get(0)+newmin/60;
                newmin = newmin%60;
                if(newhour<ok.get(0)||newhour==ok.get(0)&&newmin<=ok.get(1)){

                    minok_temp = oktime - newhour*60-newmin;
                    if (minok_temp<minok){
                        re = Math.max(re,i);
                        minok = minok_temp;
                    }

                }
            }
        }
        System.out.print(clock.get(re).get(0));
        System.out.print(" ");
        System.out.print(clock.get(re).get(1));
    }
}
