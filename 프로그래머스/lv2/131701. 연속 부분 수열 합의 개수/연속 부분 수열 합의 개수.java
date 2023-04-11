import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int cnt=1; cnt<=elements.length; cnt++) {
            for(int i=0; i<elements.length; i++) {
                int sum = 0;
                for(int j=1; j<=cnt; j++) {
                    int idx = (i+j-1)%elements.length;
                    sum += elements[idx];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}