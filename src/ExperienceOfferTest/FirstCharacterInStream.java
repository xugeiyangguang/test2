package ExperienceOfferTest;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstCharacterInStream {
    public static void main(String[] args) {
        FirstCharacterInStream test = new FirstCharacterInStream();

    }
    HashMap<Character,Integer> hashMap = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        //如果已经存在该字符，就把他value改为-1
        if (hashMap.containsKey(ch)){
            hashMap.put(ch,hashMap.get(ch)+1);
        }else {   //如果不存在，就把他放入表中
            hashMap.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (char ch:hashMap.keySet()
             ) {
            if (hashMap.get(ch)==1){
                return  ch;
            }
        }
        return '#';
    }

}
