import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, max;
    static int[][] a;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        a = new int[N][N];
        max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                a[i][j] = scan.nextInt();
                max = Math.max(max, a[i][j]);
            }
        }
    }

    static void dfs(int x, int y, int h) {
        visit[x][y] = true;

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(visit[nx][ny]) continue;
            if(a[nx][ny] <= h) continue;

            dfs(nx, ny, h);
        }
    }

    static void pro() {
        visit = new boolean[N][N];
        int ans = Integer.MIN_VALUE;

        // 0 ~ max 까지 비가 왔을 경우 각각 실행
        for(int h=0; h<=max; h++) {
            int result = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visit[i][j] && a[i][j] > h) {
                        dfs(i, j, h);
                        result++;
                    }
                }
            }
            ans = Math.max(ans, result);

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    visit[i][j] = false;
                }
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