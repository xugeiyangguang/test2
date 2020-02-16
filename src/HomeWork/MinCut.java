package HomeWork;

import java.util.ArrayList;

public class MinCut {
    public static void main(String[] args) {
        MinCut test = new MinCut();
        int re = test.minCut("aab");
        System.out.println();
    }
    public int minCut(String s) {
        ArrayList<ArrayList<String>> result = partition(s);
        int re = 0x7fff;
        for (ArrayList<String> list:result
             ) {
            re = Math.min(re, list.size()-1);
        }
        return re;
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
