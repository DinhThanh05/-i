package application.algorithm;

import application.model.Edge;
import application.model.Node;
import java.util.*;

public class Flooding extends GraphAlgorithm {

    public Flooding() {
        super(); // Gọi constructor của lớp cha
    }

    public Flooding(boolean directed) {
        this.directed = directed;
    }

    /**
     * Phương thức Flood Fill tìm kiếm toàn bộ khu vực liên thông bắt đầu từ một nút cụ thể.
     *
     * @param start nút bắt đầu
     * @return danh sách các nút đã khám phá
     */
//    public List<Node> floodFill(Node start) {
//        List<Node> visitedNodes = new ArrayList<>();
//        if (start == null) {
//            return visitedNodes;
//        }
//
//        Queue<Node> queue = new LinkedList<>();
//        Set<Node> visited = new HashSet<>();
//
//        queue.add(start);
//        visited.add(start);
//
//        while (!queue.isEmpty()) {
//            Node current = queue.poll();
//            visitedNodes.add(current);
//
//            // Duyệt tất cả các cạnh của nút hiện tại
//            for (Edge edge : current.getEdge()) {
//                Node neighbor = edge.getDestination();
//                if (!visited.contains(neighbor)) {
//                    queue.add(neighbor);
//                    visited.add(neighbor);
//                }
//            }
//        }
//
//        return visitedNodes;
//    }
    public Stack<Node> animatePathfl(Node start, Node end) {
        Stack<Node> path = new Stack<>();
        HashMap<Node, Node> predecessors = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        
        // Khởi tạo
        queue.add(start);
        visited.add(start);
        predecessors.put(start, null);

        // Bắt đầu lan tỏa
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // Kiểm tra nếu đã đến đỉnh đích
            if (current.equals(end)) {
                Node temp = end;
                while (temp != null) {
                    path.push(temp); // Lưu đường đi vào Stack
                    temp = predecessors.get(temp);
                }
                return path; // Trả về đường đi
            }

            // Lan tỏa đến các đỉnh kề chưa thăm
            for (Edge edge : current.getEdge()) {
                Node neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    predecessors.put(neighbor, current);
                }
            }
        }

        // Nếu không tìm được đường đi, trả về null
        return null;
    }
}
