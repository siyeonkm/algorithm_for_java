/*
두 큐끼리 원소의 수가 같은 필요는 없음
큐의 합이 작으면 다른큐에서 하나 빼와서 넣어보고, 줄이고 하는식으로 하면 될듯
*/

import java.util.*;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> deq1 = new ArrayDeque<>();
        Queue<Integer> deq2 = new ArrayDeque<>();
        int cnt = 0;

        long s1=0, s2=0, sum;
        for (int tmp : queue1) {deq1.add(tmp); s1+=tmp;}
        for (int tmp : queue2) {deq2.add(tmp); s2+=tmp;}
        sum = s1+s2;
        if (sum%2 == 1) return -1;
        else sum /=2;

        while(cnt<=queue1.length*4 && deq1.size() < queue1.length*2 && deq1.size() != 0) {
            if (s1 == sum) return cnt;

            else if (s1 > sum) {
                s1-=deq1.peek();
                s2+=deq1.peek();
                deq2.add(deq1.remove());
                cnt++;
            }
            else if (s1 < sum && s1 > 0){
                s2-=deq2.peek();
                s1+=deq2.peek();
                deq1.add(deq2.remove());
                cnt++;
            }
        }
        return -1;
    }
}
