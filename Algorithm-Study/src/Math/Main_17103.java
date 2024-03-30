package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17103 {
    static int[] prime = new int[1000001];
    static int index = 0;
    public static void main(String[] args) throws IOException {
        prime[0] = 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println(cntGold(Integer.parseInt(br.readLine())));
        }
    }
    static int cntGold(int num) {
        generatePrimeArr(num);
        int cnt = 0;
        for (int i = 0; i <= index; i++) {
            for (int j = i; j <= index; j++) {
                if(prime[i] + prime[j] == num)
                    cnt++;
            }
        }
        return cnt;
    }

    static void generatePrimeArr(int num) {
        int primeNum = prime[index] + 1;
        while(num > primeNum) {
            if(isPrime(primeNum))
                prime[++index] = primeNum;
            primeNum++;
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
