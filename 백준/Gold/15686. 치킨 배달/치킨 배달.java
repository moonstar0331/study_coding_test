import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[][] A;
    static List<Point> home;
    static List<Point> chicken;
    static int ans;
    static boolean[] check;
    
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        
        A = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                A[i][j] = scan.nextInt();
                if(A[i][j] == 1) home.add(new Point(i, j));
                else if(A[i][j] == 2) chicken.add(new Point(i, j));
            }
        }
        
        ans = Integer.MAX_VALUE;
        check = new boolean[chicken.size()];
    }
    
    public static void DFS(int start, int cnt) {
        if(cnt == M) {
            int res = 0;
            
            for(int i=0; i<home.size(); i++) {
                int temp = Integer.MAX_VALUE;
                
                for(int j=0; j<chicken.size(); j++) {
                    if(check[j]) {
                        int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        
                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
        } else {
            for(int i=start; i<chicken.size(); i++) {
                check[i] = true;
                DFS(i+1, cnt+1);
                check[i] = false;
            }
        }
    }
    
    static void pro() {
        // 0: 빈칸, 1: 집, 2: 치킨집
        
        DFS(0, 0);
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