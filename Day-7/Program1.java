import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String rawTickets[] = scn.nextLine().split(",");
        String tickets[][] = new String[rawTickets.length][];

        for (int i = 0; i < rawTickets.length; i++) {
            tickets[i] = rawTickets[i].split(" ");
        }

        Graph graph = new Graph(tickets);

        System.out.println(graph.Traverse("BZA"));

        scn.close();
    }
}

class Graph {
    class Node {
        String val;
        int outDegree;
        ArrayList<String> links;

        Node(String val) {
            outDegree = 0;
            this.val = val;
            links = new ArrayList<String>();
        }
    }

    HashMap<String, Node> nodes;
    int size;

    Graph(String[][] tickets) {
        nodes = new HashMap<>();
        size = tickets.length + 1;
        for (String[] ticket : tickets) {
            if (!nodes.containsKey(ticket[0]))
                nodes.put(ticket[0], new Node(ticket[0]));
            if (!nodes.containsKey(ticket[1]))
                nodes.put(ticket[1], new Node(ticket[1]));

            nodes.get(ticket[0]).links.add(ticket[1]);
            nodes.get(ticket[0]).outDegree += 1;
        }

        for (String key : nodes.keySet()) {
            Collections.sort(nodes.get(key).links);
        }
    }

    List<String> Traverse(String start) {
        List<String> result = new ArrayList<>(size + 1);

        Node curr = nodes.get(start);
        Node next = null;
        do {
            // System.out.print(curr.val + "->");
            result.add(curr.val);
            next = null;
            for (String link : curr.links) {
                next = nodes.get(link);
                if (next.outDegree > 0)
                    break;
            }

            if (next == null)
                break;

            curr.links.remove(next.val);
            curr.outDegree--;

            curr = next;
        } while (result.size() <= size);

        return result;
    }
}