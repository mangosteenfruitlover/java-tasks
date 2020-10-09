package prakt10;

import java.util.Scanner;

public class Prakt10{
    public Prakt10(){

    }

    public static void main(String[] args){
        System.out.println("Press '1' for start Work1");
        System.out.println("Press '2' for start Work2");
        System.out.println("Press '3' for start Work3");
        System.out.println("Input...");
        Scanner scanner=new Scanner(System.in);
        int condition=scanner.nextInt();
        if(condition==1){
            Work1();
        }else if(condition==2){
            Work2();
        }else if(condition==3){
            Work3();
        }
    }

    public static void Work1(){
        System.out.println("Work1");
        int k, d;
        Scanner scanner=new Scanner(System.in);
        k=scanner.nextInt();
        d=scanner.nextInt();
        int count=0;
        for(int i=(int)Math.pow(10,k-1);i<(int)Math.pow(10,k);++i){
            if(kol_znak(i)==d) ++count;
        }
        System.out.println(count);
    }

    static int kol_znak(int a){
        int sum=0;
        while(a!=0){
            sum+=a%10;
            a/=10;
        }
        return sum;
    }

    public static void Work2(){
        System.out.println("Work2");
        Scanner scanner=new Scanner(System.in);
        System.out.println(f2(scanner.nextInt(),scanner.nextInt()));
    }

    public static int f2(int a,int b){
        if(a>b+1) return 0;
        if(a==0||b==0) return 1;
        return f2(a,b-1)+f2(a-1,b-1);
    }

    public static void Work3(){
        System.out.println("Work3");
        Scanner scanner=new Scanner(System.in);
        f(scanner.nextInt());
    }

    public static void f(int a){
        if(a!=0){
            f(a/10);
            System.out.println(a%10);
        }
    }
}
