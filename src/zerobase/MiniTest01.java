package zerobase;

import java.io.*;
import java.util.StringTokenizer;

public class MiniTest01 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int K;
    static int[][] init;
    static int[][] store;
    static boolean[][] sub;
    static int[] bullet;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        init = new int[N][N];
        store = new int[N][N];
        sub = new boolean[N][N];
        bullet = new int[K];
        rows = new int[K];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int num = scan.nextInt();
                init[i][j] = num;
                store[i][j] = num;
            }
        }
        for(int i=0; i<K; i++) {
            bullet[i] = scan.nextInt();
        }
    }

    // N x N 크기의 보드 판, 1개 이상의 표적
    // 1번부터 K 번까지 K 개의 총알 -> 차례대로 발사, 각 총알은 공격력을 가짐
    // 1행부터 N 행 중 하나의 행을 선택하여 사격
    // 표적이 있는 위치는 1 이상의 자연수, 표적이 없으면 0
    // 표적이 있는 위치의 값은 초기 체력, 총알이 표적에 닿으면 현재 체력이 닮음
    // 체력이 0 이하가 되면 표적은 사라짐 -> 초기 체력만큼 점수를 얻는다.
    // 표적이 사라지면 상하좌우 중 빈 칸에 사라진 표적의 초기 체력의 1/4인 새로운 표적 생성
    // 보너스 표적 : 체력 10이상, 보너스 표적을 맞히는 순간 사라짐, 보너스 표적에 적힘 점수만큼 얻음, 새로운 표적 생성 x
    // K 번의 사격으로 얻을 수 있는 최대 값

    // 표적이 있으면 col 반환, 없으면 -1 반환
    static int checkCol(int row) {
        int col = -1;
        for(int i=0; i<N; i++) {
            if(init[row][i] != 0) {
                col = i;
                break;
            }
        }
        return col;
    }

    static int answer = 0;
    static int[] rows;
    static void pro(int k) {
        if(k == K) {
            int score = 0;
            for(int i=0; i<K; i++) {
                int row = rows[i];
                int col = checkCol(row);
                if(col == -1) {
                    break;
                } else {
                    if(init[row][col] >= 10) {
                        score += init[row][col];
                        init[row][col] = 0;
                    } else if(init[row][col] > bullet[i]) {
                        init[row][col] -= bullet[i];
                        sub[row][col] = true;
                    } else {
                        if(sub[row][col]) { // 맞아서 줄어든 경우
                            score += store[row][col];
                        } else { // 초기값이 작거나 부가적으로 생긴 경우
                            score += init[row][col];
                        }

                        if(store[row][col] != 0) { // 초기값이 있는 경우
                            if(row-1 >= 0 && init[row-1][col] == 0) init[row-1][col] = store[row][col]/4;
                            if(row+1 < N && init[row+1][col] == 0) init[row+1][col] = store[row][col]/4;
                            if(col-1 >= 0 && init[row][col-1] == 0) init[row][col-1] = store[row][col]/4;
                            if(col+1 < N && init[row][col+1] == 0) init[row][col+1] = store[row][col]/4;
                        } else { // 부가적으로 생긴 경우
                            if(row-1 >= 0 && init[row-1][col] == 0) init[row-1][col] = init[row][col]/4;
                            if(row+1 < N && init[row+1][col] == 0) init[row+1][col] = init[row][col]/4;
                            if(col-1 >= 0 && init[row][col-1] == 0) init[row][col-1] = init[row][col]/4;
                            if(col+1 < N && init[row][col+1] == 0) init[row][col+1] = init[row][col]/4;
                        }
                        init[row][col] = 0;
                    }
                }
            }
            answer = Math.max(answer, score);
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    sub[i][j] = false;
                    init[i][j] = store[i][j];
                }
            }
        } else {
            for(int cand=0; cand<N; cand++) {
                rows[k] = cand;
                pro(k+1);
                rows[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro(0);
        System.out.print(answer);
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
