import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tang on 2017/9/5.
 * https://leetcode.com/articles/coin-path/#approach-1-brute-forcetime-limit-exceeded
 */
public class CoinPath {

    //dp
    public List < Integer > cheapestJumpEx(int[] A, int B) {
        int[] next = new int[A.length];
        long[] dp = new long[A.length];
        Arrays.fill(next, -1);
        List < Integer > res = new ArrayList();
        for (int i = A.length - 2; i >= 0; i--) {
            long min_cost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + B && j < A.length; j++) {
                if (A[j] >= 0) {
                    long cost = A[i] + dp[j];
                    if (cost < min_cost) {
                        min_cost = cost;
                        next[i] = j;
                    }
                }
            }
            dp[i] = min_cost;
        }

        int i;
        for (i = 0; i < A.length && next[i] > 0; i = next[i])
            res.add(i + 1);
        if (i == A.length - 1 && A[i] >= 0)
            res.add(A.length);
        else
            return new ArrayList <> ();
        return res;
    }

    public List< Integer > cheapestJump(int[] A, int B) {
        int[] next = new int[A.length];
        Arrays.fill(next, -1);
        jump(A, B, 0, next,new long[A.length]);
        List < Integer > res = new ArrayList();
        int i;
        for (i = 0; i < A.length && next[i] > 0; i = next[i])
            res.add(i + 1);
        if (i == A.length - 1 && A[i]>= 0)
            res.add(A.length);
        else
            return new ArrayList <> ();
        return res;
    }
    public long jump(int[] A, int B, int i, int[] next,long[] memo) {
        if (memo[i] > 0)
            return memo[i];
        if (i == A.length - 1 && A[i] >= 0)
            return A[i];
        long min_cost = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + B && j < A.length; j++) {
            if (A[j] >= 0) {
                long cost = A[i] + jump(A, B, j, next,memo);
                if (cost < min_cost) {
                    min_cost = cost;
                    next[i] = j;
                }
            }
        }
        memo[i] = min_cost;//有大量重复操作，保存到达该路径的最少花费可以减少大量重复操作
        return min_cost;
    }
    public static void main(String[] args){
        int[] test=new int[]{
                1,2,4,-1,2
        };
        System.out.print(new CoinPath().cheapestJumpEx(test,2));
    }
}
