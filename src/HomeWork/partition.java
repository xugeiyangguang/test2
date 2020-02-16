package HomeWork;

import java.util.ArrayList;
/*
采用动态规划的方法，先求满足前面的子序列，再对后面的子序列递归
并采用了一个栈来保存中途的状态，
 */
public class partition {
    public static void main(String[] args) {
        partition test = new partition();
        ArrayList<ArrayList<String>> result = test.partition("bbbb");
        System.out.println();
        String a= "012345";
        //substring的长度可以刚好等于数组的长度，不会越界
        System.out.println(a.substring(0,6));
        System.out.println(a.substring(6));
    }
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        partitionCore(s, list);
        return result;
    }

    public void partitionCore(String s, ArrayList<String> list) {
        if (s.equals("")) {
            ArrayList<String> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        for (int i = 1;i <= s.length(); ) {
            /*if (i == s.length() && isIllegal(s)) {
                list.add(s);
                ArrayList<String> temp = new ArrayList<>(list);
                result.add(temp);
                list.remove(list.size() - 1);
                return;
            }*/
            if (isIllegal(s.substring(0, i))) {
                list.add(s.substring(0, i));
                partitionCore(s.substring(i), list);
                list.remove(list.size() - 1);
            }
            i++;
        }
    }

    public boolean isIllegal(String s) {
        StringBuffer temp = new StringBuffer(s);
        temp.reverse();
        return s.equals(temp.toString());
    }
}
