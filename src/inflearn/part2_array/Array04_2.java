package inflearn.part2_array;

import java.util.Scanner;

class Array04_2 {
    public void solution(int n) {
        int a = 1;
        int b = 1;
        int c;
        System.out.print(a + " " + b + " ");
        for(int i=2; i<n; i++) {
            c = a + b;
            System.out.println(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Array04_2 T = new Array04_2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.solution(n);
    }
}
