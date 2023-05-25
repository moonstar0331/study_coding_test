import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, K;
    static int[] A;
    
    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = scan.nextInt();
        }
    }
    
    static void pro() {
        int max = 0;
        for(int i=1; i<=K; i++) {
            max += A[i];
        }
        
        int sum = max;
        for(int i=K+1; i<=N; i++) {
            sum -= A[i-K];
            sum += A[i];
            max = Math.max(max, sum);
        }
        
        System.out.println(max);
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