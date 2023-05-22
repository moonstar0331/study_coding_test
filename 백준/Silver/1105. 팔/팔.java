import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int L, R;

    static void input() {
        L = scan.nextInt();
        R = scan.nextInt();
    }

    static void pro() {
        int mountCnt = Integer.MAX_VALUE;
        for(int i=L; i<=R; i++) {
            int cur = i;
            int curCnt = 0;
            while(cur != 0) {
                if(cur%10 == 8) curCnt++;
                cur /= 10;
            }
            mountCnt = Math.min(mountCnt, curCnt);
            if(mountCnt == 0) break;
        }
        System.out.println(mountCnt);
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