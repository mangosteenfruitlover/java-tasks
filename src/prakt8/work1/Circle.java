package prakt8.work1;

import javafx.scene.paint.Color;

public class Circle extends Shape {
    private double radius;

    public Circle(double x, double y, double radius, Color color) {
        super(x, y, color);
        this.radius = radius;
        addOnPane();
    }

    public void addOnPane() {
        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(x, y, radius);
        circle.setFill(color);
        Main.root.getChildren().add(circle);
    }

    public double getRadius() {
        return radius;
    }
}
