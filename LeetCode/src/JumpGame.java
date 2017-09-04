import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {
    private  boolean[] market;//标记
    public  boolean canJump(int[] nums) {

        int resPos=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=resPos){
                resPos=i;
            }
        }
        return resPos==0;
        //market=new boolean[nums.length];
        //exDfs(nums,0);
        //return market[nums.length-1];
    }

    public void exDfs(int[] nums,int s){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        //market[s]=true;
        while(!queue.isEmpty()){
            if(market[nums.length-1]==true){
                return;
            }
            int index=queue.poll();
            if(market[index]){
                continue;
            }
            market[index]=true;
            for(int i=nums[index];i>0;i--) {
                if (i+index<nums.length&&!market[index+i]) {
                    queue.add(index + i);
                }
            }
        }
    }
}
