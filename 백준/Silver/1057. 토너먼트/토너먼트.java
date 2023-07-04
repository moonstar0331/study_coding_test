import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, A, B;
    static int ans;
    
    static void input() {
        N = scan.nextInt();
        A = scan.nextInt();
        B = scan.nextInt();
        ans = 1;
    }
    
    static void rec_func(int N, int A, int B) {
        int roundA = A%2==0?A:A+1;
        int roundB = B%2==0?B:B+1;
        
        if(roundA == roundB) {
            return;
        } else {
            ans++;
            rec_func(N/2, roundA/2, roundB/2);
        }
    }
    
    static void pro() {
        rec_func(N, A, B);
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