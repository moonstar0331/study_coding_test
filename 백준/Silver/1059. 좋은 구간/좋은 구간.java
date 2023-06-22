import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int L;
    static int[] arr;
    static int N;
    
    static void input() {
        L = scan.nextInt();
        arr = new int[L];
        
        for(int i=0; i<L; i++) {
            arr[i] = scan.nextInt();
        }
        
        N = scan.nextInt();
    }
    
    static void pro() {
        Arrays.sort(arr);
        
        int start = 0;
        int end = 1001;
        
        for(int i=0; i<L; i++) {
            if(arr[i] < N) {
                start = Math.max(start, arr[i]);
            } else if(arr[i] > N) {
                end = Math.min(end, arr[i]);
            } else {
                System.out.println(0);
                return;
            }
        }
        
        int answer = 0;
        
        for(int i=start+1; i<=N; i++) {
            for(int j=N; j<=end-1; j++) {
                if(i != j) answer++;
            }
        }
        
        System.out.println(answer);
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