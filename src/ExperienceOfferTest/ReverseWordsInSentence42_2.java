package ExperienceOfferTest;

public class ReverseWordsInSentence42_2 {
    public static void main(String[] args) {
        ReverseWordsInSentence42_2 test = new ReverseWordsInSentence42_2();
        System.out.println(test.LeftRotateString("abcdefg",3));
    }
    public String LeftRotateString(String str,int n) {
        if (n == 0){
            return str;
        }
        if (str.length() == 0 || str == null){
            return new String();
        }
        char[] arr = str.toCharArray();
        Reverse(arr,0,n-1);
        Reverse(arr,n,arr.length-1);
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
