package application.algorithm;



import application.model.Edge;
import application.model.Node;

import java.util.*;

public class Dijkstra extends GraphAlgorithm {
    public Dijkstra() {
        super();  // Gọi constructor của lớp cha
    }

    public Dijkstra(boolean directed) {
        this.directed = directed;
        nodes = new HashSet<>();
    }
    public String DijkstraShortestPath(Node start, Node end) {

        String output ="";
        HashMap<Node, Node> changedAt = new HashMap<>();
        changedAt.put(start, null);

        HashMap<Node, Double> shortestPathMap = new HashMap<>();

        for (Node node : nodes) {
            if (node == start)
                shortestPathMap.put(start, 0.0);
            else shortestPathMap.put(node, Double.POSITIVE_INFINITY);
        }

        for (Edge edge : start.edges) {
            shortestPathMap.put(edge.destination, edge.weight);
            changedAt.put(edge.destination, start);
        }

        start.visit();

        while (true) {
            Node currentNode = closestReachableUnvisited(shortestPathMap);

            if (currentNode == null) {
                return ("There isn't a path between " + start.name + " and " + end.name);
            }

            if (currentNode == end) {

                Node child = end;

                StringBuilder path = new StringBuilder(end.name);
                while (true) {
                    Node parent = changedAt.get(child);
                    if (parent == null) {
                        break;
                    }

                    path.insert(0, parent.name + "->");
                    child = parent;
                }
                output += path;

                return output;
            }
            currentNode.visit();

            for (Edge edge : currentNode.edges) {
                if (edge.destination.isVisited())
                    continue;

                if (shortestPathMap.get(currentNode)
                        + edge.weight
                        < shortestPathMap.get(edge.destination)) {
                    shortestPathMap.put(edge.destination,
                            shortestPathMap.get(currentNode) + edge.weight);
                    changedAt.put(edge.destination, currentNode);
                }
            }
        }
    }
    public Stack<Node> animatePathadj(Node start, Node end) {

        Stack<Node> path = new Stack<>();
        HashMap<Node, Node> changedAt = new HashMap<>();
        changedAt.put(start, null);

        HashMap<Node, Double> shortestPathMap = new HashMap<>();

        for (Node node : nodes) {
            if (node == start)
                shortestPathMap.put(start, 0.0);
            else shortestPathMap.put(node, Double.POSITIVE_INFINITY);
        }

        for (Edge edge : start.edges) {
            shortestPathMap.put(edge.destination, edge.weight);
            changedAt.put(edge.destination, start);
        }

        start.visit();

        while (true) {
            Node currentNode = closestReachableUnvisited(shortestPathMap);

            if (currentNode == null) {
                return null;
            }

            if (currentNode == end) {

                Node child = end;
                path.push(child);
                while (true) {
                    Node parent = changedAt.get(child);
                    if (parent == null) {
                        break;
                    }

                    path.push(parent);
                    child = parent;
                }
                return path;
            }
            currentNode.visit();

            for (Edge edge : currentNode.edges) {
                if (edge.destination.isVisited())
                    continue;

                if (shortestPathMap.get(currentNode)
                        + edge.weight
                        < shortestPathMap.get(edge.destination)) {
                    shortestPathMap.put(edge.destination,
                            shortestPathMap.get(currentNode) + edge.weight);
                    changedAt.put(edge.destination, currentNode);
                }
            }
        }
    }
    public Node closestReachableUnvisited(HashMap<Node, Double> shortestPathMap) {

        double shortestDistance = Double.POSITIVE_INFINITY;
        Node closestReachableNode = null;
        for (Node node : nodes) {
            if (node.isVisited())
                continue;

            double currentDistance = shortestPathMap.get(node);
            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;

            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                closestReachableNode = node;
            }
        }
        return closestReachableNode;
    }

}