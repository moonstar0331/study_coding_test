import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    // 서로 다른 L개의 알파벳 소만주
    // 최소 한 개의 모음(a, e, i, o, u)
    // 최소 2 개의 자음
    // 정렬된 순서
    // C 가지의 후보, 가능성 있는 암호들을 모두 구하라
    
    static int N, M;
    static char[] chars;
    static int[] selected;

    
    static void input() {
        FastReader scan = new FastReader();
        M = scan.nextInt();
        N = scan.nextInt();
        chars = new char[N + 1];
        selected = new int[M + 1];
        String[] tokens = scan.nextLine().split(" ");
        for (int i = 1; i <= N; i++) {
            chars[i] = tokens[i - 1].charAt(0);
        }
    }
    
    static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }
    
    static void rec_func(int k) {
        if(k == M + 1) {
            int vowel = 0, consonant = 0;
            for(int i=1; i<=M; i++) {
                if(isVowel(chars[selected[i]])) vowel++;
                else consonant++;
            }
            
            if(vowel >= 1 && consonant >= 2) {
                for(int i=1; i<=M; i++) sb.append(chars[selected[i]]);
                sb.append('\n');
            }
        } else {
            for(int cand = selected[k-1]+1; cand<=N; cand++) {
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        input();
        Arrays.sort(chars, 1, N+1);
        rec_func(1);
        System.out.println(sb.toString());
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }
        
        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}