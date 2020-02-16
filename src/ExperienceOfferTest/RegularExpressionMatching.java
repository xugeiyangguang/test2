package ExperienceOfferTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatching {
    int i = 0;
    public static void main(String[] args) {
        RegularExpressionMatching test = new RegularExpressionMatching();
        char[] str = {'2','1','E'};
        System.out.println(test.isNumeric(str));
    }
    public boolean isNumeric(char[] str) {
        String str2 = String.valueOf(str);
        String regx = "[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str2);
        return matcher.matches();
    }
    /*public boolean isNumeric(char[] str) {
        if (str==null|str.length==0){
            return false;
        }
        if (str[i]=='+'||str[i]=='-'){
            i++;
        }
        if (i==str.length){
            return false;
        }else {
            if (str[i]<'9'||str[i]>'0'){
                scanDigit(str);
                if (i==str.length){
                    return true;
                }
                if (str[i]=='.'){
                    i++;
                    scanDigit(str);
                }
                if (i==str.length){
                    return true;
                }
                if (str[i]=='e'||str[i]=='E'){
                   i++;
                    if (str[i]=='+'||str[i]=='-'){
                        i++;
                    }
                    if (i==str.length){
                        return false;
                    }
                    scanDigit(str);
                    if (i==str.length){
                        return true;
                    }
                    if (str[i]=='.'){
                        i++;
                        scanDigit(str);
                        if (i==str.length){
                            return true;
                        }else{
                            return false;
                        }
                    }
                    if (i==str.length){
                        return true;
                    }else{
                        return false;
                    }
                }else {
                    if (i==str.length){
                        return true;
                    }else{
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
    }
    public void scanDigit(char[] str){
        while (i<str.length&&str[i]<='9'&&str[i]>='0'){
            i++;
        }
    }*/
}
