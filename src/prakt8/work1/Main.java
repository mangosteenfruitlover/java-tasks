package prakt8.work1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application
{
    public static Pane root;

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        root = new Pane();
        setShapes();
        Scene scene = new Scene(root);
        stage.setWidth(1000);
        stage.setHeight(900);
        stage.setScene(scene);
        stage.show();
    }

    private void setShapes()
    {
        Random random = new Random();

        Rectangle rectangle1 = new Rectangle(0, 10, 100, 30, Color.color(Math.random(), Math.random(), Math.random()));
        Rectangle rectangle2 = new Rectangle(1, 80, 77, 40, Color.color(Math.random(), Math.random(), Math.random()));
        Rectangle rectangle3 = new Rectangle(1, 150, 56, 30, Color.color(Math.random(), Math.random(), Math.random()));
        Rectangle rectangle4 = new Rectangle(1, 210, 88, 25, Color.color(Math.random(), Math.random(), Math.random()));
        Rectangle rectangle5 = new Rectangle(1, 280, 44, 65, Color.color(Math.random(), Math.random(), Math.random()));
        Rectangle rectangle6 = new Rectangle(1, 370, 55, 22, Color.color(Math.random(), Math.random(), Math.random()));

        Circle circle1 = new Circle(200, 100, 10, Color.color(Math.random(), Math.random(), Math.random()));
        Circle circle2 = new Circle(200, 200, 20, Color.color(Math.random(), Math.random(), Math.random()));
        Circle circle3 = new Circle(200, 300, 30, Color.color(Math.random(), Math.random(), Math.random()));
        Circle circle4 = new Circle(200, 400, 25, Color.color(Math.random(), Math.random(), Math.random()));
        Circle circle5 = new Circle(200, 500, 45, Color.color(Math.random(), Math.random(), Math.random()));
        Circle circle6 = new Circle(200, 600, 50, Color.color(Math.random(), Math.random(), Math.random()));
        Circle circle7 = new Circle(200, 720, 59, Color.color(Math.random(), Math.random(), Math.random()));

        Ellipse ellipse1 = new Ellipse(500, 100, 15, 5, Color.color(Math.random(), Math.random(), Math.random()));
        Ellipse ellipse2 = new Ellipse(500, 200, 30, 8, Color.color(Math.random(), Math.random(), Math.random()));
        Ellipse ellipse3 = new Ellipse(500, 300, 27, 13, Color.color(Math.random(), Math.random(), Math.random()));
        Ellipse ellipse4 = new Ellipse(500, 400, 22, 10, Color.color(Math.random(), Math.random(), Math.random()));
        Ellipse ellipse5 = new Ellipse(500, 500, 25, 12, Color.color(Math.random(), Math.random(), Math.random()));
        Ellipse ellipse6 = new Ellipse(500, 600, 40, 20, Color.color(Math.random(), Math.random(), Math.random()));
    }
}