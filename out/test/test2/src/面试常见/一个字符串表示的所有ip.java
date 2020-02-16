package 面试常见;
import java.util.ArrayDeque;
import java.util.ArrayList;
/*深度搜索*/
public class 一个字符串表示的所有ip {
    public static void main(String[] args) {
        String s = "255255255255";
        ArrayList<String> re = new ArrayList<>();
        re = restoreIpAddresses(s);
        for (String i:re
             ) {
            System.out.println(i);
        }
    }
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> re = new ArrayList<>();
        ArrayList<String> ip = new ArrayList<>();  //存放中间结果
        dfs(s, re, ip, 0);
        return re;
    }

    private static void dfs(String s, ArrayList<String> re, ArrayList<String> ip, int start){
        if(ip.size() == 4 && start == s.length()){  //找到一个合法解
            re.add(ip.get(0) + '.' + ip.get(1) + '.' + ip.get(2) + '.' + ip.get(3));
            return;
        }
        //减枝，剩下的字符串长度大于了所需的IP的长度
        if(s.length() - start > 3 * (4 - ip.size()))  //剪枝
            return;
        //减枝，剩下的字符串长度小于了所需的IP的长度
        if(s.length() - start < (4 - ip.size()))  //剪枝
            return;
        int num = 0;
        for(int i = start; i < start + 3 && i < s.length(); i++){
            num = num * 10 + (s.charAt(i) - '0');
            if(num < 0 || num > 255)  //剪枝
                continue;

            ip.add(s.substring(start, i + 1));
            dfs(s, re, ip, i + 1);
            ip.remove(ip.size() - 1);

            //经过前面的深度搜索，该num不能单独作为一段，那么如果是0就要被当成前缀了
            if(num == 0)  //不允许前缀0
                break;
        }
    }
}


