package Leetcode;

import java.util.ArrayList;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        ArrayList<String> re = new RestoreIpAddresses().restoreIpAddresses("010010");
        System.out.println();
    }
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> temp = new ArrayList<>();
        restoreIpAddressesCore(s, 0, temp);
        return re;
    }
    ArrayList<String> re = new ArrayList<>();
    public void restoreIpAddressesCore(String s,int index,ArrayList<String> temp) {
        if (index >= 4 && s.length() != 0 || s.length() > 3 * (4 - index)) {

            return;
        }
        if (index == 4 && s.length() == 0) {
            StringBuffer str = new StringBuffer();
            for (String i: temp
                 ) {
                if (!i.equals("0") && i.charAt(0) == '0') {
                    return;
                }
                str.append(i);
                str.append(".");
            }
            str.delete(str.length() - 1, str.length());
            re.add(str.toString());
            return;
        }

        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (Integer.valueOf(s.substring(0, i)) <= 255) {
                temp.add(s.substring(0, i));
                restoreIpAddressesCore(s.substring(i), index + 1, temp);
                temp.remove(temp.lastIndexOf(s.substring(0, i)));
            }

        }
    }
}
