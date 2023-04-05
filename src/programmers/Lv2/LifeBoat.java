package programmers.Lv2;

import java.util.*;

// Lv2. 구명보트
public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int lt = 0;
        int rt = people.length - 1;
        while(lt <= rt) {
            if(people[lt] + people[rt] > limit) {
                answer++;
                rt--;
                continue;
            } else {
                answer++;
                lt++;
                rt--;
            }
        }

        return answer;
    }
}
