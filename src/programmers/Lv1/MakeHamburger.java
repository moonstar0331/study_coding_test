package programmers.Lv1;

import java.util.*;

// 햄버거 만들기
public class MakeHamburger {
    public int solution(int[] ingredient) {
        int answer = 0;
        // 재료는 아래서부터 위로 쌓임
        // 빵-야채-고기-빵으로 쌓은 햄버거만 포장
        // 재료의 높이는 무시
        // 1 : 빵, 2: 야채, 3 : 고기
        Stack<Integer> stack = new Stack<>();

        for(int ingre : ingredient) {
            stack.push(ingre);

            if(stack.size() >= 4) {
                if(stack.get(stack.size()-4)==1 &&
                        stack.get(stack.size()-3)==2 &&
                        stack.get(stack.size()-2)==3 &&
                        stack.get(stack.size()-1)==1) {
                    answer++;
                    for(int i=1; i<=4; i++) {
                        stack.pop();
                    }
                }
            }
        }

        return answer;
    }
}
