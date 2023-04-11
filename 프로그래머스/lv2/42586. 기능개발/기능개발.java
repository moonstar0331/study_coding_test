import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        for(int i=0; i<speeds.length; i++) {
            if((100-progresses[i])%speeds[i] == 0) {
                progresses[i] = (100-progresses[i])/speeds[i];
            } else {
                progresses[i] = (100-progresses[i])/speeds[i]+1;
            }
        }
        
        List<Integer> deploy = new ArrayList<>();
        int days = progresses[0];
        int cnt = 1;
        for(int i=1; i<progresses.length; i++) {
            if(days >= progresses[i])cnt++;
            else {
                deploy.add(cnt);
                cnt = 1;
                days = progresses[i];
            }
        }
        deploy.add(cnt);
        
        int[] answer = new int[deploy.size()];
        for(int i=0; i<deploy.size(); i++) {
            answer[i] = deploy.get(i);
        }
        
        return answer;
    }
}