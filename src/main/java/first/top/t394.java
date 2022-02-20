package first.top;

import java.util.*;

public class t394 {
    public static void main(String[] args) {
        t394 obj = new t394();
        obj.decodeString("2[abc]3[cd]ef");
    }
    private int index = 0;

    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                String num = getNumber(s);
                stack.push(num);
            } else if (Character.isLetter(c) || c == '[') {
                stack.push(String.valueOf(s.charAt(index++)));
            } else {
                index++;

                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stack.peek())) {
                    sub.addLast(stack.pop());
                }
                Collections.reverse(sub);
                StringBuilder charSb = new StringBuilder();
                for (String ss : sub) {
                    charSb.append(ss);
                }
                // [ 出栈
                stack.pop();
                int reqTime = Integer.parseInt(stack.pop());
                StringBuilder tempSb = new StringBuilder();
                while (reqTime-- > 0){
                    tempSb.append(charSb);
                }
                stack.push(String.valueOf(tempSb));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pollLast());
        }
        return res.toString();
    }

    private String getNumber(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            sb.append(s.charAt(index++));
        }
        return sb.toString();
    }
}
