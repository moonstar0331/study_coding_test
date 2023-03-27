package programmers.Lv1;

public class Kakao_newIdRecommendation {
    public String solution(String new_id) {

        // 규칙에 맞지 않는 아이디 -> 규칙에 맞게 아이디 추천
        // 길이는 3자 이상 15자 이하
        // 소문자, 숫자, -, _, . 만 사용 가능
        // .는 처음과 끝에 사용 x

        // new_id 소문자로 치환
        new_id = new_id.toLowerCase();

        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        new_id = new_id.replaceAll("[^a-z0-9_.-]", "");

        // 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");

        // 마침표가 처음이나 마지막이면 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        // 빈 문자열이면 "a"를 대입
        if(new_id.length() == 0) new_id+="a";

        // 16자 이상이면 첫 15개 문자 제외하고 제거
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            // 제거 후 마침표가 마지막이면 마침표도 제거
            new_id = new_id.replaceAll("\\.$", "");
        }

        // 길이가 2자 이하면 길이가 3이 될 때까지 반복해서 끝에 붙임
        while(new_id.length()<=2) {
            new_id += new_id.charAt(new_id.length()-1);
        }

        return new_id;
    }
}
