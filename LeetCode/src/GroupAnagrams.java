import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0) return null;

        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String sortStr=stringSort(strs[i]);
            if(map.containsKey(sortStr)){
                map.get(sortStr).add(strs[i]);
            }else{
                LinkedList list=new LinkedList();
                list.add(strs[i]);
                map.put(sortStr,list);
            }
        }
        LinkedList resultList=new LinkedList();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            resultList.add(entry.getValue());
        }
        return resultList;
    }
    //地位优先的字符串排序
    private String stringSort(String str) {
        int R=26;//24个小写字母排序
        char[] chars=str.toCharArray();
        char[] aux=new char[chars.length];
        //Arrays.sort(chars);
        int[] count=new int[R+1];
        for(int i=0;i<chars.length;i++)//计算频率
            count[chars[i]-'a'+1]++;
        for(int r=0;r<R;r++)//频率转换为索引
            count[r+1]+=count[r];
        for(int i=0;i<chars.length;i++)
            aux[count[chars[i]-'a']++]=chars[i];
        return new String(aux);
    }
}
