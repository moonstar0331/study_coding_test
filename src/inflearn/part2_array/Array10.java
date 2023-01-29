package inflearn.part2_array;

import java.util.Scanner;

class Array10 {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                boolean val = (arr[i][j] > arr[i-1][j]) && (arr[i][j] > arr[i][j+1]) && (arr[i][j] > arr[i+1][j]) && (arr[i][j] > arr[i][j-1]);
                if(val) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Array10 T = new Array10();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int arr[][] = new int[n+2][n+2];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
