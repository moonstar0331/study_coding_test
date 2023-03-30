package programmers.Lv1;

import java.util.*;

// Lv1 - 2022 카카오 블라인드 채용 - 신고 결과 받기
public class Kakao_ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 신고당한 것을 저장
        HashMap<String, HashSet<String>> toMap = new HashMap<>();
        // 신고한 것을 저장
        HashMap<String, HashSet<String>> fromMap = new HashMap<>();

        for(int i=0; i<id_list.length; i++) {
            toMap.put(id_list[i], new HashSet<String>());
            fromMap.put(id_list[i], new HashSet<String>());
        }

        // report를 한 번씩 돌면서
        for(int i=0; i<report.length; i++) {
            String from = report[i].split(" ")[0];
            String to = report[i].split(" ")[1];
            // 각 유저마다 신고한 유저를 저장
            fromMap.get(from).add(to);
            // 신고당한 유저에 신고한 유저를 저장
            toMap.get(to).add(from);
        }

        // 신고한 유저 수를 신고횟수로 확인
        for(int i=0; i<id_list.length; i++) {
            if(toMap.get(id_list[i]).size() >= k) {
                for(int j=0; j<id_list.length; j++) {
                    if(i==j) continue;
                    if(fromMap.get(id_list[j]).contains(id_list[i])) {
                        answer[j]++;
                    }
                }
            }
        }

        return answer;
    }
}
