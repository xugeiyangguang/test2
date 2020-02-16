package Companies.Else;

import java.util.Scanner;

public class MaxLudeng {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for(int i=0;i<test;i++){
            int num = scanner.nextInt();

            char[][] road = new char[num][2];
            String s = scanner.next();
            for(int j = 0;j<num;j++){
                road[j][0] = s.charAt(j);
                road[j][1] = '0';
            }
            if (num <= 3) {
                System.out.println();
            }
            //计算每个位置最多能够照明的数量
            int max=0;
            for(int j = 0;j<num;j++){
                if(j>=1&&road[j-1][0]=='.'){
                    road[j][1]++;
                }
                if(road[j][0]=='.'){
                    road[j][1]++;
                }
                if(j+1<num&&road[j+1][0]=='.'){
                    road[j][1]++;
                }
                max = Math.max(max,road[j][1]);
            }
            //对有连续的照亮位置进行调整
            for(int j = 0;j<num;j++){
                //有连续四个三
                if(j+3<num&&road[j][1]=='3'&&road[j+1][1]=='3'&&road[j+2][1]=='3'&&road[j+3][1]=='3'){
                    road[j+1][1]='0';
                    road[j+2][1]='0';
                }
                //连续三个三
                if(j+2<num&&road[j][1]=='3'&&road[j+2][1]=='3'&&road[j+1][1]=='3'){
                    road[j+1][1]='0';
                }
            }
            //检测最终的数目
            int re = 0;
            for(int j = 0;j<num;j++){
                if(road[j][1]==max){
                    re++;
                }

            }
            System.out.println(re);
        }
    }
}
