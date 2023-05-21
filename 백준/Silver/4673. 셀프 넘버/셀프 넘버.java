import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int func(int k) {
        int sum = k;
        
        while(k != 0) {
            sum += k%10;
            k /= 10;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[10001];
        
        for(int i=1; i<=10000; i++) {
            int n = func(i);
            
            if(n <= 10000) {
                arr[n] = 1;
            }
        }
        
        for(int i=1; i<=10000; i++) {
            if(arr[i] == 0) System.out.println(i);
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