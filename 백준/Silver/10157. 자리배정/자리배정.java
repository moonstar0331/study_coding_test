import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K, d;
    static int ansRow, ansCol;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] check;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        check = new boolean[M+1][N+1];
        d = 0;
        ansRow = 0; // M-row+1
        ansCol = 0;
    }

    static void rec_func(int cnt, int row, int col) {
        if(cnt == K) {
            ansRow = row;
            ansCol = col;
        } else {
            check[row][col] = true;

            int dx = row + dir[d][0];
            int dy = col + dir[d][1];

            if(dx < 1  || dy < 1 || dx > M || dy > N || check[dx][dy]) {
                d = (d+1) % 4;
                dx = row + dir[d][0];
                dy = col + dir[d][1];
            }

            rec_func(cnt+1, dx, dy);
        }
    }

    static void pro() {
        if(K > N*M) {
            System.out.println(0);
        } else {
            rec_func(1, 1, 1);
            System.out.println(ansCol + " " + ansRow);
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