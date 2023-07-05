import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] arr;
    static boolean[] check;
    
    static void input() {
        N = scan.nextInt();
        arr = new int[N];
        check = new boolean[N];
    }
    
    static void rec_func(int n) {
        if(n == N) {
            for(int i=0; i<N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for(int i=0; i<N; i++) {
                if(!check[i]) {
                    arr[n] = i+1;
                    check[i] = true;
                    rec_func(n+1);
                    check[i] = false;
                }
            }
        }
    }
    
    static void pro() {
        rec_func(0);
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