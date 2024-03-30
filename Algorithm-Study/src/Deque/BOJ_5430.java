package Deque;

import java.io.*;
import java.util.*;

public class BOJ_5430 {
    public static int function(char functionType, LinkedList<Integer> deque, int status) {
        if(functionType == 'R' && !deque.isEmpty())
            return status * (-1);

        else if(functionType == 'D') {
            if(deque.isEmpty())
                return 2;
            else if(status == -1)
                deque.pollFirst();
            else if(status == 1)
                deque.pollLast();
        }
        return status;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(; t>0; t--) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String num = st.nextToken(",");
                if(n == 1)
                    num = num.substring(1, num.length()-1);
                else if(i == 0)
                    num = num.substring(1);
                else if(i == n-1)
                    num = num.substring(0, num.length()-1);
                deque.offerLast(Integer.parseInt(num));
            }
            boolean isError = false;
            int status = -1; // -1 : front, 1 : end, 2 : error
            for (int i = 0; i < p.length(); i++) {
                status = function(p.charAt(i), deque, status);
                if(status == 2) {
                    isError = true;
                    break;
                }
            }
            if(status == 1)
                Collections.reverse(deque);
            if(isError)
                result.append("error\n");
//            else if (status == -1){
//                result.append("[");
//                for(int num : deque)
//                    result.append(num).append(",");
//                result.deleteCharAt(result.toString().length()-1);
//                result.append("]\n");
//            }
//            else {
//                result.append("[");
//                while(!deque.isEmpty()) {
//                    result.append(deque.pollLast()).append(",");
//                }
//                result.deleteCharAt(result.toString().length()-1);
//                result.append("]\n");
//            }
            else
                result.append(deque.toString()).append("\n");
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
