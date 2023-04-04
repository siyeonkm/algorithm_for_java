import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[][] graph;

    public void print(int[] result) {
        String output = "";
        for (int r : result) {
            output += r + " "
        }
        System.out.println(output);
    }

    public int[] bfs(n, v, int[] graph) {
        Queue<Integer> q = new ArrayDeque<>();

    }

    public int[] dfs(n, v, int[] graph) {

    }

    public void solution(n, v, int[] info) {
        for(int i=0; i<info.length; i++) {
            int a = info[i][0];
            int b = info[i][1];
            graph[a][b] = graph[b][a] = 1;
        }

        int[] result = bfs(v);
        print(result);

        rsult = dfs(v);
        print(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] input = new int[m][2];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readline(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(n, v, input);

    }
}