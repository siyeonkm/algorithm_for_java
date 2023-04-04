package 정답코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {
    static int[][] graph;

    public static void print(ArrayList<Integer> result) {
        String output = "";
        for (int r : result) {
            output += r + " ";
        }
        System.out.println(output);
    }

    public static ArrayList<Integer> bfs(int n, int v) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int cur = q.remove();
            answer.add(cur);

            for(int i = 1; i <n+1; i++) {
                if(graph[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return answer;
    }

    //dfs는 들어가고, 거기서 또 파생으로 들어가고를 반복하니까
    //이전 node랑 연결돼있어서 stack에 넣었지만, stack에서 해당값을 꺼내기 전에
    //다른 node에서 먼저 도달할 수도 있음.
    //그러므로 넣을때 visit check를 하면 안됨.
    //다만 그냥 누가 먼저랄거 없이 다 탐색하는게 목적인 문제면 집어넣을때 check해도 문제는 없음
    public static ArrayList<Integer> dfs(int n, int v) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        s.add(v);

        while(!s.isEmpty()) {
            int cur = s.pop();
            if(!visited[cur]) {
                visited[cur] = true;
                answer.add(cur);
            }
            else continue;

            for(int i=n; i>=0; i--) {
                if(graph[cur][i] == 1 && !visited[i]) {
                    s.push(i);
                }
            }
        }
        return answer;
    }

    public static void solution(int n, int v) {
        ArrayList<Integer> result = dfs(n, v);
        print(result);

        result = bfs(n, v);
        print(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        solution(n, v);
    }
}
