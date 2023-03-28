package programmers.Lv1;

import java.util.*;

// 대충 만든 자판
public class RoughKeyboard {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // 키의 개수는 1개~100개
        // 특정 키를 눌렀을 때 입력되는 문자들은 무작위로 배열
        // 같은 문자가 자판 전체에 여러 번 할당된 경우 있음
        // 키 하나에 같은 문자가 여러 번 할당된 경우 있음
        // 아예 할당되지 않은 경우 있음
        // 몇몇 문자열은 작성할 수 없을 수도 있음
        // 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야하는지 알고싶음

        // keymap 에 존재하는 문자열에 대해서 최소 키 값 구하기
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++) {
            for(int j=0; j<keymap[i].length(); j++) {
                int cnt = map.getOrDefault(keymap[i].charAt(j), 0);
                if(cnt==0 || cnt>j+1) {
                    map.put(keymap[i].charAt(j), j+1);
                }
            }
        }

        // result 구하기
        for(int i=0; i<targets.length; i++) {
            int cnt = 0;
            for(int j=0; j<targets[i].length(); j++) {
                int n = map.getOrDefault(targets[i].charAt(j), 0);
                if(n == 0) {
                    cnt = -1;
                    break;
                }
                cnt += n;
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
