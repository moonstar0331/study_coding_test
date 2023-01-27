package inflearn.part1_string;

import java.util.Scanner;

class String07 {

    public String solution(String str) {
        String answer = "";
        str = str.toLowerCase();
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while(lt < rt) {
            if (s[lt] == s[rt]) {
                answer = "YES";
            } else {
                answer = "NO";
                break;
            }
            lt++;
            rt--;
        }

        return answer;
    }

    public static void main(String[] args) {
        String07 T = new String07();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
