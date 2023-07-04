import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<Long> list;

    static void input() {
        N = scan.nextInt();
        list = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        input();
        
        if(N <= 10) {
            System.out.println(N);
        } else if(N > 1022) {
            System.out.println(-1);
        } else {
            for(int i=0; i<10; i++) {
                cal(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }
    
    static void cal(long num, int depth) {
        if(depth > 10) return;
        list.add(num);
        for(int i=0; i<10; i++) {
            if(num%10 > i) {
                cal((num*10)+i, depth+1);
            }
        }
        return;
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