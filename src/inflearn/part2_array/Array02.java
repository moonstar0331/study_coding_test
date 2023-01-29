package inflearn.part2_array;

import java.util.Scanner;

class Array02 {

    public int solution(int[] arr) {
        int answer = 1;
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Array02 T = new Array02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(arr));
    }
}
