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
    cart1.addItem(1, "music CD", 14.99F, false, false);
    cart1.addItem(1, "chocolate bar", 0.85F, true, false);

    Cart cart2 = new Cart();
    cart2.addItem(1, "box of chocolates", 10.00F, true, true);
    cart2.addItem(1, "bottle of perfume", 47.50F, false, true);

    Cart cart3 = new Cart();
    cart3.addItem(1, "bottle of perfume", 27.99F, false, true);
    cart3.addItem(1, "bottle of perfume", 18.99F, false, false);
    cart3.addItem(1, "packet of headache pills", 9.75F, true, false);
    cart3.addItem(1, "box of chocolates", 11.25F, true, true);
    System.out.println(cart1.currentCart.get(0).name);
  }
}
