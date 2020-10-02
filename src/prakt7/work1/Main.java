package prakt7.work1;
import java.util.List;

public class Main{
    public static void main ( String[] args ) {
        Person SpongeBoB = new Person();
        SpongeBoB.addChairToBasket();
        SpongeBoB.addStoolToBasket();
        SpongeBoB.addTableToBasket();
        //List<Furniture> basket= new ArrayList<Furniture>();
        List<Furniture> basket = SpongeBoB.getBasket();
        System.out.println("The Basket of Furniture Objects:");
        System.out.println(basket);
    }
}
