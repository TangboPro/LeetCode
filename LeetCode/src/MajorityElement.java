//https://leetcode.com/problems/majority-element/discuss/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int major=nums[0],length=1;
        for(int i=1;i<nums.length;i++){
            if(length==0){//因为超过过半所以length值至少为1
                major=nums[i];
                length++;
            }else if(major==nums[i])
                length++;
            else length--;
        }
        return major;
    }
}
