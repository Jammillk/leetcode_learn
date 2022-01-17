package first.greddy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 身高和排名两个维度，不能同时确认
 *
 */
public class t406 {
    public int[][] reconstructQueue(int[][] people) {
        // 后减前，是降序；前减后，是升序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }
}
