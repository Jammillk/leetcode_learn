package first.dp.bag;

import java.util.List;

public class t139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i]表示0-i的字符串是否可以被拆分成一个或者多个存放在wordDict中的单词
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1;i <= n;i++){
            for(int j = 0;j < i;j++){
                String word = s.substring(j, i);
                if (dp[j] && wordDict.contains(word)){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
