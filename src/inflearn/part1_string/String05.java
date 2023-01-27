package inflearn.part1_string;

import java.util.Scanner;

public class String05 {

    public String solution(String str) {
        String answer = "";

        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while(lt<rt) {
            if (!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);

        return answer;
    }

    public static void main(String[] args) {
        String05 T = new String05();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }
}
