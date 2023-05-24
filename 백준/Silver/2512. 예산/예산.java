import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M, max;
    static int A[];
    
    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            A[i] = scan.nextInt();
            max = Math.max(max, A[i]);
        }
        M = scan.nextInt();
    }
    
    static void pro() {
        Arrays.sort(A, 1, N+1);
        int L=1, R=max, ans=0;
        while(L<=R) {
            int mid = (L+R)/2;
            int sum = 0;
            for(int i=1; i<=N; i++) {
                if(mid > A[i]) sum += A[i];
                else sum += mid;
            }
            
            if(sum > M) R--;
            else {
                ans = Math.max(ans, mid);
                L++;
            }
        }
        System.out.println(ans);
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