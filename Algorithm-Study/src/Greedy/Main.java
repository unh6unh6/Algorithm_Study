package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Range range = new Range(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Range[] saveRange = new Range[1000001];
        saveRange[0] = range;
        int cntRange = 1;
        int result = range.end - range.start;
       // int result = 0;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boolean check = true;
            int canPlus = 0;
            for (int j = 0; j < cntRange; j++) {
                if(saveRange[j].start == end) {
                    for (int k = 0; k < cntRange; k++) {
                        if (k == j)
                            continue;
                        if(saveRange[k].end >= start) {
                            saveRange[k].end = saveRange[j].end;
                            saveRange[j].start = 0;
                            saveRange[j].end = 0;
                            break;
                        }
                    }
                    break;
                }
                else if(saveRange[j].end == start) {
                    for (int k = 0; k < cntRange; k++) {
                        if (k == j)
                            continue;
                        if(saveRange[k].start <= end) {
                            saveRange[k].start = saveRange[j].start;
                            saveRange[j].start = 0;
                            saveRange[j].end = 0;
                            break;
                        }
                    }
                    break;
                }
                else if(saveRange[j].start <= end && saveRange[j].start >= start && saveRange[j].end >= end) {
                    result += (saveRange[j].start - start);
                    saveRange[j].start = start;
                    check = false;
                    break;
                }
                else if(saveRange[j].end <= end && saveRange[j].end >= start && saveRange[j].start <= start) {
                    result += (end - saveRange[j].end);
                    saveRange[j].end = end;
                    check = false;
                    break;
                }
                else if(saveRange[j].start <= start && saveRange[j].end >= end) {
                    check = false;
                    break;
                }
                else if(saveRange[j].start >= start && saveRange[j].end <= end) {
                    result += (end - start);
                    saveRange[j].start = start;
                    saveRange[j].end = end;
                    check = false;
                    break;
                }
            }
            if(check) {
                result += (end - start);
                saveRange[cntRange++] = new Range(start, end);
            }

            for (int j = 0; j < cntRange; j++) {
                System.out.println("result : " + result);
                System.out.println(saveRange[j].start + "  /  " + saveRange[j].end);
            }
            System.out.println("-------------------------------------");
        }

//        for (int i = 0; i < cntRange; i++) {
//            result += ( saveRange[i].end - saveRange[i].start );
//        }
        System.out.println(result);
    }

    boolean canPlus(int num) {
        return num<2;
    }
}

class Range {
    int start, end;
    Range(int start, int end){
        this.start = start;
        this.end = end;
    }
}
