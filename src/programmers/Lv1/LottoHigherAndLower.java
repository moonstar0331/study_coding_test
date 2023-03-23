package programmers.Lv1;

import java.util.*;

// 로또의 최고 순위와 최저 순위
public class LottoHigherAndLower {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        // 정답을 빨리 찾기 위한 hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        map.put(1, 6);
        map.put(0, 6);

        // lottos : 민우가 구매한 로또 번호 (0: 알 수 없음, 0이외는 중복x)
        // win_nums : 당첨 번호 (중복x)

        // lottos 와 win_nums 정렬

        int same_cnt = 0, zero_cnt=0;
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) {
                zero_cnt++;
                continue;
            }
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) same_cnt++;
            }
        }

        answer[0] = map.get(same_cnt + zero_cnt);
        answer[1] = map.get(same_cnt);

        return answer;
    }
}
