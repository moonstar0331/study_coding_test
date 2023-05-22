import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[] arr;
    
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = scan.nextInt();
        }
    }
    
    static void pro() {
        int sum = 0;
        int start=0, end=0, ans=0;
        
        while(true) {
            if(sum >= M) {
                sum -= arr[start++];
            } else if (end == N) break;
            else {
                sum += arr[end++];
            }
            
            if(sum == M) ans++;
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