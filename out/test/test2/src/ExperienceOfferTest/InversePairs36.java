package ExperienceOfferTest;

public class InversePairs36 {
    public static void main(String[] args){
        InversePairs36 test = new InversePairs36();
        int[] array = {7,5,4,6};
        System.out.println(test.InversePairs(array));
    }
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0){
            return -1;
        }
//        int[] copy = array;  这样是指向同一个对象，两个值会同时改变
        int[] copy = new int[array.length];
        int j =0;
        for (int i:array
             ) {
            copy[j++] = i;
        }
        return InversePairsCore(array,copy,0,array.length-1);

    }
    public int InversePairsCore(int[] data,int[] copy,int start,int end){
        if (start == end){
            copy[start] = data[start];
            return 0;
        }
        int mid = (end + start)/2;
        //改变了传入数组参数的顺序
        int left = InversePairsCore(copy,data,start,mid);
        int right = InversePairsCore(copy,data,mid+1,end);
        int i = mid;
        int j = end;
        int copyIndex = end;
        int count = 0;
        while (i>=start&&j>mid){
            if (data[i] > data[j]){
                copy[copyIndex--] = data[i--];
                count+=j-mid;
                count = count%1000000007;
            }else {
                copy[copyIndex--] = data[j--];
            }
        }
        while (i>=start){
            copy[copyIndex--] = data[i--];
        }
        while (j>mid){
            copy[copyIndex--] = data[j--];
        }
        return (left+right+count)%1000000007;
    }
}
