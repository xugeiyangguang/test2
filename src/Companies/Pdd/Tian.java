package Companies.Pdd;

import java.util.Scanner;

public class Tian {
    private static int floor;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num==0)
            System.out.println(0);
        if(num==1)
            System.out.println(1);
        int[] length = new int[num];
        int[] weight = new int[num];
        for(int i=0;i<num;i++){
            length[i] = in.nextInt();
        }
        for(int j=0;j<num;j++){
            weight[j] = in.nextInt();
        }
        for(int k=num-1;k>0;k--){
            for(int p=0;p<k;p++){
                if(length[p]<length[p+1]){
                    int temp = length[p+1];
                    length[p+1] = length[p];
                    length[p] = temp;
                    temp = weight[p+1];
                    weight[p+1] = weight[p];
                    weight[p] = temp;
                }
            }
        }
        process(length,weight,num);
    }
    public static void process(int[] length,int weight[],int num){
        int[] totalweight =new int[num-1];
        //每层的总重量
        int[] floorweight =new int[num];
        int lastlength=0;
        for(int l=0;l<num;l++){
            if(l==0){
                floorweight[0]=weight[0];
                lastlength=length[0];
                Tian.floor=1;
            }else {
                if(lastlength>length[l]){
                    for(int u=0;u<Tian.floor;u++){
                        totalweight[u]+=weight[l];
                    }
                    floorweight[Tian.floor]=weight[l];

                    if(!panduan(totalweight,floorweight)){
                        System.out.println(Tian.floor);
                        return;
                    }else{

                    }
                    Tian.floor++;
                    lastlength = length[l];

                }else{
                    continue;
                }
            }
        }
        System.out.println(Tian.floor);
    }
    public static boolean panduan(int[] totalweight,int[] floorweight){
        for(int i=0;i<totalweight.length;i++){
            if(totalweight[i]/(floorweight[i]+0.0)>7)
                return false;
        }
        return true;
    }
}
