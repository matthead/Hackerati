import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by matthew on 1/7/15.
 */
public class Auction {
    public Auction(){
        items = new HashMap<String, Item>();
    }
    public boolean addItemToAuction(String name,double reservePrice){
        //get generatedName
        //String uniqueName=AuctionUtl.getUniqueGeneratedName();
        // name is not already being auctioned
        if(!items.containsKey(name)){
            items.put(name,new Item(name,reservePrice));
            return true;
        }
        return false;
    }
    public boolean startAuctionOnItem(String name){
        if(items.containsKey(name)){
            //not being auctioned at the moment
            if(!items.get(name).getIsBeingAuctioned()) {
                items.get(name).setAuctionState(ItemStates.CurrentlyBeingAuctioned);
                return true;
            }
        }
        return false;
    }
    public boolean bid(String name,Person person){
        if(items.containsKey(name)&& items.get(name).getIsBeingAuctioned()){
            if(newBidIsHigherThanCurrentBid(name,person.getBid(items.get(name)))){
                System.out.println('b');
                items.get(name).addBidder(person);
                return true;
            }
        }
        return false;
    }
    public boolean endAuction(String name){
        if(items.containsKey(name)){
            Item item= items.get(name);
            if(this.didItemMeetReserve(item)){
                item.setItemSold(item.getLastPerson());
                items.remove(name);
                return true;
            }
            //remove item from listing could also change it to failure, but removing from the list
            else{
                items.get(name).setAuctionState(ItemStates.failure);
            }
        }
        return false;
    }
    public ArrayList<String> queryItem(String name){
        //order of elements
        // status of auction or item sold
        // who it was sold to
        // price it was sold at
        if(items.containsKey(name)) {
            ArrayList<String> informationOnItem = new ArrayList<String>();
            Item item = items.get(name);
            informationOnItem.add(item.getItemState().toString());
            if(item.getItemState()==ItemStates.sold){
                Person person = item.getLastPerson();
                informationOnItem.add(person.getName());
                informationOnItem.add(Double.toString(person.getBid(item)));
            }
            return informationOnItem;
        }
        return null;
    }
    private boolean didItemMeetReserve(Item item){
        return item.getReserve() < item.getCurrentBid();
    }
    private boolean newBidIsHigherThanCurrentBid(String name,double newBid){
        return items.get(name).getCurrentBid() < newBid;
    }
    private HashMap<String,Item> items;
}
