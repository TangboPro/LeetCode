import com.sun.prism.shader.FillRoundRect_Color_AlphaTest_Loader;

import java.util.*;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0) return new ArrayList<>();
        sort(intervals,0,intervals.size()-1);
        ArrayList<Interval> lists=new ArrayList<>();
        Interval interval=new Interval(intervals.get(0).start,intervals.get(0).end);
        for(int i=1;i<intervals.size();i++){
            Interval key=intervals.get(i);
            if(interval.end>=key.start){
                interval.end=Math.max(interval.end,key.end);
            }else{
                lists.add(interval);
                interval=new Interval(key.start,key.end);
            }
        }
        lists.add(interval);
        return lists;
    }

    //三向切分快速排序
    private void sort(List<Interval> lists,int lo,int hi) {
        //intervals.sort((a,b)->Integer.compare(a.start,b.start));

        int lt=lo,i=lo+1,gt=hi;
        Interval key=lists.get(lo);
        while(i<=gt){
            Interval currt=lists.get(i);
            int cmp=compartor(currt,key);
            if(cmp<0) exch(lists,lt++,i++);
            else if(cmp>0) exch(lists,i,gt--);
            else i++;
        }
        sort(lists,lo,lt-1);
        sort(lists,gt+1,hi);
    }

    private void exch(List<Interval> lists, int i, int j) {
        Interval lo=lists.remove(i);
        Interval hi=lists.remove(j);
        lists.add(i,hi);
        lists.add(j,lo);
    }

    private int compartor(Interval r,Interval s){
        if(r.start<s.start) return 1;
        if(r.start>s.start) return -1;
        return 0;
    }
    public static void main(String[] args){
        LinkedList<Interval> lists=new LinkedList<>();
        for(int i=10;i>0;i++){
            Interval val=new Interval(i,i);
            lists.add(val);
        }
        new MergeIntervals().merge(lists);
    }
}
