/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger {
    public int reverse(int x) {
        long result=0;
        while(x!=0){
            result=result*10+x%10;
            x=x/10;
            if((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE))
                return 0;
        }
        return (int)result;
    }
}
