/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // if(nums.length==0) return 0;
        // int result=nums[0],max=0;
        // int index=0;
        // while(index<nums.length){
        //     if(nums[index]>=0) break;
        //     if(nums[index]<0&&result<nums[index]) result=nums[index];
        //     index++;
        // }
        // while(index<nums.length){
        //     if(max+nums[index]>0)
        //         max=max+nums[index];
        //     else max=0;
        //     if(max>result) result=max;
        //     index++;
        // }
        // return result;
        if(nums==null||nums.length==0) return 0;
        int maxSoFar = nums[0];
        int maxEnd = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(maxEnd + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEnd);
        }
        return maxSoFar;
    }
}
