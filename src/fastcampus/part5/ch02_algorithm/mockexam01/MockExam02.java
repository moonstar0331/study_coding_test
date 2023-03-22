package fastcampus.part5.ch02_algorithm.mockexam01;

import java.io.*;
import java.util.*;

// 백준 20165 - 인내의 도미노 장인 호석
public class MockExam02 {

    static int n, m, R, ans;
    static int[][] a, backup;
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader scan = new FastReader();

    // board 의 상태를 입력받는 함수
    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        R = scan.nextInt();
        a = new int[n + 1][m + 1];
        backup = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                a[i][j] = scan.nextInt();
                backup[i][j] = a[i][j];
            }
    }

    // x 행 y 열에 있는 도미노를 dir 방향으로 밀어버리는 함수
    static void attack(int x, int y, char dir) {
        if (a[x][y] == 0) return;

        int dx = 0, dy = 0;
        if (dir == 'E') dy = 1;
        else if (dir == 'W') dy = -1;
        else if (dir == 'S') dx = 1;
        else dx = -1;

        int cnt = a[x][y];
        while(x >= 1 && x <= n && y >= 1&& y <= m && cnt >= 1) {
            if (a[x][y] != 0) ans++;

            cnt = Math.max(cnt - 1, a[x][y] - 1);

            a[x][y] = 0;
            x += dx;
            y += dy;
        }
    }

    // 게임 순서에 맞게 진행시키는 함수
    static void pro() {
        for (int rep = 1; rep <= R; rep++) {
            int X, Y;
            String dir;

            X = scan.nextInt();
            Y = scan.nextInt();
            dir = scan.next();

            attack(X, Y, dir.charAt(0));

            X = scan.nextInt();
            Y = scan.nextInt();
            a[X][Y] = backup[X][Y];
        }
        System.out.println(ans);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 0) System.out.print("F ");
                else System.out.print("S ");
            }
            System.out.println();
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
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
