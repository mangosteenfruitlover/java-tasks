package prakt8.work1;
import javafx.scene.paint.Color;

public abstract class Shape {
    protected double x;
    protected double y;
    protected Color color;

    public Shape( double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void addOnPane();

    public Color getColor() {
        return color;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
