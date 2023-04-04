package programmers.Lv2;

import java.util.*;

// Lv2. 올바른 괄호
public class CorrectParentheses {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()) {
            if(x == '(') {
                stack.push('c');
            } else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;

        return answer;
    }
}
