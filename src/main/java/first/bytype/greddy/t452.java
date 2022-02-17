package first.bytype.greddy;

import java.util.Arrays;
import java.util.Comparator;

public class t452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]){
                // 不相邻，需要一支新的箭
                count++;
            }else {
                // 最小右边界，直接改数组元素
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }
        }
        return count;
    }
}
