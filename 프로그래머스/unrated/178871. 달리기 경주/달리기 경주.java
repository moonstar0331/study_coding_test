import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++) {
            String call = callings[i];
            int rank = map.get(call);
            String prev = players[rank-1];
            map.put(call, map.get(call)-1);
            map.put(prev, map.get(prev)+1);
            
            players[rank] = prev;
            players[rank-1] = call;
        }
        
        answer = players;
        
        return answer;
    }
}