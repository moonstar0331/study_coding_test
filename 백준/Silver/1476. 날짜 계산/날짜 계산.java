import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // E : 지구를 나타내는 수 (1~15)
    // S : 태양을 나타내는 수 (1~28)
    // M : 달을 나타내는 수 (1~19)
    
    static int E, S, M;
    
    static void input() {
        E = scan.nextInt();
        S = scan.nextInt();
        M = scan.nextInt();
    }
    
    static void pro() {
        int e = 0;
        int s = 0;
        int m = 0;
        int ans = 0;
        
        while(e != E || s != S || m != M) {
            e = (e+1)%16;
            s = (s+1)%29;
            m = (m+1)%20;
            if(e == 0) e=1;
            if(s == 0) s=1;
            if(m == 0) m=1;
            ans++;
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