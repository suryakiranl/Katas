package edu.cmu.sv.katas.potter;

import edu.cmu.sv.katas.potter.BillCalculator;
import edu.cmu.sv.katas.potter.ShoppingCart;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class BillCalculatorTest {
    private ShoppingCart cart;

    @Before
    public void initializeEmptyCart() {
        cart = new ShoppingCart();
    }

    private double calculateBillAmount(ShoppingCart cart) {
        BillCalculator billCalculator = new BillCalculator(cart);
        double billAmount = billCalculator.getBillAmount();

        return billAmount;
    }

    @Test
    public void emptyCart() {
        Assert.assertEquals(calculateBillAmount(cart) , 0d);
    }

    @Test
    public void cartWithOneItemOfBookOne() {
        cart.setCopiesOfBook1(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8d);
    }
    @Test
    public void cartWithOneItemOfBookTwo() {
        cart.setCopiesOfBook2(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8d);
    }

    @Test
    public void cartWithOneItemOfBookThree() {
        cart.setCopiesOfBook3(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8d);
    }

    @Test
    public void cartWithOneItemOfBookFour() {
        cart.setCopiesOfBook4(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8d);
    }

    @Test
    public void cartWithOneItemOfBookFive() {
        cart.setCopiesOfBook5(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8d);
    }

    @Test
    public void cartWithTwoCopiesOfBookOne() {
        cart.setCopiesOfBook1(2);
        Assert.assertEquals(calculateBillAmount(cart) , 16d);
    }

    @Test
    public void cartWithTwoCopiesOfBookTwo() {
        cart.setCopiesOfBook2(2);
        Assert.assertEquals(calculateBillAmount(cart) , 16d);
    }

    @Test
    public void cartWithTwoCopiesOfBookThree() {
        cart.setCopiesOfBook3(2);
        Assert.assertEquals(calculateBillAmount(cart) , 16d);
    }

    @Test
    public void cartWithTwoCopiesOfBookFour() {
        cart.setCopiesOfBook4(2);
        Assert.assertEquals(calculateBillAmount(cart) , 16d);
    }

    @Test
    public void cartWithTwoCopiesOfBookFive() {
        cart.setCopiesOfBook5(2);
        Assert.assertEquals(calculateBillAmount(cart) , 16d);
    }

    @Test
    public void cartWithTwoDistinctBooks() {
        cart.setCopiesOfBook1(1);
        cart.setCopiesOfBook2(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8 * 2 * 0.95);
    }

    @Test
    public void cartWithThreeDistinctBooks() {
        cart.setCopiesOfBook1(1);
        cart.setCopiesOfBook3(1);
        cart.setCopiesOfBook5(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8 * 3 * 0.9);
    }

    @Test
    public void cartWithFourDistinctBooks() {
        cart.setCopiesOfBook1(1);
        cart.setCopiesOfBook2(1);
        cart.setCopiesOfBook3(1);
        cart.setCopiesOfBook5(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8 * 4 * 0.8);
    }

    @Test
    public void cartWithFiveDistinctBooks() {
        cart.setCopiesOfBook1(1);
        cart.setCopiesOfBook2(1);
        cart.setCopiesOfBook3(1);
        cart.setCopiesOfBook4(1);
        cart.setCopiesOfBook5(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8 * 5 * 0.75);
    }

    @Test
    public void cartWithTwoPlusOneBooks() {
        cart.setCopiesOfBook1(2);
        cart.setCopiesOfBook4(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8 + (8 * 2 * 0.95));
    }

    @Test
    public void cartWithTwoPlusTwoBooks() {
        cart.setCopiesOfBook2(2);
        cart.setCopiesOfBook5(2);
        Assert.assertEquals(calculateBillAmount(cart) , 2 * (8 * 2 * 0.95));
    }

    @Test // 2 1 2 1
    public void cartWithMixSet1() {
        cart.setCopiesOfBook1(2);
        cart.setCopiesOfBook2(1);
        cart.setCopiesOfBook3(2);
        cart.setCopiesOfBook4(1);
        Assert.assertEquals(calculateBillAmount(cart) , (8 * 4 * 0.8) + (8 * 2 * 0.95));
    }

    @Test // 1 2 1 1 1
    public void cartWithMixSet2() {
        cart.setCopiesOfBook1(1);
        cart.setCopiesOfBook2(2);
        cart.setCopiesOfBook3(1);
        cart.setCopiesOfBook4(1);
        cart.setCopiesOfBook5(1);
        Assert.assertEquals(calculateBillAmount(cart) , 8 + (8 * 5 * 0.75));
    }

    @Test // Edge case 1 -> 2 2 2 1 1
    public void cartWithMixSet3() {
        cart.setCopiesOfBook1(2);
        cart.setCopiesOfBook2(2);
        cart.setCopiesOfBook3(2);
        cart.setCopiesOfBook4(1);
        cart.setCopiesOfBook5(1);
        Assert.assertEquals(calculateBillAmount(cart) , 2 * (8 * 4 * 0.8));
    }

    @Test // Edge case 2 -> 5 5 4 4 4
    public void cartWithMixSet4() {
        cart.setCopiesOfBook1(5);
        cart.setCopiesOfBook2(5);
        cart.setCopiesOfBook3(4);
        cart.setCopiesOfBook4(4);
        cart.setCopiesOfBook5(4);
        Assert.assertEquals(calculateBillAmount(cart) , 4 * (8 * 5 * 0.75) + (8 * 2 * 0.95));
    }
}