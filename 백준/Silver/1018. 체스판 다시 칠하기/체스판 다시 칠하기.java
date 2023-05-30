import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static boolean[][] A;
    static int ans;
    
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String str = scan.nextLine();
            for(int j=0; j<M; j++) {
                if(str.charAt(j) == 'W') A[i][j] = true;
                else A[i][j] = false;
            }
        }
    }
    
    static void pro() {
        ans = 64;
        for(int i=0; i<=N-8; i++) {
            for(int j=0; j<=M-8; j++) {
                find(i, j);
            }
        }
        System.out.println(ans);
    }
    
    static void find(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        
        int cnt = 0;
        
        boolean check = A[x][y];
        
        for(int i=x; i<endX; i++) {
            for(int j=y; j<endY; j++) {
                if(A[i][j] != check) cnt++;
                check = !check;
            }
            check = !check;
        }
        cnt = Math.min(cnt, 64-cnt);
        ans = Math.min(ans, cnt);
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