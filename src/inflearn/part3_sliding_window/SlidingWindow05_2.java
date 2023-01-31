package inflearn.part3_sliding_window;

import java.util.Scanner;

class SlidingWindow05_2 {
    public int solution(int n) {
        int answer = 0, cnt=1;
        n--;
        while(n>0) {
            cnt++;
            n = n-cnt;
            if(n%cnt==0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SlidingWindow05_2 T = new SlidingWindow05_2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
