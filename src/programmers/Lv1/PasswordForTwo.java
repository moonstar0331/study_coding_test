package programmers.Lv1;

import java.util.*;

// 둘만의 암호
public class PasswordForTwo {
    public String solution(String s, String skip, int index) {
        String answer = "";

        ArrayList<Character> skipList = new ArrayList<>();
        for(char x : skip.toCharArray()) {
            skipList.add(x);
        }

        // s 의 각 알파벳을 Index 만큼 뒤의 알파벳으로 변경
        // z 를 넘어가면 다시 a부터 시작
        // skip에 있는 알파벳은 제외
        for(char x : s.toCharArray())  {
            int i=1;
            while(i<=index) {
                x+=1;
                if(x>'z') x-=26;
                if(skipList.contains(x)) continue;
                i++;
            }
            answer+=x;
        }
        return answer;
    }
}
