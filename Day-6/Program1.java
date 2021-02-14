import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int c = scn.nextInt();

        int edges[][] = new int[c][2];

        for (int i = 0; i < c; i++) {
            edges[i][0] = scn.nextInt();
            edges[i][1] = scn.nextInt();
        }

        System.out.println(getOrder(k, edges));

        scn.close();
    }

    static Set<Integer> getOrder(int k, int edges[][]) {
        Graph graph = new Graph(k);
        graph.addEdges(edges);
        return graph.topologicalSort();
    }
}

class Graph {
    static class Node {
        int inDegree;
        List<Node> links;

        Node() {
            inDegree = 0;
            links = new ArrayList<Node>();
        }
    }

    Node nodes[];

    Graph(int n) {
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
    }

    void addEdges(int[][] edges) {
        for (int[] edge : edges) {
            nodes[edge[1]].links.add(nodes[edge[0]]);
            nodes[edge[0]].inDegree += 1;
        }
    }

    Set<Integer> topologicalSort() {
        Set<Integer> result = new LinkedHashSet<>(nodes.length);
        boolean flag = true;

        while (flag && result.size() != nodes.length) {
            flag = false;
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].inDegree == 0 && !result.contains(i)) {
                    flag = true;
                    for (Node link : nodes[i].links) {
                        link.inDegree -= 1;
                    }
                    result.add(i);
                }
            }
        }

        if (result.size() != nodes.length)
            result.clear();

        return result;
    }
}