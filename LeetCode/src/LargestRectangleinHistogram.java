import java.util.Stack;

/**
 * Created by Tang on 2017/9/13.
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */
public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxValue = 0;
        for(int i=0;i<=len;i++){
            int k=(i==len?0:heights[i]);
            if(s.empty()||k>=heights[s.peek()]){
                s.push(i);
            }else{
                int lo=s.pop();
                maxValue=Math.max(maxValue,heights[lo]*(s.empty()?i:i-1-s.peek()));//i-1取得的是目前最高柱形的位置
                i--;
            }
        }
        return maxValue;
    }

    public static void main(String[] args){
        int[] test=new int[]{
               1,1
        };
        System.out.print(new LargestRectangleinHistogram().largestRectangleArea(test));
    }
}
