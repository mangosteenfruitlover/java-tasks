package prakt1.work3;
public class Factorial{
    public static void main(String[] args){
        System.out.println("=/____________________________/=");
        System.out.println("=/____________________________/=");
        System.out.println("==//= Factorial(6) = "+factorial(6)+"  =//==");
        System.out.println("=/____________________________/=");
    }
    public static int factorial(int step){
        int answer=1;
        for(int i=1;i<=step;++i) answer*=i;
        return answer;
    }
}