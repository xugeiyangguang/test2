package ExperienceOfferTest;

public class Solution2 {
    public static void main(String[] args){
        StringBuffer str=new StringBuffer("we are happy.");
        String r=replaceSpace(str);
        System.out.println(r);
    }
    public static String replaceSpace(StringBuffer str) {
        int count = 0;
        /*在字符串中，取某下标的字符，不是用a[i]数组的形式，要用chatAt()*/
        for(int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                count++;
            }
        }
        int len=str.length(); /*保留原来的长度*/
        int j=str.length()+count*2;
        str.setLength(j);
        for(int i=len-1;i>=0;i--){
            j--;
            if(str.charAt(i)!=' '){
                str.setCharAt(j,str.charAt(i));
            }
            else{
                str.setCharAt(j,'0');
                str.setCharAt(j-1,'2');
                str.setCharAt(j-2,'%');
                j-=2;
            }
        }
        /*输入是StringBuffer类型，输出是String类型，要进行转换*/
        /*用replace可以直接对String 进行特定字符的新旧替换，但是不能对StingBuffer替换
        ，名字相同，作用参数不同*/
        return str.toString().replace("%","!");
    }
}