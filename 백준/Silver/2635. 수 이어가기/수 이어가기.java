import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int maxLen, maxSecond;

    static void input() {
        N = scan.nextInt();
        maxLen = 1;
        maxSecond = N;
    }

    static void pro() {
        int first, second;

        for(int i=N; i>=0; i--) {
            first = N;
            second = i;
            int cnt = 2;

            while(first - second >= 0) {
                int third = first - second;
                first = second;
                second = third;
                cnt++;
            }

            if(maxLen < cnt) {
                maxLen = cnt;
                maxSecond = i;
            }
        }

        sb.append(maxLen).append('\n');
        sb.append(N).append(" ").append(maxSecond).append(" ");

        first = N;
        while(first - maxSecond >= 0) {
            int third = first - maxSecond;
            first = maxSecond;
            maxSecond = third;

            sb.append(maxSecond).append(" ");
        }

        System.out.println(sb);
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