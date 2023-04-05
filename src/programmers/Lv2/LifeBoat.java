package programmers.Lv2;

import java.util.*;

// Lv2. 구명보트
public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] check = new int[people.length];

        Arrays.sort(people);

        int lt = 0;
        int rt = people.length - 1;
        while(lt <= rt) {
            if(check[lt] == 1) {
                lt++;
                continue;
            } else if(check[rt] == 1) {
                rt--;
                continue;
            } else {
                if(people[lt] + people[rt] > limit) {
                    answer++;
                    check[rt--] = 1;
                    continue;
                } else {
                    answer++;
                    check[lt++] = 1;
                    check[rt--] = 1;
                    continue;
                }
            }
        }

        return answer;
    }
}
