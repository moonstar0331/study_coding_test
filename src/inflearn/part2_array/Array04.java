package inflearn.part2_array;

import java.util.*;

class Array04 {
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<n; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Array04 T = new Array04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int x : T.solution(n)) {
            System.out.print(x + " ");
        }
    }
}
