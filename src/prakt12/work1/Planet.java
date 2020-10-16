package prakt12.work1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Planet extends Button{
    private final double G=0.0000000000667;
    private double mass;
    private double radius;
    private double gravitation;

    public Planet(final String name,double mass,double radius){
        this.setText(name);
        this.mass=mass;
        this.radius=radius;
        setGravitation();
        setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Гравитация ("+name+")");
                alert.setContentText(String.valueOf(gravitation));
                alert.show();
            }
        });
    }

    private void setGravitation(){
        gravitation=(G*mass)/(radius*radius);
    }
}
