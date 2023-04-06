package programmers.Lv2;

import java.util.*;

// Lv2. 귤 고르기
public class SelectTangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((m1, m2) -> map.get(m2) - map.get(m1));

        int i=0;
        while(k>0) {
            k -= map.get(list.get(i));
            answer++;
            i++;
        }

        return answer;
    }
}
