package prakt3.work2;
public class Human{//Класс Человека
    Head head;//Голова- Свойства Человека
    Leg legs;//Ноги- Свойства Человека
    Hand hands;//Руки- Свойства Человека
    public Human(String strEyes,String strHand,String strLeg){//Конструктор Человека
        head=new Head(strEyes);//Создание Объекта Головы
        hands=new Hand(strHand);//Создание Объекта Рук
        legs=new Leg(strLeg);//Создание Объекта Ног
    }
    void sleep(){
        head.sleep();//Вызов Метода, чтобы Голова приготовилась ко сну
        legs.sleep();//Вызов Метода, чтобы Ноги приготовились ко сну
        hands.sleep();//Вызов Метода, чтобы Руки приготовились ко сну
    }
}