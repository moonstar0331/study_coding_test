import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            String tmp = s.substring(i, s.length()) + s.substring(0, i);
            
            if(tmp.charAt(0) == '}' || tmp.charAt(0) == ']' || tmp.charAt(0) == ')') continue;
            
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            stack.push(tmp.charAt(0));
            for(int j=1; j<tmp.length(); j++) {
                if(stack.isEmpty()) {
                    if(tmp.charAt(j) == '}' || tmp.charAt(j) == ']' || tmp.charAt(j) == ')') {
                        flag = false;
                        break;
                    }
                }
                if(tmp.charAt(j) == '{' || tmp.charAt(j) == '[' || tmp.charAt(j) == '(') {
                    stack.push(tmp.charAt(j));
                    continue;
                }
                
                if(stack.peek() == '{' && tmp.charAt(j) == '}') stack.pop();
                else if(stack.peek() == '[' && tmp.charAt(j) == ']') stack.pop();
                else if(stack.peek() == '(' && tmp.charAt(j) == ')') stack.pop();
            }
            
            if(stack.isEmpty() && flag) answer++;
        }
        
        return answer;
    }
}