package inflearn.part7_DFS_BFS;

import java.util.Scanner;

class BfsAndDfs02 {
    public void solution(int n) {
        if(n == 0) return;
        else {
            solution(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        BfsAndDfs02 T = new BfsAndDfs02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.solution(n);
    }
}
