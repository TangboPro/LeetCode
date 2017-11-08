//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int a=0,b=0;
        for(int i=0;i<nums.length;i++){
            int temp=b;
            b=Math.max(a,b);
            a=nums[i]+temp;
        }
        return Math.max(a,b);
        /*
        for(int i=0;i<nums.length;i++){
            //
            if(i%2==0){
                a=Math.max(a+nums[i],b);
            }else{
                b=Math.max(b+nums[i],a);
            }
        }
        return Math.max(a,b);
        */
    }
}
