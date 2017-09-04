import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap=new HashMap<Integer, Integer>();
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            numMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++)
        {
            int k=target-nums[i];
            if(numMap.containsKey(k)&&numMap.get(k)!=i){
                if(numMap.get(k)>i) {
                    result[0] = i;
                    result[1] = numMap.get(k);
                }else{
                    result[1] = i;
                    result[0] = numMap.get(k);
                }
                break;
            }
        }
        return result;
    }
}
