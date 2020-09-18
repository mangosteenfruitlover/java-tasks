package prakt1.work2;
import java.util.Random;
public class Sort{
    public static void main(String[] args){
        System.out.println("=/____________________________/=");
        System.out.println("=/____________________________/=");
        int[] massiv=new int[7];
        for(int i=0;i<7;++i){
            massiv[i]=(int)(Math.random()*128);
        }
        for(int i=0;i<7;++i){
            if(i==0){
                System.out.print("==//= Massiv: [_");
            }
            if(i!=6){
                System.out.print(massiv[i]+"_");
            }else{
                System.out.print(massiv[i]+"_]  =//==");
            }
        }
        System.out.println("=/____________________________/=");
        System.out.println("=/____________________________/=");
        sort(massiv);
        for(int i=0;i<7;++i){
            if(i==0){
                System.out.print("==//= Massiv: [_");
            }
            if(i!=6){
                System.out.print(massiv[i]+"_");
            }else{
                System.out.print(massiv[i]+"_]  =//==");
            }
        }
        System.out.println("=/____________________________/=");
        System.out.println("=/____________________________/=");
        Random random=new Random();
        for(int i=0;i<7;++i){
            massiv[i]=random.nextInt(128);
        }
        for(int i=0;i<7;++i){
            if(i==0){
                System.out.print("==//= Massiv: [_");
            }
            if(i!=6){
                System.out.print(massiv[i]+"_");
            }else{
                System.out.print(massiv[i]+"_]  =//==");
            }
        }
        System.out.println("=/____________________________/=");
        System.out.println("=/____________________________/=");
        sort(massiv);
        for(int i=0;i<7;++i){

            if(i==0){
                System.out.print("==//= Massiv: [_");
            }
            if(i!=6){
                System.out.print(massiv[i]+"_");
            }else{
                System.out.print(massiv[i]+"_]  =//==");
            }
        }
        System.out.println("=/____________________________/=");
        System.out.println("=/____________________________/=");
    }
    public static void sort(int[] massiv){
        boolean condition=true;
        int save_el;
        while(condition){
            condition=false;
            for(int i=0;i<7-1;i++){
                if(massiv[i]>massiv[i+1]){
                    save_el=massiv[i];
                    massiv[i]=massiv[i+1];
                    massiv[i+1]=save_el;
                    condition=true;
                }
            }
        }
    }
}