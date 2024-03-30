package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    public static int n;
    public static int[] num;
    public static int[] numOperator;
    public static int[] operator = new int[4]; // 연산자 총 개수 : n-1개

    public static int max = -1000000001;
    public static int min = 1000000001;


    public static int calculator() {
        int result = num[0];
        for (int i = 0; i < n-1; i++) {
            if(numOperator[i] == 0)
                result += num[i+1];
            else if(numOperator[i] == 1)
                result -= num[i+1];
            else if(numOperator[i] == 2)
                result *= num[i+1];
            else if(numOperator[i] == 3)
                result /= num[i+1];
        }
        return result;
    }
    public static void recursion(int index, int[] operator) {
        if(index == n-1) {
            int result = calculator();
            if(max < result)
                max = result;
            if(min > result)
                min = result;
            return;
        }
        int[] newOperator = operator.clone();
        for (int i = 0; i < 4; i++) {
            if (newOperator[i] > 0) {
                numOperator[index] = i;
                newOperator[i]--;
                recursion(index+1, newOperator);
                newOperator[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());
        numOperator = new int[n-1];

        recursion(0, operator);
        System.out.println(max);
        System.out.println(min);
    }
}

