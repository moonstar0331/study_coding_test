package inflearn.part8_DFS_BFS2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2 {
    int x, y;
    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class BfsAndDfs14 {

    static int answer=0, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point2> queue = new LinkedList<>();

    public void BFS(int x, int y, int[][] board) {
        queue.add(new Point2(x, y));
        while (!queue.isEmpty()) {
            Point2 pos = queue.poll();
            for(int i=0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1) {
                    board[nx][ny]=0;
                    queue.add(new Point2(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) {
                    answer++;
                    board[i][j]=0;
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        BfsAndDfs14 T = new BfsAndDfs14();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
