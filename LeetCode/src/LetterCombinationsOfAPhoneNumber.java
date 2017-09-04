import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new LinkedList<>();
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("");
        for(int i=0;i<digits.length();i++){
            int x=Character.getNumericValue(digits.charAt(i));
            while (linkedList.peek().length()==i){
                String t = linkedList.remove();
                for(char s : mapping[x].toCharArray())
                    linkedList.add(t+s);
            }
        }
        return  linkedList;
    }
}
