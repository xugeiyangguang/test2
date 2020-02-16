package ExperienceOfferTest;

public class ArrayTest {
    public static void main(String[] args){
        double[] a = {1.9, 2.9, 3.4, 3.5};
        /*打印所有数组*/
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        /*foreach 循环输出*/
        System.out.print("\nthis is foreach:");
        for(double j:a){
            System.out.print(j+" ");
        }
        /*output 数组最大值*/
        System.out.print("\nthis is max:");
        double max=a[0];
        for(double j:a){
            if(j>max){
                max=j;
            }
        }
        System.out.println(max);
    }
}
