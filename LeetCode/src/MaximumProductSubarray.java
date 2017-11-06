public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int max=nums[0];
        int min=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){//如果为负数最大的就是最小的，最小的就是最大的
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(nums[i],max*nums[i]);//
            min=Math.min(nums[i],min*nums[i]);//
            res=Math.max(res,max);
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums=new int[]{
                -4,-3,-2
        };
        int res=new MaximumProductSubarray().maxProduct(nums);
        System.out.println("res="+res);
    }
}
