import java.util.ArrayList;
import java.util.List;

public class Article extends Item implements ItemNames {
	// Enum to specify the operation to perform
	public enum Operation {
		INCREASE, DECREASE;
	}

	private static final List<String> qualityIncrItems;

	static {
		qualityIncrItems = new ArrayList<String>();
		qualityIncrItems.add(Article.AGED_BRIE);
		qualityIncrItems.add(Article.BACKSTAGE_PASSES);
	}

	// Constructor to support the base class
	public Article(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	// Method to adjust quality attribute of the article.
	public void adjustQuality() {
		// Factor by which quality degrades
		int qualityFactor = 1;
		qualityFactor = (sellIn < 0) ? ++qualityFactor : qualityFactor;

		// If the current item is one of the item's whose
		// quality increases as sellIn date comes closer ...
		if (qualityIncrItems.contains(name)) {
			quality++;

			// Increment quality in inner IF ELSE by 1 less,
			// as we already incremented quality by 1 in previous line.
			if (BACKSTAGE_PASSES.equals(name) && sellIn >= 0) {
				quality = (sellIn <= 10) ? ++quality : quality;
				quality = (sellIn <= 5) ? ++quality : quality;
				quality = (quality > 50) ? 50 : quality;
			} 
		} else {
			// For items that do not have increasing quality ...
			quality = CONJURED.equals(name) ? quality - qualityFactor : quality;
			quality = !SULFURAS.equals(name) ? quality - qualityFactor : quality;
			quality = (quality < 0) ? 0 : quality;
		}
	}

	// Method to adjust sellIn attribute of the article.
	public void adjustSellIn() {
		if (!(SULFURAS.equals(name))) {
			sellIn--;
		}

		// For Back Stage Passes, quality becomes 0 when sellIn is 0
		if ((sellIn <= 0) && (BACKSTAGE_PASSES.equals(name))) {
			quality = 0;
		}
	}
	
	public String toString() {
		return "\n [Name=" + name + ",SellIn=" + sellIn + ",Quality=" + quality + "] ";
	}
}
