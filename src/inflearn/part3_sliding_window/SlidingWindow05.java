package inflearn.part3_sliding_window;

import java.util.Scanner;

class SlidingWindow05 {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n/2 + 1;
        int[] arr = new int[m];
        for(int i=0; i<m; i++) {
            arr[i] = i+1;
        }

        for(int rt=0; rt<m; rt++) {
            sum+=arr[rt];
            if(sum==n) answer++;
            while(sum>=n) {
                sum -= arr[lt++];
                if(sum==n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SlidingWindow05 T = new SlidingWindow05();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
