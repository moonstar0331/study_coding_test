import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static String[] arr;
    
    static void input() {
        N = scan.nextInt();
        arr = new String[N+1];
        for(int i=1; i<=N; i++) {
            String fileName = scan.next();
            arr[i] = fileName.split("\\.")[1];
        }
    }
    
    static void pro() {
        Arrays.sort(arr, 1, N+1);
        
        for(int i=1; i<=N;) {
            int cnt = 1;
            int j = i+1;
            for(; j<=N; j++) {
                if(arr[j].compareTo(arr[i]) == 0) cnt++;
                else break;
            }
            sb.append(arr[i]).append(' ').append(cnt).append('\n');
            i = j;
        }
        System.out.println(sb.toString());
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