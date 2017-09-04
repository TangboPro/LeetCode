/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/trapping-rain-water/description/
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height==null||height.length==0) return 0;
        int l=0,r=height.length-1;
        int right_max=0;
        int left_max=0;
        int currentheigth=0;
        int bstValue=0;
        while(l<r){
            // int value=Math.min(height[l],height[r])*(r-l-1);
            // if(value>bstValue){
            //     bstValue=value+bstValue-(r-l)*currentheigth;
            //     currentheigth=Math.min(height[l],height[r]);
            // }else{
            //     bstValue=bstValue-Math.min(currentheigth,Math.min(height[l],height[r]));
            // }
            if(height[l]>height[r]){
                if(height[r]>=left_max){
                    left_max = height[r];
                }else {
                    bstValue+=(left_max - height[r]);
                }
                r--;
            }else{
                if(height[l]>right_max){
                    right_max=height[l];
                }else{
                    bstValue+=(right_max-height[l]);
                }
                l++;
            }
        }
        return bstValue;
    }
}
