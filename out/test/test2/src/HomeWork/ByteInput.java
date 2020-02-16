package HomeWork;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*public class ByteInput {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(str.charAt(0));
    }

}*/

/**
 * 编程：编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如“我 ABC”4，应该截为“我 AB”，
 * 输入“我 ABC 汉 DEF”，6，应该输出为“我ABC”而不是“我 ABC+汉的半个”。
 */
class SplitString
{
    String SplitStr;
    int SplitByte;
    public SplitString(String str,int bytes)
    {
        SplitStr=str;
        SplitByte=bytes;
        System.out.println("The String is:′"+SplitStr+"′;SplitBytes="+SplitByte);
    }
    public void SplitIt()
    {
        int loopCount;
        loopCount=(SplitStr.length()%SplitByte==0)?(SplitStr.length()/SplitByte):(SplitStr.length()/SplitByte+1);
        System.out.println("Will Split into "+loopCount);
        for (int i=1;i<=loopCount ;i++)
        {
            if (i==loopCount){
                System.out.println(SplitStr.substring((i-1)*SplitByte,SplitStr.length()));
            }
            else
            {
                System.out.println(SplitStr.substring((i-1)*SplitByte,(i*SplitByte)));
            }
        }
    }
    public static void main(String[] args)
    {
        /*SplitString ss = new SplitString("test 中 dd 文 dsaf 中男大 3443n 中国 43 中国人 0ewldfls=103",4);
        ss.SplitIt();*/
        SplitString s = new SplitString("我ABC汉DEF", 6);
        s.SplitIt();
    }
}

