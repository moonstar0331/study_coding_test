import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static double[] A, dp;

    static void input() {
        N = scan.nextInt();
        A = new double[N+1];
        dp = new double[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = scan.nextDouble();
        }
    }

    static void pro() {
        double answer = 0;
        for(int i=1; i<=N; i++) {
            dp[i] = Math.max(A[i], dp[i-1] * A[i]);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(String.format("%.3f", answer));
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