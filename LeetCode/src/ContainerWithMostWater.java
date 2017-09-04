/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int bstValue=Math.min(height[l],height[r])*(r-l);
        while(l<r){
            bstValue=Math.max(bstValue,Math.min(height[l],height[r])*(r-l));
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return bstValue;
    }
}
