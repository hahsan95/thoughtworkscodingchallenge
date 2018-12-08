import java.util.HashMap;
import java.util.ArrayList;

public class ShoppingCart {
  public ShoppingCart() {

  }

  static class Item {
    int quantity;
    String name;
    float price;
    boolean exempt;
    boolean imported;

    public Item(int quantity, String name, float price, boolean exempt, boolean imported) {
      this.quantity = quantity;
      this.name = name;
      this.price = price;
      this.exempt = exempt;
      this.imported = imported;
    }
  }

  static class Cart {
    ArrayList<Item> currentCart = new ArrayList<Item>();
    public void addItem(int quantity, String name, float price, boolean exempt, boolean imported) {
      Item newItem = new Item(quantity, name, price, exempt, imported);
      currentCart.add(newItem);
    }
  }


  public static void main(String[] args){

    Cart cart1 = new Cart();
    cart1.addItem(1, "book", 12.49F, true, false);
    cart1.addItem(1, "book", 12.49F, true, false);
    cart1.addItem(1, "book", 12.49F, true, false);

    Cart cart2 = new Cart();
    cart2.addItem(1, "book", 12.49F, true, false);
    cart2.addItem(1, "book", 12.49F, true, false);

    Cart cart3 = new Cart();
    cart3.addItem(1, "book", 12.49F, true, false);
    cart3.addItem(1, "book", 12.49F, true, false);
    cart3.addItem(1, "book", 12.49F, true, false);
    cart3.addItem(1, "book", 12.49F, true, false);
    System.out.println(cart1.currentCart.get(0).name);
  }
}
