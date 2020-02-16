package HomeWork;

import java.io.*;

public class FileReaderTest {
    public static void main(String[] args) {
        /*try (
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                FileReader reader = new FileReader("D:\\xuyangtest\\today.txt");
                FileWriter writer = new FileWriter("D:\\xuyangtest\\output.txt")
        ) {
            char[] buff = new char[32];
            int hasRead = 0;
            String line = null;
            while ((line = input.readLine()) != null) {
                if (line.equals("end")) {
                    System.exit(1);
                } else {
                    writer.write(line);
                    System.out.println(line);
                }
            }
            writer.write("this is a test");
            *//*while ((hasRead = input.read(buff)) > 0) {
                writer.write(buff, 0, hasRead);
            }*//*

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                FileWriter writer = new FileWriter("D:\\xuyangtest\\output4.txt",true))
        {
            //System.setOut(writer1); //使用重定向的方式将键盘内容输入到文件中
            String line = null;
            while ((line = input.readLine()) != null) {
                if (line.equals("end")) {
                    System.exit(1);
                } else {
                    writer.write(line);
                    System.out.println(line);
                    writer.flush();//输出的内容存在了缓冲区里面
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
