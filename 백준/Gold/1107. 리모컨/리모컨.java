import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N; // 수빈이가 이동하려고 하는 채널
    static int M; // 고장난 버튼의 개수
    static boolean[] arr; // 고장난 버튼을 위한 배열
    static int ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new boolean[10];
        for(int i=0; i<M; i++) {
            int num = scan.nextInt();
            arr[num] = true;
        }
        ans = Math.abs(N - 100);
    }

    static void pro() {
        // 수빈이의 현재 채널의 100
        if(N == 100) {
            System.out.println(0);
            return;
        }

        for(int i=0; i<=1000000; i++) {
            String str = String.valueOf(i);
            
            boolean possible = true;
            for(int j=0; j<str.length(); j++) {
                int num = str.charAt(j) - '0';
                if(arr[num]) {
                    possible = false;
                    break;
                }
            }
            
            if(possible) {
                int cnt = str.length() + Math.abs(N - i);
                ans = Math.min(ans, cnt);
            }
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