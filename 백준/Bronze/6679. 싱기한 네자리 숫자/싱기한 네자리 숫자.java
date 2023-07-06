import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void pro() {

        for(int i=1000; i<=9999; i++) {
            int sum10 = 0;
            int sum12 = 0;
            int sum16 = 0;

            for(int n=i; n>0; n/=10) {
                sum10 += n%10;
            }

            for(int n=i; n>0; n/=12) {
                sum12 += n%12;
            }

            for(int n=i; n>0; n/=16) {
                sum16 += n%16;
            }

            if(sum10 == sum12 && sum12 == sum16) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
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