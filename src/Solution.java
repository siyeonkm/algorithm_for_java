/*
두 큐끼리 원소의 수가 같은 필요는 없음
큐의 합이 작으면 다른큐에서 하나 빼와서 넣어보고, 줄이고 하는식으로 하면 될듯
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int getSum(int[] queue1, int[] queue2) {
        long sum = 0;
        for(int q : queue1){
            sum += q;
        }
        for(int q : queue2){
            sum += q;
        }
        sum /= 2;
        return sum;
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum = getSum(queue1, queue2);

        Deque<Integer> deq1 = new ArrayDeque<Integer>();

        Deque<Integer> deq2 = new ArrayDeque<>();

        long q1Sum = IntStream.of(changedQ1).sum();
        long q2Sum = IntStream.of(changedQ1).sum();

        if (q1Sum > sum){
            int x = changedQ1.
        }


        return answer;
    }
}
