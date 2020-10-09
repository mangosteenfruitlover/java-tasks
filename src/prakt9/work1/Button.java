package prakt9.work1;

import javafx.application.Application;
import prakt8.work1.Main;
import prakt8.work1.Circle;
import prakt8.work1.Ellipse;
import prakt8.work1.Rectangle;
import prakt8.work1.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JFrame{

    public Button(String[] args){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);
        setResizable(false);
        JPanel panel=new JPanel();
        JButton button=new JButton("Hmmm");
        button.setSize(100,100);
        panel.add(button);
        ActionListener actionListener=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //panel.setVisible(false);
                Main.main(args);
                setVisible(false);
            }
        };
        button.addActionListener(actionListener);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args){
        new Button(args);
    }

}
