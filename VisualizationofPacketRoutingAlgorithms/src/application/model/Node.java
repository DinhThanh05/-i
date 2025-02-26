package application.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.*;

public class Node {

    public double x;
    public double y;
    public String name;
    private boolean visited;
    private final Circle circle;
    private final Text text;
    public LinkedList<Edge> edges;

    Node(double x,double y, String name) {
        circle = new Circle(10);
        circle.setFill(Color.GAINSBORO);
        circle.setStroke(Color.CORNFLOWERBLUE);
        text = new Text(name);
        this.x = x;
        this.y = y;
        this.name = name;
        visited = false;
        edges = new LinkedList<>();
    }

    public LinkedList<Edge> getEdge() {
        return edges;
    }

    public double getNodeX() {
        return x;
    }

    public double getNodeY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public Circle getCircle(double scale) {
        circle.setCenterX(x * scale);
        circle.setCenterY(y * scale);
        return circle;
    }
    Circle getCircle(){
        return circle;
    }

    public Text getText() {
        text.layoutXProperty().bind(circle.centerXProperty().add(-text.getLayoutBounds().getWidth() / 2));
        text.layoutYProperty().bind(circle.centerYProperty().add(5));
        return text;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        visited = true;
    }

    public void unvisited() {
        visited = false;
    }
}