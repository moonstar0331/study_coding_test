import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N, M;

    static void input() {
//        String[] strArr = scan.nextLine().split(" ");
//        N = Integer.parseInt(strArr[0]);
//        M = Integer.parseInt(strArr[1]);
        N = scan.nextInt();
        M = scan.nextInt();
    }

    static void pro() {
        int answer = 0;
        for(int a=1; a<=N-2; a++) {
            for(int b=a+1; b<=N-1; b++) {
                Double result = (Math.pow(a, 2) + Math.pow(b, 2) + M) / (a*b);
                if(result % 1 == 0.0) answer++;
            }
        }
        sb.append(answer).append('\n');
    }

    public static void main(String[] args) {
        T = scan.nextInt();
        for(int i=0; i<T; i++) {
            input();
            pro();
        }
        System.out.println(sb.toString());
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