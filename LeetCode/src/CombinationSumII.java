import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0||candidates==null) return null;
        List<List<Integer>> list = new ArrayList<>();
        sort(candidates,0,candidates.length-1);
        backtrack(list,new ArrayList<>(),candidates,target,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List arrayList, int[] nums, int target, int n) {
        if(target<0) return;
        if(target==0){
            list.add(new ArrayList<>(arrayList));
            return;
        }
        for(int i=n;i<nums.length;i++){
            int value=target-nums[i];
            arrayList.add(nums[i]);
            backtrack(list, arrayList, nums, value, i+1);
            arrayList.remove(arrayList.size()-1);
            while(i<nums.length-1&&nums[i]==nums[i+1]) i++;
        }
    }
    public void sort(int[] a,int lo,int hi){
        if(hi<=lo) return ;
        int lt=lo,i=lo+1,gt=hi;
        int v=a[lt];
        while(i<=gt){
            if(a[i]>v) exch(a,i,gt--);
            else if(a[i]<v) exch(a,lt++,i++);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private void exch(int[] a, int i, int j) {
        int k=a[i];
        a[i]=a[j];
        a[j]=k;
    }
}
