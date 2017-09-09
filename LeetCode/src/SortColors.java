/**
 * Created by Tang on 2017/9/8.
 * https://leetcode.com/problems/sort-colors/description/
 * 计数排序
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] A=new int[3];
        for(int val:nums)
            A[val]++;

        int k=0;
        for(int i=0;i<A.length;i++) {
            while (A[i]-->0) nums[k++]=i;
        }
    }
    public static void main(String[] args){
        int[] test=new int[]{
                0,2,0,2,1,1
        };
        new SortColors().sortColors(test);
        for(int val:test)
            System.out.print(val);
    }
}
