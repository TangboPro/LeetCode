/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder zigZagString=new StringBuilder();
        if(numRows==1||numRows==0) return s;
        for(int i=0;i<numRows;i++) {
            for (int index = i, multiple = i; index < s.length(); index = index + (multiple) * 2) {
                zigZagString.append(s.charAt(index));
                if(i==0||i==numRows-1){
                    multiple=numRows-1;
                }else{
                    multiple = (numRows - 1) - multiple;
                }
            }
        }
        return zigZagString.toString();
    }
}
