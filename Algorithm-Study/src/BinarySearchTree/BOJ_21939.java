package BinarySearchTree;

import java.io.*;
import java.util.*;

// 19:15

public class BOJ_21939 {
    public static void main(String[] args) throws IOException {
        TreeSet<Problem> treeSet = new TreeSet<>();
        HashMap<Integer, Problem> hashMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p,l);
            treeSet.add(problem);
            hashMap.put(p, problem);
        }
        int m = Integer.parseInt(br.readLine());
        while(m-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String prompt = st.nextToken();

            if(prompt.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(p,l);
                treeSet.add(problem);
                hashMap.put(p, problem);
            }
            else if(prompt.equals("recommend")) {
                int num = Integer.parseInt(st.nextToken());
                Problem prob;
                if(num == 1) {
                    prob = treeSet.last();
                    bw.write(((Integer)prob.p).toString());
                    bw.newLine();
                }
                else {
                    prob = treeSet.first();
                    bw.write(((Integer)prob.p).toString());
                    bw.newLine();
                }
            }
            else if(prompt.equals("solved")){
                int findProb = Integer.parseInt(st.nextToken());
                treeSet.remove(hashMap.get(findProb));
            }
        }
        bw.flush();
        bw.close();
    }
}

class Problem implements Comparable<Problem>{
    int p;
    int l;
    Problem(int p, int l) {
        this.p = p;
        this.l = l;
    }

    @Override
    public int compareTo(Problem problem) {
        if(this.l == problem.l)
            return Integer.compare(this.p, problem.p);

        return Integer.compare(this.l, problem.l);
    }
}
