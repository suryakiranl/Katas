import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GildedRose {
	private List<Item> items = null;
	
	public void setItems(List<Item> itemList) {
		this.items = itemList;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public static void main(String[] args) {
		List<Item> items = new ArrayList<Item>();
        
		items.add(new Article("+5 Dexterity Vest", 10, 20));
        items.add(new Article("Aged Brie", 2, 0));
        items.add(new Article("Elixir of the Mongoose", 5, 7));
        items.add(new Article("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Article("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Article("Conjured Mana Cake", 3, 6));

        GildedRose gRose = new GildedRose();
        gRose.setItems(items);
        gRose.updateQuality();
        System.out.println("Items after processing:: " + items);
	}

    public void updateQuality()
    {
    	Iterator<Item> iterator = items.iterator();
    	// For all items in the list ... update quality and sellIn attributes
    	while(iterator.hasNext()) {
    		Article article = (Article) iterator.next(); 

    		article.adjustSellIn();
    		article.adjustQuality();
    	}
    }

}