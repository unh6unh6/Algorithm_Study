package LinkedList;

import java.io.*;
import java.util.*;

public class BOJ_1406 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++)
            list.add(str.charAt(i));

        int m = Integer.parseInt(br.readLine());
        int cur = list.size();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String token1 = st.nextToken();
            if(token1.equals("L") && cur != 0 )
                cur--;
            else if(token1.equals("D") && cur != list.size())
                cur++;
            else if(token1.equals("B") && cur != 0)
                list.remove(--cur);
            else if(token1.equals("P"))
                list.add(cur++, st.nextToken().charAt(0));
        }
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
