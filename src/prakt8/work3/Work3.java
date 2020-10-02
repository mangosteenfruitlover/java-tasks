package prakt8.work3;

import prakt8.work2.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Work3 extends JFrame{
    JPanel pnl=new JPanel();

    public Work3(){
        setTitle("1-2-3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);

        Graphics g;
        Image img;

        ArrayList<Image> images=new ArrayList<>();
        for(int i=0;i<=3;i++){
            String filename="C:\\java-tasks\\src\\prakt8\\work3"+i+".jpg";
            images.add(new ImageIcon(filename).getImage());
        }
        while(true){
            for(int i=0;i<=3;i++){
                img=images.get(i);
                g=getGraphics();
                g.drawImage(img,0,0,1000,1000,null);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                }
            }
        }
    }
}
