package prakt7.work1;
import java.util.ArrayList;
import java.util.List;


public class Person {
    List<Furniture> basket= new ArrayList<Furniture>();
    public Person(){

    }

    public void addTableToBasket(){
        basket.add(FurnitureShop.getTable());
    }

    public void addStoolToBasket(){
        basket.add(FurnitureShop.getStool());
    }

    public void addChairToBasket(){
        basket.add(FurnitureShop.getChair());
    }
    public List<Furniture> getBasket(){
        return basket;
    }
}
