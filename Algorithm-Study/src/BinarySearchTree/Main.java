package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Member> queue = new PriorityQueue<>();
        while(n-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            queue.add(new Member(height, cnt));
        }

        /**
        if(queue.size() == 1) {
            System.out.println(1);
            return;
        }
        **/

        int cntTeam = 1;
        Team thisTeam = new Team(queue.poll());
        while(!queue.isEmpty()) {
            if(thisTeam.cnt > 0) {
                thisTeam.newMember(queue.poll());
            }
            else if(thisTeam.cnt == 0) {
                thisTeam = new Team(queue.poll());
                cntTeam++;
            }
        }
        System.out.println(cntTeam);
    }
}
class Team {
    int cnt;
    ArrayList<Member> saveMember = new ArrayList<>();

    void newMember(Member member) {
        cnt = (member.cnt - 1) > (cnt - 1) ? cnt - 1 : member.cnt - 1;
        saveMember.add(member);
    }
    Team(Member member) {
        cnt = member.cnt - 1;
        saveMember.add(member);
    }
}

class Member implements Comparable<Member> {
    int height;
    int cnt;
    Member(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Member member) {
        return this.height - member.height;
    }
}
