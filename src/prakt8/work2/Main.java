package prakt8.work2;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        Main MyMain = new Main();
        MyMain.getImage();
    }

    public void getImage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
        Graphics g;
        Image img;
        img = new ImageIcon("C:\\java-tasks\\src\\prakt8\\work2\\uml.png").getImage();
        g = getGraphics();
        g.drawImage(img, 0, 0, null);
    }
}
