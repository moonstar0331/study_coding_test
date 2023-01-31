package inflearn.part3_sliding_window;

import java.util.Scanner;

class SlidingWindow04 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for(int rt=0; rt<n; rt++) {
            sum += arr[rt];
            if(sum == m) answer++;
            while(sum>=m) {
                sum -= arr[lt++];
                if(sum==m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SlidingWindow04 T = new SlidingWindow04();
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
