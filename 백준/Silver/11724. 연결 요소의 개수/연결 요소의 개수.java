import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<=M; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            adj[start].add(end);
            adj[end].add(start);
        }
    }
    
    static void dfs(int x) {
        visit[x] = true;
        
        for(int y : adj[x]) {
            if(visit[y]) continue;
            dfs(y);
        }
    }
    
    static void pro() {
        visit = new boolean[N+1];
        int ans = 0;
        for(int i=1; i<=N; i++) {
            if(visit[i]) continue;
            dfs(i);
            ans++;
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