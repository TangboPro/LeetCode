/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int lo=0,hi=nums.length-1,length=nums.length;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }
        int rot=lo;
        lo=0;hi=length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int rotmid=(mid+rot)%length;
            if(nums[rotmid]==target) return rotmid;
            if(nums[rotmid]<target) lo=mid+1;
            else hi = mid - 1;
        }
        return -1;
    }
}
