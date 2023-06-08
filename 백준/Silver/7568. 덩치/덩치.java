import java.io.*;
import java.util.*;

class Person {
    int w;
    int h;

    public Person(int w, int h) {
        this.w = w;
        this.h = h;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Person[] arr;
    static int[] ans;

    static void input() {
        N = scan.nextInt();
        arr = new Person[N];
        ans = new int[N];
        for(int i=0; i<N; i++) {
            int w = scan.nextInt();
            int h = scan.nextInt();
            arr[i] = new Person(w, h);
        }
    }

    static void pro() {

        for(int i=0; i<N; i++) {
            Person p = arr[i];
            int cnt = 1;
            for(int j=0; j<N; j++) {
                if(p.w < arr[j].w && p.h < arr[j].h) cnt++;
            }
            ans[i] = cnt;
        }

        for(int i=0; i<N; i++) {
            System.out.print(ans[i] + " ");
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