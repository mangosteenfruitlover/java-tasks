package prakt11.work1;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.event.*;
public class Prakt11 extends Application{
    Group s_root=new Group();
    private static int c=0;
    private static int n=(int)(Math.random()*20);
    private static int vvod=0;
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
        Scene scene=new Scene(s_root,255,60);
        stage.setTitle("Go!");
        stage.setScene(scene);
        Button zhmiButton=new Button("Жми!");
        TextField vvedi_n=new TextField();
        vvedi_n.setLayoutX(5);
        vvedi_n.setLayoutY(5);
        zhmiButton.setLayoutX(195);
        zhmiButton.setLayoutY(5);
        Label textOutput=new Label();
        textOutput.setLayoutX(5);
        textOutput.setLayoutY(40);
        textOutput.setText("Вводи число и жми!");
        EventHandler<ActionEvent> eventHandler=new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                vvod=Integer.parseInt(vvedi_n.getText());
                c++;
                if(c<3){
                    if(vvod!=n){
                        if(vvod<n){
                            textOutput.setText("Число меньше загадоного");
                        }else{
                            textOutput.setText("Число больше загадоного");
                        }
                    }else{
                        textOutput.setText("Вы победили! Нажми для выхода");
                        c=4;
                    }
                }else{
                    if(c==3){
                        if(vvod!=n){
                            textOutput.setText("Вы проиграли. Нажми для выхода");
                        }else{
                            textOutput.setText("Вы победили! Нажми для выхода");
                        }
                    }else{
                        System.exit(0);
                    }
                }
            }
        };
        zhmiButton.setOnAction(eventHandler);
        System.out.println(n);
        s_root.getChildren().addAll(vvedi_n,zhmiButton,textOutput);
        stage.show();
    }
}