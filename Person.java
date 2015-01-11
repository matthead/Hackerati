import java.util.HashMap;

/**
 * Created by matthew on 1/7/15.
 */
public class Person {
    public Person(){
        //used to keep track what the person has bidden on.
        itemsBiddenOn = new HashMap<Item, Double>();
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBid(Item item,double bid){
        itemsBiddenOn.put(item,bid);
    }
    public double getBid(Item item){
        if(itemsBiddenOn.containsKey(item)){
            return itemsBiddenOn.get(item);
        }
        return -1;
    }
    private String name;
    private HashMap<Item,Double> itemsBiddenOn;
}
