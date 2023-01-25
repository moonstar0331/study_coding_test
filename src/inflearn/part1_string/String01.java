package inflearn.part1_string;

import java.util.Scanner;

public class String01 {

    public int solution(String str, char c) {
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        // 방법 1 : for 문 사용
        /*
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == c)
                answer++;
        }
        */

        // 방법 2 : for-each 문 사용
        for (char x : str.toCharArray()) {
            if (x == c)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String01 T = new String01();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}
