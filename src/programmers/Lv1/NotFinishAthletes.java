package programmers.Lv1;

import java.util.*;

// 완주하지 못한 선수
public class NotFinishAthletes {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }

        for(int i=0; i<completion.length; i++) {
            if(map.get(completion[i]) == 1) {
                map.remove(completion[i]);
            } else {
                map.put(completion[i], map.get(completion[i])-1);
            }
        }

        answer = map.keySet().iterator().next();

        return answer;
    }
}
