import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tang on 2017/9/4.
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            int lo=0,hi=0,sum=0;
            if(i==0||(i > 0 && nums[i] != nums[i-1])) {
                lo = i + 1;
                hi = nums.length - 1;
                sum = 0 - nums[i];
            }else{
                continue;
            }
            if (nums[i] > 0)
                return result;
            while (lo<hi) {
                if (nums[hi] + nums[lo] == sum) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo<hi&&nums[lo]==nums[lo+1]) lo++;
                    while (lo<hi&&nums[hi]==nums[hi-1]) hi--;
                    lo++;
                    hi--;
                } else if (nums[hi] + nums[lo]> sum) hi--;
                else lo++;
            }
        }
        return result;
    }
}
