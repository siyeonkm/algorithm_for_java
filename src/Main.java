public class Main {
    public static void main(String[] args) {
        int n=6, s=4, a=6, b=2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        Solution solution = new Solution();
        int output = solution.solution(n, s, a, b, fares);
        System.out.println(output);
    }
}