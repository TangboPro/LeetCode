import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tang on 2017/9/4.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0) return null;
        List<List<Integer>> tempList=new ArrayList<>();
        dfs(tempList,new ArrayList<>(),nums);
        return tempList;
    }
    public void dfs(List<List<Integer>> tempList,List<Integer> mList,int[] nums){
        int end=nums.length;
        if(mList.size()>=end) {
            tempList.add(new ArrayList<>(mList));
            return;
        }
        for(int start=0;start<end;start++) {
            if(mList.contains(nums[start])) continue;
            mList.add(nums[start]);
            dfs(tempList, mList, nums);
            mList.remove(mList.size()-1);
        }
    }
}
