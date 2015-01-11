import java.util.Stack;

/**
 * Created by matthew on 1/7/15.
 */
public class Item {
    public Item(String name, double reserve){
        this.name=name;
        this.reserve=reserve;
        this.bidders = new Stack<Person>();
        this.itemState = ItemStates.NotBeingAuctioned;
    }
    public String getName(){
        return this.name;
    }
    public double getReserve(){
        return this.reserve;
    }
    public void setAuctionState(ItemStates state){
        this.itemState =state;
    }
    public void addBidder(Person person){
        bidders.push(person);
    }
    public void setItemSold(Person person){
        this.person = person;
        this.itemState = ItemStates.sold;
    }
    public Person getLastPerson(){
        return this.bidders.peek();
    }
    public ItemStates getItemState(){
        return itemState;
    }
    public boolean getIsBeingAuctioned(){
        return this.itemState ==ItemStates.CurrentlyBeingAuctioned;
    }
    public double getCurrentBid(){
        if(this.bidders.size() > 0) {
            return this.bidders.peek().getBid(this);
        }
        return 0;
    }
    private String name;
    private double reserve;
    private Stack<Person> bidders;
    private Person person;
    private ItemStates itemState;
}
