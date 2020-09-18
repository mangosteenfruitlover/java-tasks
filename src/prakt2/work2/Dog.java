package prakt2.work2;
public class Dog{
    String Nickname;//Кличка собачки
    int Summer;//Годы собачки
    public Dog(String _Nickname,int _Summer){//Конструктор собачки
        this.Nickname=_Nickname;//Обновление Клички собачки
        this.Summer=_Summer;//Обновление Лет собачки
    }
    public String getNickname(){//Получение Клички собачки
        String _Nickname=Nickname;
        return _Nickname;
    }
    public void setNickname(String _Nickname){
        this.Nickname=_Nickname;
    }//Установка Клички собачки
    public int getSummer(){//Получение Лет собачки
        int _Summer=Summer;
        return _Summer;
    }
    public void setSummer(int _Summer){
        this.Summer=_Summer;
    } //Установка Лет собачки
    public int getSummerDog(){//Получение Лет собачки в годах собачки
        int _Summer=Summer*7;
        return _Summer;
    }
    public void setSummerHuman(int _Summer){ //Установка Лет собачки в годах человека
        _Summer=_Summer/7;
        this.Summer=_Summer;
    }
    @Override
    public String toString(){
        return "==/= Dog: {"+"Nickname: [_"+Nickname+"_], Summer: [_"+Summer+"_]} =/==";
    }
} //Вывод данных о собачке в строку