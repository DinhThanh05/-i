package application.algorithm;


import application.model.Edge;
import application.model.Node;
import java.util.*;

//public class BellmanFord extends GraphAlgorithm {
//
//    public BellmanFord() {
//        super();  // Gọi constructor của lớp cha
//    }
//
//    public  BellmanFord (boolean directed) {
//        this.directed = directed;
//        nodes = new HashSet<>();
//    }
//
//    public Stack<String> getNodePath(application.model.Node source, application.model.Node target) {
//        Stack<String> path = new Stack<>();
//        Map<Node, Double> distance = new HashMap<>();
//        Map<Node, Node> predecessor = new HashMap<>();
//
//        for (Node node : nodes) {
//            distance.put(node, Double.POSITIVE_INFINITY);
//        }
//        distance.put(source, 0.0);
//
//        // Relax tất cả các cạnh |V| - 1 lần
//        for (int i = 0; i < nodes.size() - 1; i++) {
//            for (Node node : nodes) {
//                for (Edge edge : node.getEdge()) {
//                    if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
//                        distance.put(edge.getDestination(), distance.get(node) + edge.getWeight());
//                        predecessor.put(edge.getDestination(), node);
//                    }
//                }
//            }
//        }
//
//        for (Node node : nodes) {
//            for (Edge edge : node.getEdge()) {
//                if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
//                    return null;
//                }
//            }
//        }
//
//        Node current = target;
//        while (current != null) {
//            path.push(current.getName());
//            current = predecessor.get(current);
//        }
//
//        return path;
//    }
//}
public class BellmanFord extends GraphAlgorithm {

    public BellmanFord() {
        super();  // Gọi constructor của lớp cha
    }

