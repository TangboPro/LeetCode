/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
    int maxLength = 0;
    int left=0;
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        for(int i=0;i<s.length()-1;i++){
            findMax(s,i,i);
            findMax(s,i,i+1);
        }

        return s.substring(left,left+maxLength);
    }

    private  void findMax(String s, int i, int j) {
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(maxLength<j-i-1){
            maxLength=j-i-1;
            left=i+1;
        }
    }
}
