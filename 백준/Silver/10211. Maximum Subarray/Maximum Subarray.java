import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int T;
    static int[] arr;
    static int[] dp;
    static int N;
    
    static void input() {
        N = scan.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            arr[i] = scan.nextInt();
        }
    }
    
    static void pro() {
        int ans = Integer.MIN_VALUE;
        
        for(int i=1; i<=N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        T = scan.nextInt();
        
        while(T-- > 0) {
            input();
            pro();
        }
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