    public BellmanFord(boolean directed) {
        this.directed = directed;
        //nodes = new HashSet<>();
    }

//    public Stack<Node> animatePath(Node source, Node target) {
//        Stack<Node> path = new Stack<>();
//        Map<Node, Double> distance = new HashMap<>();
//        Map<Node, Node> predecessor = new HashMap<>();
//
//        // Khởi tạo khoảng cách
//        for (Node node : nodes) {
//            distance.put(node, Double.POSITIVE_INFINITY);
//        }
//        distance.put(source, 0.0);
//
//        // Relax tất cả các cạnh |V| - 1 lần
//        for (int i = 0; i < nodes.size() - 1; i++) {
//            for (Node node : nodes) {
//                for (Edge edge : node.getEdge()) {
//                    if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
//                        distance.put(edge.getDestination(), distance.get(node) + edge.getWeight());
//                        predecessor.put(edge.getDestination(), node);
//                    }
//                }
//            }
//        }
//
//        // Kiểm tra chu trình âm
//        for (Node node : nodes) {
//            for (Edge edge : node.getEdge()) {
//                if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
//                    return null; // Phát hiện chu trình âm
//                }
//            }
//        }
//
//        // Truy vết đường đi từ target về source
//        Node current = target;
//        while (current != null) {
//            path.push(current); // Lưu trữ nút hiện tại vào đường đi
//            current = predecessor.get(current); // Truy ngược nút cha
//        }
//
//        // Kiểm tra nếu không tìm thấy đường đi
//        if (path.isEmpty() || !path.peek().equals(source)) {
//            return null;
//        }
//
//        return path; // Trả về đường đi dạng Stack<Node>
//    }
//    public Stack<Node> animatePathbf(Node source, Node target) {
//        Stack<Node> path1 = new Stack<>();
//        Map<Node, Double> distance = new HashMap<>();
//        Map<Node, Node> predecessor = new HashMap<>();
//
//        // Khởi tạo khoảng cách từ source đến tất cả các node là vô cùng, trừ source là 0
//        for (Node node : nodes) {
//            distance.put(node, Double.POSITIVE_INFINITY);
//        }
//        distance.put(source, 0.0);
//
//        // Relax tất cả các cạnh |V| - 1 lần
//        for (int i = 0; i < nodes.size() - 1; i++) {
//            for (Node node : nodes) {
//                for (Edge edge : node.getEdge()) {
//                    if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
//                        distance.put(edge.getDestination(), distance.get(node) + edge.getWeight());
//                        predecessor.put(edge.getDestination(), node);
//                    }
//                }
//            }
//        }
//
//        // Kiểm tra chu trình âm
//        for (Node node : nodes) {
//            for (Edge edge : node.getEdge()) {
//                if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
//                    return null; // Phát hiện chu trình âm
//                }
//            }
//        }
//
//        // Truy vết đường đi từ target về source
//        Node current = target;
//        while (current != null) {
//            path1.push(current); // Lưu trữ node hiện tại vào Stack
//            current = predecessor.get(current); // Truy ngược đến node cha
//        }
//
//        // Kiểm tra nếu không tìm thấy đường đi (path sẽ rỗng hoặc không bắt đầu từ source)
//        if (path1.isEmpty() || !path1.peek().equals(source)) {
//            return null;
//        }
//        System.out.println("Path from source to target:");
//        //Stack<Node> tempStack = (Stack<Node>) path1.clone();  // Clone stack để duyệt mà không làm thay đổi nguyên gốc
//        while (!path1.isEmpty()) {
//            Node node = path1.pop();
//            System.out.print(node.getName() + " "); // In ra tên của node
//        }
//        System.out.println(); // Xuống dòng sau khi in dãy
//
//        return path1; // Trả về đường đi dạng Stack<Node> (từ source đến target)
//    }
//    
//    public String BellmanFordShortestPath(Node start, Node end) {
//        String output = "";
//        HashMap<Node, Double> distance = new HashMap<>();
//        HashMap<Node, Node> predecessor = new HashMap<>();
//        // Khởi tạo khoảng cách từ start đến tất cả các node là vô cùng, trừ start là 0
//        for (Node node : nodes) {
//            distance.put(node, Double.POSITIVE_INFINITY);
//        }
//        distance.put(start, 0.0);
//
//        // Relax tất cả các cạnh |V| - 1 lần
//        for (int i = 0; i < nodes.size() - 1; i++) {
//            for (Node node : nodes) {
//                for (Edge edge : node.getEdge()) {
//                    if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
//                        distance.put(edge.getDestination(), distance.get(node) + edge.getWeight());
//                        predecessor.put(edge.getDestination(), node);
//                    }
//                }
//            }
//        }
//
//        // Kiểm tra chu trình âm
//        for (Node node : nodes) {
//            for (Edge edge : node.getEdge()) {
//                if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
//                    return "Graph contains a negative-weight cycle";
//                }
//            }
//        }
//
//        // Truy vết đường đi từ end về start
//        Node current = end;
//        StringBuilder path = new StringBuilder();
//        while (current != null) {
//            path.insert(0, current.getName() + (path.length() > 0 ? "->" : ""));
//            current = predecessor.get(current);
//        }
//
//        if (path.length() == 0 || !path.toString().startsWith(start.getName())) {
//            return "There isn't a path between " + start.getName() + " and " + end.getName();
//        }
//
//        output += path.toString();
//        return output;
//    }

    public Stack<Node> animatePathbf(Node start, Node end) {
        Stack<Node> path = new Stack<>();
        HashMap<Node, Double> distance = new HashMap<>();
        HashMap<Node, Node> predecessor = new HashMap<>();

        // Khởi tạo khoảng cách từ start đến tất cả các node là vô cùng, trừ start là 0
        for (Node node : nodes) {
            distance.put(node, Double.POSITIVE_INFINITY);
        }
        distance.put(start, 0.0);

        // Relax tất cả các cạnh |V| - 1 lần
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (Node node : nodes) {
                for (Edge edge : node.getEdge()) {
                    if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
                        distance.put(edge.getDestination(), distance.get(node) + edge.getWeight());
                        predecessor.put(edge.getDestination(), node);
                    }
                }
            }
        }

        // Kiểm tra chu trình âm
        for (Node node : nodes) {
            for (Edge edge : node.getEdge()) {
                if (distance.get(node) + edge.getWeight() < distance.get(edge.getDestination())) {
                    return null; // Phát hiện chu trình âm
                }
            }
        }

        // Truy vết đường đi từ end về start
        Node current = end;
        while (current != null) {
            path.push(current); // Lưu trữ node hiện tại vào Stack
            current = predecessor.get(current); // Truy ngược đến node cha
        }

        // Kiểm tra nếu không tìm thấy đường đi
        if (path.isEmpty() || !path.peek().equals(start)) {
            return null;
        }

        return path;
    }


}

