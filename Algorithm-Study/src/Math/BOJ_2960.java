package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 2; i <= n; i++)
            list.offerLast(i);
        int cnt = 0;
        int saveLast = -1;
        int index = 0;
        while(!list.isEmpty()) {
            int num = list.get(index);
            if(!isPrime(num)) {
                index ++;
                continue;
            }
            int mult = 2;
            int multNum = num;
            while(!list.isEmpty() && list.getLast() >= multNum && cnt < k) {
                if(list.contains(multNum)) {
                    saveLast = list.remove(list.indexOf(multNum));
                    cnt ++;
                }
                multNum = num;
                multNum *= mult;
                mult ++;
            }
            if(cnt == k)
                break;
        }
        System.out.println(saveLast);
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
