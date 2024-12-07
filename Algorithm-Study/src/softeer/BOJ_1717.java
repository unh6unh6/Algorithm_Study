package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {

    static int[] unionFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unionFind = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            unionFind[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String flag = st.nextToken();
            int val1 = Integer.parseInt(st.nextToken());
            int val2 = Integer.parseInt(st.nextToken());

            if(flag.equals("0"))
                union(val1, val2);

            else if(flag.equals("1")) {
                if (isSameGroup(val1, val2))
                    System.out.println("YES");
                else {
                    System.out.println("NO");
                }
            }
        }
    }

    static int find(int val) {
        if(unionFind[val] == -1)
            return val;
        return find(unionFind[val]);
    }
    static void union(int val1, int val2) {
        int val1Group = find(val1);
        int val2Group = find(val2);

        if(val1Group != val2Group)
            unionFind[val2Group] = val1Group;
    }

    static boolean isSameGroup(int val1, int val2) {
        return find(val1) == find(val2);
    }

}
