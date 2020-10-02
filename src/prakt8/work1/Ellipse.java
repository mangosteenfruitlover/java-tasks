package prakt8.work1;

import javafx.scene.paint.Color;

public class Ellipse extends Shape {
    private double radiusX;
    private double radiusY;

    public Ellipse(double x, double y, double radiusX, double radiusY, Color color) {
        super(x, y, color);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        addOnPane();
    }

    public void addOnPane() {
        javafx.scene.shape.Ellipse ellipse = new javafx.scene.shape.Ellipse(x, y, radiusX, radiusY);
        ellipse.setFill(color);
        Main.root.getChildren().add(ellipse);
    }
}