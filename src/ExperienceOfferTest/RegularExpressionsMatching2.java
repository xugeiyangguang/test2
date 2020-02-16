package ExperienceOfferTest;

public class RegularExpressionsMatching2 {
    public static void main(String[] args) {
        RegularExpressionsMatching2 test = new RegularExpressionsMatching2();
        char[] str = {};
        char[] pattern = {'.','*'};
        System.out.println(test.match(str,pattern));
    }
    public boolean match(char[] str, char[] pattern){
        if (str==null||pattern==null){
            return false;
        }
        return matchCore(str,0,pattern,0);
    }
    public boolean matchCore(char[] str,int i, char[] pattern,int j){
        if (i == str.length&&j==pattern.length){
            return true;
        }
        if (i!=str.length&&j==pattern.length){
            return false;
        }
        if (j<pattern.length-1&&pattern[j+1] == '*'){
            if (i<str.length&&pattern[j]==str[i]||pattern[j]=='.'&&i<str.length){
                return matchCore(str,i+1,pattern,j+2)
                        ||matchCore(str,i+1,pattern,j)
                        ||matchCore(str,i,pattern,j+2);
            }else {
                return matchCore(str,i,pattern,j+2);
            }
        }
        if (i<str.length&&pattern[j]==str[i]||pattern[j]=='.'&&i<str.length){
            return matchCore(str,i+1,pattern,j+1);
        }
        return false;
    }
}
