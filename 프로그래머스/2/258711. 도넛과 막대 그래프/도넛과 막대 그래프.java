import java.util.*;
class Solution {

    public int[] solution(int[][] edges) {
                Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();

        // 1. 간선 정보 기반으로 in-degree, out-degree 계산
        for (int[] e : edges) {
            out.put(e[0], out.getOrDefault(e[0], 0) + 1);
            in.put(e[1], in.getOrDefault(e[1], 0) + 1);
            nodes.add(e[0]);
            nodes.add(e[1]);
        }

        int n = -1, a1 = 0, a2 = 0, a3 = 0;

        // 2. n 찾기
        for (int node : nodes) {
            int outDegree = out.getOrDefault(node, 0);
            int inDegree = in.getOrDefault(node, 0);
            if (inDegree == 0 && outDegree >= 2) {
                n = node;
                break;
            }
        }

        // 3. n에서 뻗어나가는 그래프 판별
        for (int node : nodes) {
            if (node == n) continue;

            int outDegree = out.getOrDefault(node, 0);
            int inDegree = in.getOrDefault(node, 0);

            // 막대
            if (outDegree == 0 && inDegree > 0) {
                a2++;
            }
            // 8자
            else if (outDegree >= 2) {
                a3++;
            }
            // 도넛
            else if (outDegree == 1 && inDegree == 1) {
                // 도넛 개수는 나중에 계산
            }
        }

        // 도넛 개수 = n에서 나가는 간선 수 - 막대 - 8자
        a1 = out.get(n) - a2 - a3;

        return new int[]{n, a1, a2, a3};
    }

}