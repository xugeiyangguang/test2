package HomeWork;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        /*
        File file = new File("D:\\xuyangtest");
        System.out.println(file.getName());
        System.out.println("该对象的路径" + file.getPath());
        System.out.println("该对象的绝对路径" + file.getAbsoluteFile());
        System.out.println("该对象的绝对路径名" + file.getAbsolutePath());
        System.out.println("该对象对应目录的父目录名" + file.getParent());
      //  System.out.println("重命名结果："+file.renameTo(new File("D:\\xuyangtest1")));
        File temp = File.createTempFile("aaa", ".txt", file);
        System.out.println("aaa文件是否存在：" + temp.exists());
        File newFile = new File("D:\\xuyangtest\\createNewFile");
        File newFile1 = new File("D:\\xuyangtest\\mkdirr");
        //在xuyangtest下建立文件
        System.out.println("在xuyangtest下建立目录" + newFile1.mkdir());
        System.out.println("在xuyangtest下建立文件" + newFile.createNewFile());
        String[] dir = file.list();
        for (String i:dir
             ) {
            System.out.println(i);
        }
        System.out.println("当前路径下所有的文件和路劲如下=======================");
        File[] filelist = file.listFiles();
        for (File i:filelist
             ) {
            System.out.println(i);
        }
        System.out.println("所有磁盘的根路径=======================");
        File[] root = File.listRoots();
        for (File i:root
             ) {
            System.out.println(i);

        }
        System.out.println("文件过滤=======================");
        File[] str = file.listFiles((dir1, name) -> new File(name).isDirectory());
        for (File i:str
        ) {
            System.out.println(i);
        }
        */

        File testFile = new File("D:\\xuyangtest");
        File[] listTestFile = testFile.listFiles();
        File test1 = new File("D:\\xuyangtest\\mkdirr");
        System.out.println("=====" + test1.isDirectory());
        File[] nameList = testFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (new File(name).isDirectory() || name.endsWith(".java")) {
                    return true;
                }
                return false;
            }
        });
        for (File i:nameList
        ) {
            System.out.println(i);
        }
        System.out.println("================");
        for (File i:listTestFile
             ) {
            if (i.isDirectory()) {
                System.out.println(i);
            }
        }
    }
}
