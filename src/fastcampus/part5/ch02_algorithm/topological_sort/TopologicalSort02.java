package fastcampus.part5.ch02_algorithm.topological_sort;

import java.io.*;
import java.util.*;

// 백준 1005 - ACM Craft
public class TopologicalSort02 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        T = new int[N + 1];
        T_done = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            T[i] = scan.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            // indegree 계산하기
            indeg[y]++;
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i=1; i<=N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                T_done[i] = T[i];
            }
        }

        // 정렬될 수 있는 정점이 있다면?
        // 1. 정렬 결과에 추가하기
        // 2. 정점과 연결된 간선 제거하기
        // 3. 새롭게 "정렬 될 수 있는" 정점
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);
                // 위상 정렬 순서대로 T_done 계산을 함께 해주기
                T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
            }
        }
        int W = scan.nextInt();
        System.out.println(T_done[W]);
    }

    public static void main(String[] args) {
        int Q = scan.nextInt();
        while (Q > 0) {
            Q--;
            input();
            pro();
        }
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
