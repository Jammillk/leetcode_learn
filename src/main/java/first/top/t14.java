package first.top;

import java.util.Arrays;

public class t14 {
    public static void main(String[] args) {
        t14 obj = new t14();
        System.out.println(obj.longestCommonPrefix(new String[]{
                "flower", "flow", "flight"
        }));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        return findLongest(strs[0], strs[strs.length - 1]);
    }
    private String findLongest(String s1, String s2) {
        int len = 0;
        while (len < s1.length()){
            if (s1.charAt(len) == s2.charAt(len)){
                len++;
            }else{
                break;
            }
        }
        return s1.substring(0, len);
    }



        private String findLongest2(String s1, String s2) {
        int len = 0;
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)){
                break;
            }
            len ++;
        }
        return s1.substring(0, len);
    }
}
