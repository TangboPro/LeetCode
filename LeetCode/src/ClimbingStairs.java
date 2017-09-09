/**
 * Created by Tang on 2017/9/5.
 * https://leetcode.com/problems/climbing-stairs/description/
 * 斐波那契数列
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int first=1,end=2;
        int result=0;
        for(int i=2;i<n;i++){
            int k=end;
            end=first+end;
            first=k;
            result=first;
        }
        return result;
    }

}
