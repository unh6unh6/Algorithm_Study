package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int number = 1;

        for (int i = 0; i < n; i++) {
            int thisNumber = numbers[i];
            if (number <= thisNumber) {
                while(number <= thisNumber) {
                    stack.push(number++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");

            }

            else if(number > thisNumber) {
                int popNumber = stack.pop();
                if (popNumber != thisNumber) {
                    System.out.println("NO");
                    return;
                } else {
                    sb.append("-").append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
