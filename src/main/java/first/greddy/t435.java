package first.greddy;

import java.util.Arrays;
import java.util.Comparator;

public class t435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按区间右侧进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int right = intervals[0][1];
        for(int i = 1;i < intervals.length;i++){
            if (intervals[i][0] > right){
                count++;
                right = intervals[i][1];
            }
        }
        return intervals.length - count;
    }


    public int eraseOverlapIntervals2(int[][] intervals) {
        // 按区间左边界进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                count++;
            } else {
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return intervals.length - count;
    }
}
