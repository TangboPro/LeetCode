/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/search-for-a-range/description/
 */
public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null)
            return null;
        if (nums.length == 0)
            return new int[]{-1, -1};
        int lo = 0, hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) break;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        if (lo > hi) return new int[]{-1, -1};
        lo = mid;
        hi = mid;
        while (lo >= 0 && target == nums[lo]) --lo;
        while (hi < nums.length && target == nums[hi]) ++hi;
        return new int[]{lo + 1, hi - 1};
    }
}
