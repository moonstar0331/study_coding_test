import java.util.*;
public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n == 1 || n == 2) return 1;
        
        while(n >= 1) {
            if(n%2 == 0) n/=2;
            else {
                answer++;
                n = (n-1)/2;
            }
        }
        
        return answer;
    }
}