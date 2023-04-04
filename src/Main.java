import java.io.*;
import java.util.*;

//문제가 되게 독특하다.
//dp의 idx는 0 ~ k로 연속적인 정수의 무게값으로 생각함.
//j의 값은 가방에 그만큼의 무게를 넣는다고 했을때 가능한 value는? 임
//j=3일때 넣을 수 있는 값이 있고, 4는 없을때 dp[4]에는 3의 값을 그대로 넣어줌
public class Main {
    static int[][] item;

    //흔한 냅색문제 + dp라고 한다. 알아두자.
    static int solution(int n, int max) {
        //물품수는 최대 100개임
        int[] dp = new int[max+1];

        for(int i=0; i<=n; i++) {
            //j는 가방 남은 무게가 현재 넣을 item보다 많아야 진행한다는 뜻
            for(int j=max; j>=item[i][0]; j--) {
                dp[j] = Math.max(dp[j - item[i][0]]+item[i][1], dp[j]);
            }
        }
        return dp[max];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        item = new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }
        int output = solution(n, k);
    }
}