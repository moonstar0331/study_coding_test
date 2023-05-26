import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static boolean[][] visit;
    static int[] dirx = {-1, 1};
    static int[] diry = {-1, 1};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for(int i=0; i<N; i++) {
            a[i] = scan.nextLine();
        }
    }

    static void dfs1(int x, int y) {
        visit[x][y] = true;

        for(int k=0; k<2; k++) {
            int nx = x;
            int ny = y + diry[k];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(visit[nx][ny]) continue;
            if(a[nx].charAt(ny) == '|') continue;

            dfs1(nx, ny);
        }
    }

    static void dfs2(int x, int y) {
        visit[x][y] = true;

        for(int k=0; k<2; k++) {
            int nx = x + dirx[k];
            int ny = y;

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(visit[nx][ny]) continue;
            if(a[nx].charAt(ny) == '-') continue;

            dfs2(nx, ny);
        }
    }

    static void pro() {
        visit = new boolean[N][M];

        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visit[i][j] && a[i].charAt(j) == '-') {
                    dfs1(i, j);
                    result++;
                }

                if(!visit[i][j] && a[i].charAt(j) == '|') {
                    dfs2(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
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