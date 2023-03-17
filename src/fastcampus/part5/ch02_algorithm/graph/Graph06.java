package fastcampus.part5.ch02_algorithm.graph;

import java.io.*;
import java.util.*;

// 백준 1697 - 숨바꼭질
public class Graph06 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] dist;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        visit = new boolean[100005];
        dist = new int[100005];
    }

    // 숨바꼭질 시작
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        visit[N] = true;
        dist[N] = 0;

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = x - 1;
            if (0 <= y && y <= 100000 && !visit[y]) {
                visit[y] = true;
                dist[y] = dist[x] + 1;
                Q.add(y);
            }
            y = x + 1;
            if (0 <= y && y <= 100000 && !visit[y]) {
                visit[y] = true;
                dist[y] = dist[x] + 1;
                Q.add(y);
            }
            y = x * 2;
            if (0 <= y && y <= 100000 && !visit[y]) {
                visit[y] = true;
                dist[y] = dist[x] + 1;
                Q.add(y);
            }
        }
    }

    static void pro() {
        bfs();
        System.out.println(dist[K]);
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
