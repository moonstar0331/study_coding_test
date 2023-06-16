import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr, strike, ball;

    static void input() {
        N = scan.nextInt();
        arr = new int[N];
        strike = new int[N];
        ball = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = scan.nextInt();
            strike[i] = scan.nextInt();
            ball[i] = scan.nextInt();
        }
    }

    static void pro() {
        int answer = 0;
        for(int i=123; i<=987; i++) {

            // i는 0은 포함 x, 중복된 숫자 x
            if(i/100 == i/10%10) continue; // 백의자리 == 십의자리
            else if(i/100 == i%10) continue; // 백의자리 == 일의자리
            else if(i/10%10 == i%10) continue; // 십의자리 == 일의자리

            if(i/10%10 == 0) continue; // 십의 자리가 0인 경우
            if(i%10 == 0) continue; // 일의 자리가 0인 경우

            int check = 0; // i와 입력값의 비교 결과가 같은 경우 카운트
            // i와 입력값에 대해서 비교
            for(int j=0; j<N; j++) {
                int num = arr[j]; // i와 비교할 입력값

                int strike_cnt = 0;
                int ball_cnt = 0;

                if(num/100 == i/100) strike_cnt++; // 백==백(strike)
                else {
                    if (num / 10 % 10 == i / 100) ball_cnt++; // 백==십(ball)
                    else if (num % 10 == i / 100) ball_cnt++;// 백==일(ball)
                }

                if(num/10%10 == i/10%10) strike_cnt++; // 십==십(strike)
                else {
                    if(num/100 == i/10%10) ball_cnt++; // 백==십(ball)
                    else if(num%10 == i/10%10) ball_cnt++; // 일==십(ball)
                }

                if(num%10 == i%10) strike_cnt++; // 일==일(ball)
                else {
                    if(num/100 == i%10) ball_cnt++; // 백==일(ball)
                    else if(num/10%10 == i%10) ball_cnt++; // 십==일(ball)
                }

                if(strike_cnt != strike[j] || ball_cnt != ball[j]) break;
                check++;
            }
            if(check == N) answer++;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}