import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M, area;
    static String[] a;
    static int total_sheep, total_wolf;
    static int sheep, wolf;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for(int i=0; i<N; i++) {
            a[i] = scan.nextLine();
        }
        visit = new boolean[N][M];
    }
    
    static void dfs(int x, int y) {
        if(a[x].charAt(y) == 'o') sheep++;
        if(a[x].charAt(y) == 'v') wolf++;
        visit[x][y] = true;
        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(a[nx].charAt(ny)== '#') continue;
            if(visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }
    
    static void pro() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visit[i][j] && a[i].charAt(j) != '#') {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);
                    if(sheep > wolf) total_sheep += sheep;
                    else total_wolf += wolf;
                }
            }
        }
        
        sb.append(total_sheep).append(' ').append(total_wolf);
        System.out.println(sb.toString());
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