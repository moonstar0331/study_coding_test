package programmers.Lv1;

import java.util.*;

// 명예의 전당 (1)
public class HallOfFame01 {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<score.length; i++) {
            if(list.size() < k) {
                list.add(score[i]);
                Collections.sort(list);
                answer[i] = list.get(0);
            } else {
                if(list.get(0) < score[i]) {
                    list.remove(0);
                    list.add(score[i]);
                    Collections.sort(list);
                }
                answer[i] = list.get(0);
            }
        }

        return answer;
    }
}
