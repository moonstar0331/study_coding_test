package fastcampus.part5.ch02_algorithm.dynamic_programming;

import java.io.*;
import java.util.*;

// 백준 1949 - 우수 마을
public class DynamicProgramming07 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] num;
    static ArrayList<Integer>[] con;
    static int[][] Dy;

    static void input(){
        N = scan.nextInt();
        num = new int[N + 1];
        con = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            num[i] = scan.nextInt();
            con[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            con[x].add(y);
            con[y].add(x);
        }
    }

    // Dy[x][] 를 계산하는 함수
    static void dfs(int x, int prev) {
        // 초기값 설정
        Dy[x][0] = 0;
        Dy[x][1] = num[x];

        // 점화식을 통해 Dy 를 채워나가기
        for (int y : con[x]) {
            if (y == prev) continue;
            dfs(y, x);
            Dy[x][0] += Math.max(Dy[y][0], Dy[y][1]);
            Dy[x][1] += Dy[y][0];
        }
    }

    static void pro() {
        Dy = new int[N + 1][2];

        dfs(1, -1);

        System.out.println(Math.max(Dy[1][0], Dy[1][1]));
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
