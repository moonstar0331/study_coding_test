package inflearn.part2_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Array01 {

    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int lf = Integer.MIN_VALUE;

        for(int x : arr) {
            if(lf < x) {
                answer.add(x);
            }
            lf = x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Array01 T = new Array01();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++) {
            arr[i] = kb.nextInt();
        }

        for(int x : T.solution(arr)) {
            System.out.print(x + " ");
        }
    }
}
