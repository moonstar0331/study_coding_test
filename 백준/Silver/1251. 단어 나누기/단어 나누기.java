import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static List<String> list;

    static void input() {
        str = scan.nextLine();
        list = new ArrayList<>();
    }

    static void pro() {
        for(int i=1; i<=str.length()-2; i++) {
            for(int j=i+1; j<=str.length()-1; j++) {
                String first = str.substring(0, i);
                String second = str.substring(i, j);
                String third = str.substring(j);

                StringBuffer fsb = new StringBuffer(first);
                String firstReverse = fsb.reverse().toString();
                StringBuffer ssb = new StringBuffer(second);
                String secondReverse = ssb.reverse().toString();
                StringBuffer tsb = new StringBuffer(third);
                String thirdReverse = tsb.reverse().toString();

                list.add(firstReverse + secondReverse + thirdReverse);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        input();
        pro();
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