package 정답코드;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승택시_다익스트라 {
    int N; int fareSize;
    int[][] matrix;

    public int[] dijkstra(int start) {
        //bfs형태니까 우선순위큐 사용을 위해 pq선언
        //java는 튜플 대신에 int[]식으로 배열 사용
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[N];

        //다익스트라 핵심 배열
        int[] distance = new int[N];

        //동일한값으로 초기화할때
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        //실제로 거리가 쓰이는 일은 없지만 가까운순으로 접근하기 위해서 넣어놓은것임(우선순위용)
        pq.add(new int[] {0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int cv = cur[1];
            if (visited[cv]) {
                continue;
            }
            visited[cv] = true;

            for (int nv = 0; nv < N; nv++) {
                //서로 연결점이없는경우
                if(matrix[cv][nv] == 0) {
                    continue;
                }
                //서로 연결된 경우: 기존 vs 현재에서 이동
                if (distance[cv] + matrix[cv][nv] < distance[nv]) {
                    distance[nv] = distance[cv] + matrix[cv][nv];
                    pq.add(new int[]{distance[nv], nv});
                }
            }
        }

        return distance;
    }

    //n-지점개수, s-출발지점, a-a의 도착지점, b-b의 도착지점
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        fareSize = fares.length;
        matrix = new int[n][n];

        //인접 행렬 생성
        for (int i = 0; i < fareSize; i++) {
            int v1= fares[i][0] - 1;
            int v2 = fares[i][1] - 1;
            int cost = fares[i][2];
            matrix[v1][v2] = cost;
            matrix[v2][v1] = cost;
        }

        //a나 b나 시작점이 같으니까 거기서 모든 곳까지의 최단거리를 먼저 구함
        int[] together = dijkstra(s - 1);
        int minCost = Integer.MAX_VALUE;

        //둘이 나누어져서 갈때의 위치를 구하기 위함
        for(int i = 0; i < N; i++) {
            //i노드에서 다른 노드로의 거리
            int[] alone = dijkstra(i);

            //i까지 같이가고, 거기서부터 a하고 b로 흩어지는거니까 합쳐서 계산
            int cost = together[i] + alone[a - 1] + alone[b - 1];
            if(cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }
}
