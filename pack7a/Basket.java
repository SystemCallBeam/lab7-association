package pack7a;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket implements Iterable<LineItem> {
    private ArrayList<LineItem> items = new ArrayList<>();

    public void showItemsInBasket() {
        System.out.println("This basket contains");
        for (LineItem item : items) {
            System.out.println(item);
        }
    }

    public void putInBasket(LineItem item) {
        items.add(item);
    }

    public void printInvoice() {
        int sum = 0;
        System.out.println("invoice header");
        for (LineItem line : items) {
            System.out.println(line.getProduct().getpName() + " x " + line.getQuantity() + " " + line.calculateAmount());
            sum += line.calculateAmount();
        }
        System.out.println("Total is " + sum + "******");
    }

    public void buyNow(LineItem item) {
        putInBasket(item);
        printInvoice();
    }

    @Override
    public Iterator<LineItem> iterator() {
        return items.iterator();
    }
}
