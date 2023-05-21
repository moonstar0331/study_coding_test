import java.io.*;
import java.util.*;

public class Main {
    
    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            if(lhs.length() != rhs.length()) {
                return lhs.length() - rhs.length();
            }
            return lhs.compareTo(rhs);
        }
    }
    
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static String[] arr;
    
    static void input() {
        N = scan.nextInt();
        arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = scan.next();
        }
    }
    
    static void pro() {
        Arrays.sort(arr, new MyComparator());
        for(int i=0; i<N; i++) {
            if(i==0 || arr[i].compareTo(arr[i-1]) != 0)
                sb.append(arr[i]).append('\n');
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