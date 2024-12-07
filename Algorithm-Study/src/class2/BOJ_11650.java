package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Pos> posList = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            posList.add(new Pos(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < n; i++) {
            Pos pos = posList.remove();
            sb.append(pos.x).append(" ").append(pos.y).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

class Pos implements Comparable<Pos> {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pos o) {
        if (this.x != o.x) {
            return Integer.compare(this.x, o.x);
        }
        return Integer.compare(this.y, o.y);
    }
}
