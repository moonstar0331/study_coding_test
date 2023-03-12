package fastcampus.part5.ch02_algorithm.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

// 백준 9663 - N Queen
public class BruteForce06 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col; // col[i] : i 번째 행의 퀸은 col[i]번 열에 놓았다는 기록

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true; // 같은 열에 있는지 체크
        if(r1 - c1 == r2 - c2) return true; // 왼쪽 위 대각선에 있는지 체크
        if(r1 + c1 == r2 + c2) return true; // 오른쪽 위 대각선에 있는지 체크
        return false;
    }

    static boolean validity_check() {
        for(int i=1; i<=N; i++) {
            // (i, col[i])
            for(int j=1; j<i; j++) {
                // (j, col[j])
                if(attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // row 번 ~ N 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
    static void rec_func(int row) {
        if(row == N + 1) { // 각 행마다 하나씩 잘 놓았다.
                ans++;
        } else {
            for(int c=1; c<=N; c++) {
                boolean possible = true;
                // row 행의 c 열에 놓을 수 있으면 : valid check (row, c)
                for(int i=1; i<=row-1; i++) {
                    // (i, col[i)
                    if(attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if(possible) {
                    col[row] = c;
                    rec_func(row+1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
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
