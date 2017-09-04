import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int left, int right, int n){
        if(str.length()==(n*2)){
            list.add(str);
            return;
        }
        if(left<n){
            backtrack(list,str+"(",left+1,right,n);
        }
        if(right<left){
            backtrack(list,str+")",left,right+1,n);
        }
    }
}
