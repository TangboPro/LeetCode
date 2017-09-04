/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
        // Stack<Integer> stack=new Stack<>();
        // int max=0;
        // stack.push(-1);
        // for(int i=0;i<s.length();i++) {
        //     if(s.charAt(i)=='(') {
        //         stack.push(i);
        //     }
        //     else {
        //         stack.pop();
        //         if (stack.empty()) {
        //             stack.push(i);
        //         } else {
        //             max = Math.max(max, i - stack.peek());
        //         }
        //     }
        // }
        // return max;
    }
}
