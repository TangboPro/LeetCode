import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        Map<Character,Integer> hashMap=new HashMap<Character, Integer>();
        int k=0;
        for(int i=0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                k=Math.max(k,hashMap.get(s.charAt(i))+1);
            }
            hashMap.put(s.charAt(i),i);
            max=Math.max(max,i-k+1);
        }
        return max;
    }
}
