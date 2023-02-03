package inflearn.part5_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackAndQueue07 {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for(char x : need.toCharArray()) {
            queue.offer(x);
        }

        for(char x : plan.toCharArray()) {
            if(queue.contains(x)) {
                if(x != queue.poll()) return "NO";
            }
        }
        if(!queue.isEmpty()) return "NO";

        return answer;
    }

    public static void main(String[] args) {
        StackAndQueue07 T = new StackAndQueue07();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();
        System.out.println(T.solution(str1, str2));
    }
}
