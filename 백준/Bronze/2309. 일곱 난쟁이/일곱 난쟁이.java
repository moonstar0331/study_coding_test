import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static boolean[] check;
    static boolean[] tmp;
    static List<Integer> list;

    static void input() {
        arr = new int[9];
        check = new boolean[9];
        tmp = new boolean[9];
        list = new ArrayList<>();
        for(int i=0; i<9; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void rec_func(int n, int cnt, int sum) {
        if(n >= 9) {
            if(cnt != 7) return;
            if(sum > 100) return;
            if(cnt == 7 && sum == 100) {
                for(int i=0; i<9; i++) {
                    tmp[i] = check[i];
                }
            }
        } else {
            check[n] = true;
            rec_func(n+1, cnt+1, sum+arr[n]);
            check[n] = false;
            rec_func(n+1, cnt, sum);
        }
    }

    static void pro() {
        rec_func(0, 0, 0);

        for(int i=0; i<9; i++) {
            if(tmp[i]) list.add(arr[i]);
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
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