import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, S;
    static int[] A;
    
    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = scan.nextInt();
        }
        S = scan.nextInt();
    }
    
    static boolean bin_search(int[] A, int L, int R, int X) {
        while(L<=R) {
            int mid = (L+R)/2;
            if(A[mid] == X) return true;
            
            if(A[mid] < X) {
                L = mid+1;
            } else {
                R = mid-1;
            }
        }
        return false;
    }
    
    static void pro() {
        Arrays.sort(A, 1, N+1);
        
        int ans = 0;
        for(int i=1; i<=N-1; i++) {
            if(bin_search(A, i+1, N, S-A[i])) ans++;
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