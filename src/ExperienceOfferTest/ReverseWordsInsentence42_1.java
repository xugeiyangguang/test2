package ExperienceOfferTest;

public class ReverseWordsInsentence42_1 {
    public static void main(String[] args) {
        ReverseWordsInsentence42_1 test = new ReverseWordsInsentence42_1();
        System.out.println(test.ReverseSentence(null));
    }
    public String ReverseSentence(String str) {
        if (str ==null||str.length() == 0){
            return new String();
        }
        char[] arr = str.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i <arr.length;i++){

            if (arr[i]==' '||i == arr.length-1){
                if (i==arr.length-1){
                    end = i;
                }else if (i!=arr.length-1){
                    end = i-1;
                }
                if (arr[start]!=' '){
                    Reverse(arr,start,end);
                    start = i+1;
                }

            }
        }
        Reverse(arr,0,arr.length-1);
        StringBuffer sb = new StringBuffer();
        for (char a:arr
        ) {
            sb.append(a);
        }
        return sb.toString();
    }
    public char[] Reverse(char[] arr,int start,int end){
        char temp;
        int count = 0;
        for (int i = start;i<=(end+start)/2;i++){
            temp = arr[i];
            arr[i] = arr[end-count];
            arr[end-count] = temp;
            count++;
        }

        return arr;
    }
}
