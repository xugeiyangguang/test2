package ExperienceOfferTest;

public class ArrayConstruction {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        ArrayConstruction test = new ArrayConstruction();
        int[] b = test.multiply(a);
        if (b!=null){
            for (int i:b
                 ) {
                System.out.print(i+" ");
            }
        }
    }
    public int[] multiply(int[] A) {
        if (A==null||A.length==0){
            return null;
        }
        int[] b = new int[A.length];
        b[0]=1;
        for (int i=1;i<A.length;i++){
            b[i] = b[i-1]*A[i-1];
        }
        int temp = 1;
        for (int i=A.length-2;i>=0;i--){
            temp *= A[i+1];
            b[i] *= temp;
        }
        /*int[] c = new int[使用value对hashMap排序.length];
        c[0] = 1;
        int[] d = new int[使用value对hashMap排序.length];
        d[d.length-1] = 1;
        for (int i=1;i<使用value对hashMap排序.length;i++){
            c[i] = c[i-1]*使用value对hashMap排序[i-1];
        }
        for (int i=使用value对hashMap排序.length-2;i>=0;i--){
            d[i] = d[i+1]*使用value对hashMap排序[i+1];
        }
        int[] b = new int[使用value对hashMap排序.length];
        for (int i=0;i<使用value对hashMap排序.length;i++){
            b[i] = c[i]*d[i];
        }*/
        return b;
    }
}
