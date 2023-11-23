package LinkedList;

import java.io.*;
import java.util.*;

public class Main {

    /** 시간초과 ㅋㅋㅋ **/
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char arr[] = br.readLine().toCharArray();
        List<Character> list = new LinkedList<>();
        for(char c : arr)
            list.add(c);
        int m = Integer.parseInt(br.readLine());
        int cur = arr.length;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String token1 = st.nextToken();
            if(token1.equals("L") && cur != 0 )
                cur--;
            else if(token1.equals("D") && cur != list.size())
                cur++;
            else if(token1.equals("B") && cur != 0)
                list.remove(--cur);
            else if(token1.equals("P")) {
                char add = st.nextToken().charAt(0);
                list.add(cur++, add);
            }
        }
        for (int i = 0; i < list.size(); i++)
            bw.write(String.valueOf(list.get(i)));
        bw.flush();
        bw.close();
    }
}
