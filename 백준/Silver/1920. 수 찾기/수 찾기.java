import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] A;
    static int M;
    static int[] B;
    
    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B = new int[M+1];
        for(int i=1; i<=M; i++) {
            B[i] = scan.nextInt();
        }
    }
    
    static int check(int num) {
        int L=1, R=N;
        while(L<=R) {
            int mid = (L+R)/2;
            if(A[mid] == num) return 1;
            else if(A[mid] > num) {
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
        return 0;
    }
    
    static void pro() {
        // 배열 A에 대해서 이분탐색, 정렬
        Arrays.sort(A, 1, N+1);
        
        // B의 원소들에 대해서 수행
        for(int i=1; i<=M; i++) {
            System.out.println(check(B[i]));
        }
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