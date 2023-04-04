package programmers.Lv2;

import java.util.*;

// Lv2. 짝지어 제거하기
public class RemovePairs {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(char x : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(x);
            } else {
                if(stack.peek() == x) {
                    stack.pop();
                } else {
                    stack.push(x);
                }
            }
        }
        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}
