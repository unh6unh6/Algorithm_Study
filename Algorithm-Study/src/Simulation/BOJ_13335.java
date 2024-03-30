package Simulation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
        int n;
        int w; // 다리길이
        int l; // 다리 최대하중
        LinkedList<Integer> truck = new LinkedList<>();
        LinkedList<Integer> bridgeTruck = new LinkedList<>();
        LinkedList<Integer> currentTruck = new LinkedList<>();

        int time = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        int bridgeWeight = 0;
        while(!truck.isEmpty() || !bridgeTruck.isEmpty()) { // 단위시간 당 루프 1번

            System.out.println("시간 : " + time);
            System.out.println("다리 위 트럭 / 트럭 위치");
            System.out.println(bridgeTruck);
            System.out.println(currentTruck);
            System.out.println("남은 트럭");
            System.out.println(truck);
            System.out.println("---------------------");

            if(!bridgeTruck.isEmpty() && currentTruck.peekFirst() == w) {
                bridgeWeight -= bridgeTruck.pollFirst();
                currentTruck.pollFirst();
            }

            if( !truck.isEmpty() && (bridgeWeight + truck.peekFirst()) <= l) {
                bridgeWeight += truck.peekFirst();
                bridgeTruck.offerLast(truck.pollFirst());
                currentTruck.offerLast(0);
            }
            for (int i = 0; i < currentTruck.size(); i++)
                currentTruck.set(i, currentTruck.get(i) + 1);
            time ++;
        }
        System.out.println(time);
    }
}
