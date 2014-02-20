package edu.cmu.sv.katas.potter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by Surya Kiran on 2/19/14.
 */
public class PotterKata {

    public static void main(String[] args) {
        PotterKata kata = new PotterKata();
        ShoppingCart cart = kata.readShoppingCartFromUser();

        long startTime = new Date().getTime();
        BillCalculator billCalculator = new BillCalculator(cart);
        double billAmount = billCalculator.getBillAmount();
        long endTime = new Date().getTime();
        System.out.println("\n\nAnd your bill amount is: " + billAmount + " EUR");

        System.out.println("Time taken to calculate = " + (endTime - startTime));
    }

    /**
     * Method to read shopping cart info from command line.
     *
     * @return ShoppingCart information
     */
    public ShoppingCart readShoppingCartFromUser() {
        ShoppingCart cart = new ShoppingCart();

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("************Welcome to the billing desk!!!************");
            System.out.println("Note: Please enter the number of copies of each book you have in your shopping cart when prompted.");
            System.out.println("Note: Only positive numbers like 1, 2, 3 etc. are accepted.");

            System.out.print("Copies of the first book: ");
            String userInput = console.readLine();
            cart.setCopiesOfBook1(Integer.parseInt(userInput));

            System.out.print("Copies of the second book: ");
            userInput = console.readLine();
            cart.setCopiesOfBook2(Integer.parseInt(userInput));

            System.out.print("Copies of the third book: ");
            userInput = console.readLine();
            cart.setCopiesOfBook3(Integer.parseInt(userInput));

            System.out.print("Copies of the fourth book: ");
            userInput = console.readLine();
            cart.setCopiesOfBook4(Integer.parseInt(userInput));

            System.out.print("Copies of the fifth book: ");
            userInput = console.readLine();
            cart.setCopiesOfBook5(Integer.parseInt(userInput));
        } catch (IOException e) {
            e.printStackTrace();
        } catch(NumberFormatException e) {
            System.out.println("*** ERROR: Only numeric values like 1, 2, 3 etc. are accepted.");
            System.out.println("Exiting the program now.");
            System.exit(1);
        }

        return cart;
    }
}
