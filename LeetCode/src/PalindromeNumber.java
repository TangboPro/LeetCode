/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int sum=0;
        int arr=x;
        while(x!=0){
            sum=sum*10+x%10;
            if(sum>=Integer.MAX_VALUE){
                return false;
            }
            x=x/10;
        }

        if(sum==arr) return true;
        return false;
    }
}
