package inflearn.part5_stack_queue;

import java.util.Scanner;
import java.util.Stack;

class StackAndQueue02 {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(x == '(') stack.push(x);
            else if(x == ')') {
                stack.pop();
            } else {
                if(stack.isEmpty())
                    answer += x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StackAndQueue02 T = new StackAndQueue02();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
