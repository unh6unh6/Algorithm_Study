package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split("");

            boolean errorFlag = false;
            Stack<Integer> stack = new Stack<>();
            for(String s : input) {
                if(s.equals("("))
                    stack.push(1);
                else if(s.equals(")")) {
                    if(stack.isEmpty()) {
                        errorFlag = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty() && !errorFlag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
