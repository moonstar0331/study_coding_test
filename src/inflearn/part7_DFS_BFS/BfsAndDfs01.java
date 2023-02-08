package inflearn.part7_DFS_BFS;

import java.util.Scanner;

class BfsAndDfs01 {
    public void solution(int n) {
        if(n==0) return;
        else {
            solution(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        BfsAndDfs01 T = new BfsAndDfs01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.solution(n);
    }
}
