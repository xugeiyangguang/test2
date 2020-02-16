package 测试;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Threee {
    public static ArrayList<ArrayList<String>> gettestcase() {
        ArrayList<ArrayList<String>> retval = new ArrayList<ArrayList<String>>();

        BufferedReader br;
        try {
            //在这修改原数据的路径
            Reader reader = new FileReader("C:\\Users\\27124\\Desktop\\原数据.txt");
            br = new BufferedReader(reader);
            String line;
            while (null != (line = br.readLine())) {
                ArrayList<String> strings = new ArrayList<>();
                String[] ss = line.split(" ");
                for (String s : ss) {
                    strings.add(s);
                }
                retval.add(strings);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retval;
    }

    public static void main(String[] args) {
        gettestcase();
    }
}
