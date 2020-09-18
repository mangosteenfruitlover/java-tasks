package prakt3.work2;
public class Hand{//Класс Руки
    private String strHand;//Состояние руки- Свойства Руки
    public Hand(String _strHand){
        this.strHand=_strHand;
    }
    void sleep(){//Метод, чтобы Руки приготовились ко сну
        this.strHand="Under the head";//Рука убирается под голову
        System.out.println("==//= Hand: ["+this.strHand+"] =//==");
    }
}
