import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[][] a;
    static int[][] dist;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        a = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        dist = new int[N][M];
    }
    
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        // 모든 익은 토마토를 큐에 넣는다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dist[i][j] = -1;
                if(a[i][j] == 1) {
                    Q.add(i);
                    Q.add(j);
                    dist[i][j] = 0;
                } else if(a[i][j] == -1) {
                    dist[i][j] = -2;
                }
            }
        }
        
        // bfs 시작
        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            
            for(int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(dist[nx][ny] != -1) continue;
                
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }
    
    static void pro() {
        bfs();
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
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