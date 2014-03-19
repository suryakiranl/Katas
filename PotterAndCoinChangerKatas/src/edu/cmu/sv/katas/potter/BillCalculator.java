package edu.cmu.sv.katas.potter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Surya Kiran on 2/19/14.
 */
public class BillCalculator {
    private static final double COST_PER_BOOK = 8.0;
    private static final Map<Integer, Double> discountMap = new HashMap<Integer, Double>();
    private ShoppingCart cart;

    static {
        // Initialize the discount map
        discountMap.put(1, 0d); // No discount
        discountMap.put(2, 0.05); // 5%
        discountMap.put(3, 0.10); // 10%
        discountMap.put(4, 0.20); // 20%
        discountMap.put(5, 0.25); // 25%
    }

    public BillCalculator(ShoppingCart sCart) {
        this.cart = sCart;
    }

    /**
     * Core method that can be called to get the bill amount for the
     * shopping cart.
     *
     * @return - Least possible bill amount
     */
    public double getBillAmount() {
        // Worst case price
        double lowestPrice = priceWithOutDiscounts();

        for(int size = cart.getAsArray().length; size > 1; size--) {
            int itemCount = 0;
            double thisCartPrice = 0d;
            ShoppingCart cartCopy = cart.makeACopy();

            int reducedBy = 0;
            do {
                reducedBy = removeAndReturnRemovedBooksCount(cartCopy, size);

                itemCount += reducedBy;
                thisCartPrice += calculatePriceOfSet(reducedBy);
            } while(reducedBy > 0);

            // When we have all items included in the current cart,
            // and that price calculated is less than previous lowest price
            // Set the current cart price as the lowest price.
            if( (thisCartPrice < lowestPrice) && (itemCount == cart.countItemsInCart()) ) {
                lowestPrice = thisCartPrice;
            }
        }

        return lowestPrice;
    }

    private double priceWithOutDiscounts() {
        return COST_PER_BOOK * cart.countItemsInCart();
    }

    /**
     * Remove a maximum of maxItemsToRemove items from the cart,
     * and return a count of the actual number of items removed.
     *
     * @param sCart - Cart whose items should be removed.
     * @param maxItemsToRemove - Max number of different items to be removed
     *
     * @return - Actual number of different items removed from the cart
     */
    private int removeAndReturnRemovedBooksCount(ShoppingCart sCart, int maxItemsToRemove) {
        int counter = 0;

        if(sCart.getCopiesOfBook1() > 0 && maxItemsToRemove > 0) {
            sCart.setCopiesOfBook1(sCart.getCopiesOfBook1() - 1);
            counter++; maxItemsToRemove--;
        }
        if(sCart.getCopiesOfBook2() > 0 && maxItemsToRemove > 0) {
            sCart.setCopiesOfBook2(sCart.getCopiesOfBook2() - 1);
            counter++; maxItemsToRemove--;
        }
        if(sCart.getCopiesOfBook3() > 0 && maxItemsToRemove > 0) {
            sCart.setCopiesOfBook3(sCart.getCopiesOfBook3() - 1);
            counter++; maxItemsToRemove--;
        }
        if(sCart.getCopiesOfBook4() > 0 && maxItemsToRemove > 0) {
            sCart.setCopiesOfBook4(sCart.getCopiesOfBook4() - 1);
            counter++; maxItemsToRemove--;
        }
        if(sCart.getCopiesOfBook5() > 0 && maxItemsToRemove > 0) {
            sCart.setCopiesOfBook5(sCart.getCopiesOfBook5() - 1);
            counter++; maxItemsToRemove--;
        }

        return counter;
    }

    /**
     *  Calculate price of the set based on number of items in it
     *
     * @param noOfDifferentBooks - Number of different books to apply discount
     *
     * @return - Price of the set after discount
     */
    private double calculatePriceOfSet(int noOfDifferentBooks) {
        double price = 0d;
        Double discountFactor = discountMap.get(noOfDifferentBooks);

        // We should not end up with this case.
        // However, it is a fall back case :)
        if(discountFactor == null) {
            discountFactor = 0d;
        }

        price = COST_PER_BOOK * noOfDifferentBooks * (1 - discountFactor);

        return price;
    }
}