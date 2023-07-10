import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        // 택배상자의 크기는 모두 같음
        // 1번부터 n번까지 번호가 증가하는 순서대로 전달
        // 영재가 몇 개의 상자를 싫을 수 있는지 return
    
        int cnt = 1; // 메인 컨테이너의 박스 번호
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<order.length; i++) {
            int num = order[i]; // 배달 기사님의 오더 박스 번호
            
            if(cnt < num) {
                while(cnt != num) {
                    stack.push(cnt++);
                }
                answer++;
                cnt++;
            } else if(cnt == num) {
                answer++;
                cnt++;
            } else {
                int sub = stack.pop();
                if(num == sub) answer++;
                else break;
            }
        }
        
        return answer;
    }
}