package Companies.Else;

public class MathTools {
    public static void main(String[] args){
        int[] n = {3,2,5,4,1};
        int[] b = {5,2,3,1,4};
        match(n,b,0,n.length-1);
        show(n);
        System.out.println();
        show(b);
    }
    public static void match(int[] n,int[] b,int left,int right){
        if (left == right || left >= n.length || right >= n.length) {
            return;
        }
        int key = n[left];
        int i = left;
        int j = right;
        while(i<j){
            while(i<j&&b[j]>key){
                j--;
            }
            while(i<j&&b[i]<key){
                i++;
            }
            if(i!=j){
                change(b,i,j);
            }
        }
        change(b,i,left);

        key = b[left+1];
        i = left+1;
        j = right;
        while(i<j){
            while(i<j&&n[j]>key){
                j--;
            }
            while(i<j&&n[i]<key){
                i++;
            }
            if(i!=j){
                change(n,i,j);
            }
        }
        change(n,i,left+1);

        match(n,b,left+2,i);
        match(n,b,i+1,right);
    }
    public static void change(int[] b,int i,int j){
        int temp = b[i];
        b[i] = b[j];
        b[j] = temp;
    }
    public static void show(int[] a){
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
