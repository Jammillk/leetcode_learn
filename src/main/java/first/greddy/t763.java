package first.greddy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t763 {
    public static void main(String[] args) {
        t763 t763 = new t763();
        System.out.println(t763.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, map.get(s.charAt(i)));
            if (right == i) {
                list.add(right - left + 1);
                left = i + 1;
            }
        }
        return list;
    }
}
