package BinarySearch;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class BOJ_2805 {

    static int[] tree;
    static int nearHeight = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        tree = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
        System.out.println(search(0, max, m));

    }
    static int search(int low, int high, int target) {
        int mid = (low + high) / 2;
        if(low > high)
            return nearHeight;

        long length = getTreeLength(mid);

        if(length > target) {
            if(mid > nearHeight)
                nearHeight = mid;
            return search(mid + 1, high, target);
        }
        else if(length < target)
            return search(low, mid-1, target);
        return mid;
    }
    static long getTreeLength(int height) { // 나무 길이를 다 더하는 부분에서 int 범위 넘을 수 있었다..
        long length = 0;
        for(int tree : tree) {
            if(height < tree)
                length += (tree - height);
        }
        return length;
    }
}
