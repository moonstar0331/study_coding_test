package inflearn.part6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

class SortingAndSearching08 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt=0, rt=n-1;

        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if(arr[mid]==m){
                answer = mid+1;
                break;
            }
            if(arr[mid]>m) rt=mid-1;
            else lt=mid+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        SortingAndSearching08 T = new SortingAndSearching08();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
