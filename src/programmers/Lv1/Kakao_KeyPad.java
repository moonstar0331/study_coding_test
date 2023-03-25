package programmers.Lv1;

import java.util.*;

// 카카오 인턴 - 키패드 누르기
public class Kakao_KeyPad {
    static int dist(int handRow, int handCol, int row, int col) {
        return Math.abs(handRow - row) + Math.abs(handCol - col);
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";

        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(2, new int[]{0, 1});
        map.put(5, new int[]{1, 1});
        map.put(8, new int[]{2, 1});
        map.put(0, new int[]{3, 1});

        int lrow = 3, lcol = 0, rrow=3, rcol=2;

        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]==1) {
                lrow=0; lcol=0;
                answer += "L";
                continue;
            } else if (numbers[i] == 4) {
                lrow=1; lcol=0;
                answer += "L";
                continue;
            } else if (numbers[i] == 7) {
                lrow=2; lcol=0;
                answer += "L";
                continue;
            } else if (numbers[i] == 3) {
                rrow=0; rcol=2;
                answer += "R";
                continue;
            } else if (numbers[i] == 6) {
                rrow=1; rcol=2;
                answer += "R";
                continue;
            } else if (numbers[i] == 9) {
                rrow=2; rcol=2;
                answer += "R";
                continue;
            } else {
                int row = map.get(numbers[i])[0];
                int col = map.get(numbers[i])[1];
                int ldist = dist(lrow, lcol, row, col);
                int rdist = dist(rrow, rcol, row, col);
                if(ldist == rdist) {
                    if(hand.equals("left")) {
                        lrow = row;
                        lcol = col;
                        answer += "L";
                        continue;
                    } else {
                        rrow = row;
                        rcol = col;
                        answer += "R";
                        continue;
                    }
                } else if (ldist < rdist) {
                    lrow = row;
                    lcol = col;
                    answer += "L";
                    continue;
                } else {
                    rrow = row;
                    rcol = col;
                    answer += "R";
                    continue;
                }
            }
        }

        return answer;
    }
}
