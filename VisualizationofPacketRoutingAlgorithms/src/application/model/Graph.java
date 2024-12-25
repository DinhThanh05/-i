package application.model;

import application.algorithm.BellmanFord;
import application.algorithm.Dijkstra;
import application.algorithm.Flooding;
import application.algorithm.GraphAlgorithm;

import java.util.*;
public class Graph {
    private final LinkedList<Node> nodes = new LinkedList<>();
    private final GraphAlgorithm ga = new GraphAlgorithm(true);
    private final Dijkstra adj = new Dijkstra(true);
    private final BellmanFord bf = new BellmanFord(true);
    private final Flooding fl = new Flooding(true);

    public void addNode(double x, double y, String name){
        Node temp = new Node(x,y,name);
        nodes.add(temp);
    }
    public Node getNode(String from){
        for(Node i:nodes){
            if(i.name.equals(from)){
                return i;
            }
        }
        return null;
    }
    public String SearchNode(String node) {
        for(Node i:nodes){
            if(i.getName().equals(node)){
                return ("X coordinate:"+i.x+"\n"+"Y coordinate:"+i.y);
            }
        }
        return ("Node not Found");
    }
    public void DeleteNode(String node){
        for(Node n:nodes){
            if(n.getName().equals(node)){
//                nodes.remove(n);
                ga.DeleteNo(n);
                nodes.remove(n);
                return;
            }
        }
    }

//    public String ModifyNode(String node, double x, double y){
//        for(Node i:nodes){
//            if(i.getName().equals(node)){
//                i.x = x;
//                i.y = y;
//                return ("Node Modified");
//            }
//        }
//        return ("Node not Found");
//    }
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (Node node : nodes) {
            edges.addAll(node.getEdge());
        }
        return edges;
    }

    public String addEdge(String from, String to, double weight) {
        Node fromNode = null, toNode = null;
        
        // Tìm kiếm các node dựa vào tên
        for (Node i : nodes) {
            if (i.getName().equals(from)) {
                fromNode = i;
            }
            if (i.getName().equals(to)) {
                toNode = i;
            }
        }
        
        if (fromNode == null) {
            return "From node not found";
        } else if (toNode == null) {
            return "To node not found";
        } else {
            // Kiểm tra xem cạnh đã tồn tại chưa
            for (Edge edge : fromNode.edges) {
                if (edge.destination.equals(toNode)) {
                    return "Edge from " + from + " to " + to + " already exists";
                }
            }
            
            // Thêm cạnh mới nếu chưa tồn tại
           ga.addEdge(fromNode, toNode, weight);
           adj.addEdge(fromNode, toNode, weight);
           bf.addEdge(fromNode, toNode, weight);
            return "Edge added successfully";
        }
    }


//    public String SearchEdge(String from, String to){
//        Node fromNode=null,toNode=null;
//        for (Node i :nodes) {
//            if(i.getName().equals(from)){
//                fromNode = i;
//            }
//            if(i.getName().equals(to)){
//                toNode = i;
//            }
//            if(!i.getName().equals(from)||!i.getName().equals(to)){
//            	return ("Node not Found");
//            	
//            }
//        }
//        if(fromNode == null || toNode == null) {
//            return ("Edge Not Found");
//        }
//        else
//        {
//            if(adj.hasEdge(fromNode, toNode)){
//                return ("Edge Found \n"+"Weight is "+adj.Weight(fromNode,toNode));
//            }
//            else
//                return ("Edge Not Found");
//        }
//    }

    public void renameNode(String oldName, String newName) {
        Node targetNode = getNode(oldName);
        if (targetNode == null) {
            return;
        }

        if (getNode(newName) != null) {
            return;
        }

        targetNode.name = newName;
    }


//    public String ModifyEdge(String from, String to, double weight){
//        Node fromNode=null,toNode=null;
//        for (Node i :nodes) {
//            if(i.getName().equals(from)){
//                fromNode = i;
//            }
//            if(i.getName().equals(to)){
//                toNode = i;
//            }
//        }
//        if(fromNode == null || toNode == null)
//            return ("Edge not Found");
//        else {
//            adj.ModifyEdgeWeight(fromNode, toNode,weight);
//            return ("Edge Modified Successfully");
//        }
//    }
    public String DeleteEdge(String from, String to){
        Node fromNode=null,toNode=null;
        for (Node i :nodes) {
            if(i.getName().equals(from)){
                fromNode = i;
            }
            if(i.getName().equals(to)){
                toNode = i;
            }
        }
        if(fromNode == null || toNode == null){
            return ("Edge not Found");
        }
        else if(fromNode == toNode){
            return ("Both Nodes are same!");
        }
        else {

            if(ga.DeleteEd(fromNode, toNode)){
                return ("Edge deleted");
            }
            else
                return ("Edge Not Found");
        }
    }

    public String getPath(String from, String to){
        String output;
        Node fromNode=null,toNode=null;
        for (Node i :nodes) {
            if(i.getName().equals(from)){
                fromNode = i;
            }
            if(i.getName().equals(to)){
                toNode =i;
            }
        }
        output = adj.DijkstraShortestPath(fromNode,toNode);
        adj.resetNodesVisited();
        return output;
    }

    public LinkedList<Node> getNodes(){
        return nodes;
    }
    public GraphAlgorithm getga(){
        return ga;
    }
    public Dijkstra getAdj(){
        return adj;
    }
    public BellmanFord getbf(){
        return bf;
    }
    public Flooding getfl(){
        return fl;
    }

    public Stack<Node> getNodePathdijkstra(String from, String to){
        Node fromNode=null,toNode=null;
        for (Node i :nodes) {
            if(i.getName().equals(from)){
                fromNode = i;
            }
            if(i.getName().equals(to)){
                toNode = i;
            }
        }
        return adj.animatePathadj(fromNode,toNode);
    }
    public Stack<Node> getNodePathbellmanford(String from, String to){
        Node fromNode=null,toNode=null;
        for (Node i :nodes) {
            if(i.getName().equals(from)){
                fromNode = i;
            }
            if(i.getName().equals(to)){
                toNode = i;
            }
        }
        return bf.animatePathbf(fromNode,toNode);
    }
    public Stack<Node> getNodePathflooding(String from, String to){
        Node fromNode=null,toNode=null;
        for (Node i :nodes) {
            if(i.getName().equals(from)){
                fromNode = i;
            }
            if(i.getName().equals(to)){
                toNode = i;
            }
        }
        return fl.animatePathfl(fromNode,toNode);
    }

}
