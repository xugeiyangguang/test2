package HomeWork;

public class BreakArr {
    public static void main(String[] args) {
        String s = "A1B2C3D4E5F6G7H8";
        int[] digit = new int[s.length()];
        int m = 0;
        String[] strings = new String[s.length()];
        int n = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A'){
                strings[n++] = String.valueOf(s.charAt(i));
            }else {
                digit[m++] = Integer.valueOf(s.charAt(i)-'0');
            }
        }
        for (int i: digit
             ) {
            System.out.print(i);
        }
        System.out.println();
        for (String sr:strings
             ) {
            System.out.print(sr);
        }
    }
}
