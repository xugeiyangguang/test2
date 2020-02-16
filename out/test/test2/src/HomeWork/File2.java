package HomeWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class File2 {
    public static void main(String[] args) throws Exception {
        //实现文件复制
        Files.copy(Paths.get("d:", "xuyangtest", "output.txt"), new FileOutputStream("D:\\xuyangtest\\apple.txt"));
        //一次性读取文件的所有行
        List<String> lines = Files.readAllLines(Paths.get("d:", "xuyangtest", "letter.txt"), Charset.forName("gbk"));
        System.out.println(lines);
        //判断文件的大小
        System.out.println("letter的大小是：" + Files.size(Paths.get("d:", "xuyangtest", "letter.txt")));
        //将多个字符串内容写入指定文件中
        List<String> list = new ArrayList<>();
        list.add("我是新的字符串");
        list.add("我是第二行");
        Files.write(Paths.get("d:", "xuyangtest", "letter1.txt"), list, Charset.forName("gbk"));
        //读取所有的文件和子目录
        Files.list(Paths.get("d:", "xuyangtest")).forEach(path -> {
            if (path.endsWith(".txt")) {
                System.out.println(path);
            }
            System.out.println(path);

        });
        //读取文件的内容
        Files.lines(Paths.get("d:", "xuyangtest", "letter.txt"), Charset.forName("gbk")).forEach(line -> System.out.println(line));
    }
}
