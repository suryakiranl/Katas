import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {
	private GildedRose gRose = new GildedRose();
	/**
	 * Helper method to prepare a default list of items for every test case.
	 * 
	 * @return
	 */
	private List<Item> prepareList() {
		List<Item> items = new ArrayList<Item>();

		items.add(new Article("+5 Dexterity Vest", 10, 20));
		items.add(new Article("Aged Brie", 2, 0));
		items.add(new Article("Elixir of the Mongoose", 5, 7));
		items.add(new Article("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Article("Backstage passes to a TAFKAL80ETC concert", 15,
				20));
		items.add(new Article("Conjured Mana Cake", 3, 6));

		return items;
	}

	@Before
	public void setUp() {
		// Prepare the Array List for each test case.
		gRose.setItems(prepareList());
	}

	@Test
	public void quailtyOfSulfurasShouldNeverChange() throws Exception { 
		gRose.updateQuality();
		assertEquals(gRose.getItems().get(3).getQuality(), 80);
	}

	@Test
	public void sellInOfSulfurasShouldNeverChange() throws Exception {
		gRose.updateQuality();
		assertEquals(gRose.getItems().get(3).getSellIn(), 0);
	}

	@Test
	public void lowerQualityOfItemsEachDay() throws Exception {
		List<Item> originalItems = prepareList();
		
		List<String> itemsWithNonDecreasingQuality = new ArrayList<String>();
		itemsWithNonDecreasingQuality.add(ItemNames.AGED_BRIE);
		itemsWithNonDecreasingQuality.add(ItemNames.BACKSTAGE_PASSES);
		itemsWithNonDecreasingQuality.add(ItemNames.SULFURAS);
		
		gRose.updateQuality();
		List<Item> modifiedItems = gRose.getItems();
		
		for(int row = 0 ; row < modifiedItems.size(); row++ ) {
			if(!itemsWithNonDecreasingQuality.contains(modifiedItems.get(row).getName())) {
				assertTrue("Quality should reduce for items every day", 
							( (originalItems.get(row).getQuality() > modifiedItems.get(row).getQuality())
									|| (originalItems.get(row).getQuality() == 0) ));
			}
		}
	}
	
	@Test
	public void lowerSellInOfItemsEachDay() throws Exception {
		List<Item> originalItems = prepareList();
		
		gRose.updateQuality();
		List<Item> modifiedItems = gRose.getItems();
		
		for(int row = 0 ; row < modifiedItems.size(); row++ ) {
			if(!ItemNames.SULFURAS.equals(modifiedItems.get(row).getName())) {
				assertTrue("SellIn should reduce for items every day", 
							( (originalItems.get(row).getSellIn() > modifiedItems.get(row).getSellIn())
									|| (originalItems.get(row).getSellIn() == 0) ));
			}
		}
	}
}
