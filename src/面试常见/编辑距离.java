package 面试常见;

public class 编辑距离 {
    public static void main(String[] args) {
        int re = minDistance("a", "ab");
        System.out.println(re);

    }
    public static int minDistance(String word1, String word2) {
        if(word1==null&&word2==null){
            return 0;
        }
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word2.length()+1;i++){
            dp[0][i]=i;
        }
        for(int j=0;j<word1.length()+1;j++){
            dp[j][0]=j;
        }
        for(int i=1;i<=word2.length();i++){
            for(int j=1;j<=word1.length();j++){
                if(word2.charAt(i-1)==word1.charAt(j-1)){
                    dp[j][i] = dp[j-1][i-1];
                }else{
                    int tmp = Math.min(dp[j-1][i],dp[j][i-1]);
                    dp[j][i] = Math.min(dp[j-1][i-1],tmp)+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
