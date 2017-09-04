import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s==null||s.length()==0){
            return false;
        }
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        LinkedList<Character> mList=new LinkedList<>();
        mList.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            Character x=s.charAt(i);
            if(x=='('||x=='['||x=='{')
                mList.add(x);
            else{
                if(mList.isEmpty()) return false;
                Character t=mList.removeLast();
                if(map.get(x)!=t){
                    return false;
                }
            }
        }
        if(mList.isEmpty()) return true;
        return false;
    }
}
