import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 1. 큰 수가 우선순위를 갖는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //2. 우선순위 큐에 배열값 넣어주기
        for(int i = 0;i<priorities.length;i++){
            pq.add(priorities[i]);
        }
        
        // 3. 큐의 값이 없어지기 전까지 반복
        while(!pq.isEmpty()){
            for(int i = 0;i<priorities.length;i++){
            
            	// 4.만약 큐의 가장 높은 숫자가 배열의 i번째 index의 값과 같다면
                if(pq.peek() == priorities[i]){
                
                    // 5.값만 일치하는 경우 해당 문서 출력
                    pq.poll();
                    answer++;
                    
                    // 6.값과 위치가 모두 같다면 answer 리턴
                    if(i == location) return answer;
                }
            }
        }
      
        
        return answer;
    }
}