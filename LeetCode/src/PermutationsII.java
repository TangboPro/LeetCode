import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null||nums.length==0) return null;
        List<List<Integer>> tempList=new ArrayList<>();
        Arrays.sort(nums);
        dfs(tempList,new ArrayList<>(),new boolean[nums.length],nums);
        return tempList;
    }
    public void dfs(List<List<Integer>> tempList,List<Integer> mList, boolean[] used,int[] nums){
        int end=nums.length;
        if(mList.size()>=end) {
            tempList.add(new ArrayList<>(mList));
            return;
        }
        for(int start=0;start<end;start++) {
            if(used[start]) continue;
            if(start>0 &&nums[start-1]==nums[start] && !used[start-1]) continue;
            mList.add(nums[start]);
            used[start]=true;
            dfs(tempList, mList,used, nums);
            used[start]=false;
            mList.remove(mList.size()-1);
        }
    }
}
