package prakt3.work2;
public class HumanTest{//Класс Проверки Человека
    public static void main(String[] args){
        String strEyes="Open";
        String strHand="Straight";
        String strLeg="Straight";
        System.out.println("=/____________________________/=");
        System.out.println("==//= Head: [Eyes: ["+strEyes+"]] =//==");
        System.out.println("==//= Leg: ["+strHand+"] =//==");
        System.out.println("==//= Hand: ["+strLeg+"] =//==");
        System.out.println("=/____________________________/=");
        Human Einstein=new Human(strEyes,strHand,strLeg);
        Einstein.sleep();//Вызов Метода Einstein'а, чтобы Einstein лёг спать
        System.out.println("=/____________________________/=");
    }
}
