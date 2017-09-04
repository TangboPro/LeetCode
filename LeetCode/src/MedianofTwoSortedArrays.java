/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 题解：
 1、寻找一个中位数将2个数组分成4份
 left_part          |        right_part
 A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
 B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
 2、满足以下条件
 1) len(left_part) == len(right_part)//这一条用于保证左右长度相等，确保是中位
 2) max(left_part) <= min(right_part)//左边的最大，小于右边的最小则可以确认，i,j就是中位数所在的位置

 if(i<m&&B[j-1]>A[i]) imin=i+1; 如果右边的B[j-1]比A[i]要大说明i线还需要向右移动，缩小查找范围
 if(i>0 && A[i-1]>B[j]) 如果A[i-1]>B[j]说明i线需要向左移动
 如果2个条件都满足，外面就将i，j线分好，
 i有三种状态：i=0、i=m、i在0-m之间
 j有三种状态：j=0、j=n、j在0-n之间
 */

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m=A.length,n=B.length;
        if(m>n)
            return findMedianSortedArrays(B,A);
        if(n==0) return 0;
        int imin=0,iMax=m,half_len=(m+n+1)/2;
        while (imin<=iMax){
            int i=(iMax+imin)/2;
            int j=half_len-i;
            if(i<m&&B[j-1]>A[i]) imin=i+1;
            else if(i>0 && A[i-1]>B[j]) iMax=i-1;
            else {
                int max_of_left;
                int min_of_right;
                if (i == 0) max_of_left = B[j - 1];
                else if (j == 0) max_of_left = A[i - 1];
                else max_of_left = Math.max(A[i - 1], B[j - 1]);
                if ((m + n) % 2 == 1) {
                    return max_of_left;
                }
                if(i==m) min_of_right=B[j];
                else if(j==n) min_of_right=A[i];
                else min_of_right=Math.min(A[i],B[j]);
                return (max_of_left+min_of_right)/2.0;
            }
        }
        return 0;
    }
}
