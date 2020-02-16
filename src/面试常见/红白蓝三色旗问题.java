package 面试常见;

public class 红白蓝三色旗问题 {
    public static void main(String[] args) {
        int[] a = {2,1,0,2,1,0};
        sortColors(a);
      //  int aa = 0;


        System.out.println();
    }
    public static void sortColors(int[] a) {
        if(a==null||a.length<=1){
            return;
        }
        int i=0;
        int j = a.length - 1;
        int cur = i;
        while (cur < j) {
            if (a[cur] == 2) {
                change(a, j, cur);
                j--;
            } else if (a[cur] == 0) {
                change(a, i, cur);
                i++;
                cur++;

            } else {
                cur++;
            }
        }
    }

    public static void change(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
