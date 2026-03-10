import java.util.*;

public class FlashSaleInventory {

    HashMap<String, Integer> stock = new HashMap<>();
    LinkedList<Integer> waitingList = new LinkedList<>();

    public void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
    }

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public synchronized String purchaseItem(String productId, int userId) {

        int currentStock = stock.getOrDefault(productId, 0);

        if (currentStock > 0) {
            stock.put(productId, currentStock - 1);
            return "Purchase Successful. Remaining: " + (currentStock - 1);
        } else {
            waitingList.add(userId);
            return "Added to waiting list. Position: " + waitingList.size();
        }
    }

    public static void main(String[] args) {

        FlashSaleInventory system = new FlashSaleInventory();

        system.addProduct("IPHONE15", 2);

        System.out.println(system.purchaseItem("IPHONE15", 101));
        System.out.println(system.purchaseItem("IPHONE15", 102));
        System.out.println(system.purchaseItem("IPHONE15", 103));
    }
}