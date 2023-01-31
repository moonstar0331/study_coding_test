package inflearn.part3_sliding_window;

import java.util.Scanner;

class SlidingWindow03 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;

        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        answer = sum;

        for(int i=k; i<n; i++) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        SlidingWindow03 T = new SlidingWindow03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
