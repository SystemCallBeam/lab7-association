package pack7a;

import java.util.ArrayList;

public class Shop {
    private String name;
    private Catalog catalog = new Catalog();
    private ArrayList<Basket> ordersToday = new ArrayList<>();

    public Shop(String n) {
        name = n;
        catalog.add(new Drink("mix veggies", "refreshing"), 22);
        catalog.add(new Drink("lactasoy", "less hungry"), 15);
        catalog.add(new Noodles("mama", "classic"), 9);
        catalog.add(new Noodles("korean", "i can afford"), 33);
        // duplicate won't update
        catalog.add(new Noodles("mama", "duplicate"), 11);
        showCatalog();
    }

    private void showCatalog() {
        System.out.println("Welcome to " + name);
        catalog.showCatalog();
    }

    public Basket newCustomerArrives() {
        return new Basket();
    }

    public LineItem generateLineItem(String pName, int q) { // add to UML
        return new LineItem(catalog.getProduct(pName), q, catalog.getPrice(pName));
    }

    public LineItem generateBuyNowItem(String pName) {
        Basket basket = new Basket();
        basket.putInBasket(generateLineItem(pName, 1));
        ordersToday.add(basket);
        return generateLineItem(pName, 1);
    }

    public void getPayment(Basket basket) {
        System.out.println("I am cashier");
        basket.printInvoice();
        ordersToday.add(basket);
    }

    public void dailySalesReport() {
        int dailyTotal = 0;
        System.out.println("Today's sales: ");
        for (Basket basket : ordersToday) {
            basket.showItemsInBasket();
            int basketTotal = 0;
            for (LineItem lineItem : basket) {
                basketTotal += lineItem.calculateAmount();
            }
            dailyTotal += basketTotal;
            System.out.println("Total: " + basketTotal);
        }
        System.out.println("Today's Total: " + dailyTotal);
    }

}
