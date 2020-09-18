package prakt3.work2;
public class Head{//Класс Головы
    private String strEyes;//Состояние глаз- Свойства Головы
    public Head(String strEyes){
        this.strEyes=strEyes;
    }
    void sleep(){//Метод, чтобы Голова приготовилась ко сну
        this.strEyes="Close";//Глазки закрываются
        System.out.println("==//= Head: [Eyes: ["+this.strEyes+"]] =//==");
    }
}