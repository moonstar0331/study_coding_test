package inflearn.part5_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackAndQueue08 {
    public int solution(int n, int m, int[] arr) {
        int answer = 1;
        Queue<Person> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        while(!queue.isEmpty()) {
            Person tmp = queue.poll();
            for(Person x : queue) {
                if(x.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp!=null) {
                if(tmp.id==m) return answer;
                else answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StackAndQueue08 T = new StackAndQueue08();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}


