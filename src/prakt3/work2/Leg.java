package prakt3.work2;
public class Leg{//Класс Ног
    private String strLeg;//Состояние ног- Свойства Ног
    public Leg(String strLeg){
        this.strLeg=strLeg;
    }
    void sleep(){//Метод, чтобы Ноги приготовились ко сну
        this.strLeg="Folded";//Ноги сгибаются
        System.out.println("==//= Leg: ["+this.strLeg+"] =//==");
    }
}