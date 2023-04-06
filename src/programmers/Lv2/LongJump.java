package programmers.Lv2;

// Lv2. 멀리 뛰기
public class LongJump {
    public long solution(int n) {
        long answer = 0;
        if(n==1) return 1;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<=n; i++) {
            arr[i] = (arr[i-1] + arr[i-2])%1234567;
        }
        answer = arr[n];
        return answer;
    }
}
