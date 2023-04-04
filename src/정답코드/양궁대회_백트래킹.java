package 정답코드;

public class 양궁대회_백트래킹 {
    int[] apeach = new int[11];
    int[] answer = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int max = 0;


    public boolean compare(int[] ryan) {
        for(int i = 10; i >= 0; i--) {
            if (answer[i] == -1) return true;
            if(ryan[i] > answer[i]) return true;
            else if (ryan[i] < answer[i]) return false;
        }
        return false;
    }

    public void calculate(int[] ryan) {
        int totalR = 0;
        int totalA = 0;
        for(int i = 0; i < 11; i++) {
            if(ryan[i] > apeach[i]) totalR += (10-i);
            else if(apeach[i] > 0) totalA += (10-i);
        }

        int diff = totalR - totalA;
        if (diff > 0 && max <= diff) {
            if(max == diff && !compare(ryan)) return;
            max = diff;
            for(int i =0; i< 11; i++) {
                answer[i] = ryan[i];
            }
            //answer = ryan; 이렇게 넣으면 동기화되버림
            //System.out.println(Arrays.toString(ryan) + " " + diff);
        }
    }

    //dfs 백트래킹식으로 구현
    public void shoot(int arrow, int idx, int[] ryan) {
        if(arrow==0 || idx == 11) {
            ryan[10] += arrow;
            calculate(ryan);
            ryan[10] -= arrow;
            return;
        }

        if (arrow > apeach[idx]) {
            ryan[idx] += apeach[idx]+1;
            shoot(arrow-(apeach[idx]+1), idx+1, ryan);
            ryan[idx] -= apeach[idx]+1;
        }
        shoot(arrow, idx+1, ryan);
    }

    public int[] solution(int n, int[] info) {
        apeach = info;
        int[] ryan = new int[11];
        shoot(n, 0, ryan);

        if(answer[0] == -1) {
            return new int[]{-1};
        }
        return answer;
    }
}
