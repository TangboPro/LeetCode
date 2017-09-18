import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.*;

/**
 * Created by Tang on 2017/9/
 * https://leetcode.com/problems/edit-distance/description/
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp= new int[m+1][n+1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for(int qw=0;qw<dp.length;qw++){
                    for(int zw=0;zw<dp[qw].length;zw++)
                        System.out.print(dp[qw][zw]);
                    System.out.println();
                }
                System.out.println();
                System.out.println();
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
            }
        }
        return dp[m][n];
    }

    public int minDistanceex(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] cur =new int[m + 1];
        for (int i = 1; i <= m; i++)
            cur[i] = i;
        for (int j = 1; j <= n; j++) {
            int pre = cur[0];
            cur[0] = j;
            for (int i = 1; i <= m; i++) {
                int temp = cur[i];//
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cur[i] = pre;
                else cur[i] = Math.min(pre + 1,Math.min(cur[i] + 1, cur[i - 1] + 1));
                //cur[i]代表dp[i][j - 1],cur[i-1]代表dp[i-1][j],cur[i]未更新所以保存的上一个值，只需要这2个值所以其他值没有什么作用
                pre = temp;
            }
        }
        return cur[m];
    }

    public int myMinDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[] dp=new int[m+1];
        for(int i=1;i<=m;i++){
            dp[i]=i;
        }
        for(int i=1;i<=n;i++){
            int pre =dp[0];//初始dp[i-1][j-1] pre=dp[i-1][j-1]
            dp[0]=i;//dp[j][0]初始为j的值
            for(int j=1;j<=m;j++){
                int temp = dp[j];//下一个dp[i-1][j-1]的值
                if(word2.charAt(i-1)==word1.charAt(j-1)){
                    dp[j]=pre;
                }
                else{
                    dp[j]=Math.min(pre,Math.min(dp[j-1]+1,dp[j]+1));
                    //cur[i]代表dp[i][j - 1],cur[i-1]代表dp[i-1][j],cur[i]未更新所以保存的上一个值，只需要这2个值所以其他值没有什么作用
                }
                pre=temp;//更换dp[i-1][j-1]
            }
        }
        return dp[m];
    }
    static class sf implements Callable{

        @Override
        public String call() throws Exception {
            return "this is call able";
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedHashMap set=new LinkedHashMap<Integer,Integer>();
        //System.out.print(new EditDistance().minDistanceex("a","b"));
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future future=executorService.submit(new sf());
        System.out.print(future.get());
    }
}
