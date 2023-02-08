package inflearn.part7_DFS_BFS;

import java.util.Scanner;

class BfsAndDfs03 {
    public int solution(int n) {
        if(n==1) return 1;
        else {
            return solution(n-1)*n;
        }
    }

    public static void main(String[] args) {
        BfsAndDfs03 T = new BfsAndDfs03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
