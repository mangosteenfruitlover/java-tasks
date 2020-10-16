package prakt12.work1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.lang.Math;
public class Prakt12 extends Application{
    private static FlowPane root;
    public static void main(String[] args){
        Application.launch(args);
    }
    @Override
    public void start(Stage stage){
        root=new FlowPane();
        Scene scene=new Scene(root);
        stage.setTitle("Планеты");
        stage.setWidth(100);
        stage.setHeight(225);
        stage.setScene(scene);
        setPlanets();
        stage.show();
    }
    private void setPlanets(){
        root.getChildren().add(new Text("Планеты:"));
        Region lineBreak=new Region();
        lineBreak.setPrefSize(Double.MAX_VALUE,0.0);
        root.getChildren().add(lineBreak);
        root.getChildren().add(new Planet("Меркурий",3.285*Math.pow(10,23),2440));
        root.getChildren().add(new Planet("Венера",4.867*Math.pow(10,24),6052));
        root.getChildren().add(new Planet("Земля",5.972*Math.pow(10,24),6371));
        root.getChildren().add(new Planet("Марс",6.39*Math.pow(10,23),3390));
        root.getChildren().add(new Planet("Юпитер",1.898*Math.pow(10,27),69911));
        root.getChildren().add(new Planet("Сатурн",5.683*Math.pow(10,26),58232));
        root.getChildren().add(new Planet("Уран",8.681*Math.pow(10,25),25362));
        root.getChildren().add(new Planet("Нептун",1.024*Math.pow(10,26),24622));

    }
}