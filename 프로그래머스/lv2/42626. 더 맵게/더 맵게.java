import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int x : scoville) {
            queue.offer(x);
        }
        
        while(queue.peek() < K) {
            if(queue.size() == 1) return -1;
            
            int one = queue.poll();
            int two = queue.poll();
            int tmp = one + two*2;
            
            queue.offer(tmp);
            answer++;
        }
        
        return answer;
    }
}