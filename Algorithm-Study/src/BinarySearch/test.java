package BinarySearch;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        Arrays.binarySearch(arr, 5);
    }
}
