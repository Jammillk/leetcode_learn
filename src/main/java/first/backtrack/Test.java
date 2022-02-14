package first.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test obj = new Test();
        System.out.println(obj.restoreIpAddresses("25525511135"));
    }
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return res;
        }
        backtrack(s, 0, 0);
        return res;
    }
    private void backtrack(String s, int startIndex, int pointNum){
        if(pointNum == 3){
            if(isValidIp(s, startIndex, s.length() - 1)){
                res.add(s);
            }
            return ;
        }
        for(int i = startIndex;i < s.length();i++){
            if(!isValidIp(s, startIndex, i)){
                return ;
            }
            s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
            pointNum++;
            backtrack(s, i + 2, pointNum);
            pointNum--;
            s = s.substring(0, i + 1) + s.substring(i + 2);
        }
    }
    private boolean isValidIp(String s, int start, int end){
        if(start > end){
            return false;
        }
        if(s.charAt(start) == '0' && start != end){
            return false;
        }
        int num = 0;
        for(int i = start;i <= end;i++){
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + s.charAt(i) - '0';
            if(num > 255){
                return false;
            }
        }
        return true;
    }
}
