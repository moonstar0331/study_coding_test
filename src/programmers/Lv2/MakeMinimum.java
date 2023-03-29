package programmers.Lv2;

import java.util.*;

// Lv2 : 최솟값 만들기
public class MakeMinimum {
    public int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length-i-1];
        }

        return answer;
    }
}
