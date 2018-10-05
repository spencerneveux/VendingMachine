import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Product> products;
    private ArrayList<Coin> coins;
    private double coinSum;

    /**
     * Null constructor
     */
    public VendingMachine() {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        coinSum = 0.0;
    }

    /**
     * Constructor to insert one product
     * @param product Product object
     */
    public VendingMachine(Product product) {
        products = new ArrayList<>();
        products.add(product);
        coinSum = 0.0;
    }

    /**
     * Constructor to insert a list of product objects and a list of coin objects
     * @param listProduct Product arraylist
     */
    public VendingMachine(ArrayList<Product> listProduct) {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        products.addAll(listProduct);
        coinSum = 0.0;
    }

    /**
     * Method to add individual product to the arraylist of available products
     * @param product Product object
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Method to add a list of products
     * @param productList ArrayList of product objects
     */
    public void addProducts(ArrayList<Product> productList) {
        products.addAll(productList);
    }

    /**
     * Method to buy a product. If none available return coins.
     * @param product Product object representing desired product
     */
    public Object purchase(String product) {
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            if (item.getName().equals(product)) {
                if (coinSum >= item.getCost()) {
                    products.remove(i);
                    return item;
                }
            }
        }
        return coins;
    }

    /**
     * Method to insert coins for purchase of item
     * @param coin Coin object
     */
    public void insertCoins(Coin coin) {
        coins.add(coin);
        coinSum += coin.getValue();
    }

    /**
     * Getter for coin sum
     * @return double value of coin sum
     */
    public double getCoinSum() {
        return coinSum;
    }

    @Override
    public String toString() {
        String result = "";
        for (Product product : products) {
            result += product.getName() + " " + product.getCost() + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        // Creating products
        Product soda = new Product("Soda", 1.99);
        Product candy = new Product("Candy", .99);
        Product chips = new Product("Chips", 1);

        // Creating Coins
        Coin penny = new Coin("Penny", 0.01);
        Coin nickel = new Coin("Nickel", 0.05);
        Coin dime = new Coin("Dime", 0.1);
        Coin quarter = new Coin("Quarter", 0.25);

        // Creating a list of sodas/candy/chips
        ArrayList<Product> sodaList = new ArrayList<>();
        ArrayList<Product> candyList = new ArrayList<>();
        ArrayList<Product> chipList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            sodaList.add(soda);
            candyList.add(candy);
            chipList.add(chips);
        }

        // Testing null constructor
        VendingMachine vendingMachine1 = new VendingMachine();
        System.out.println(vendingMachine1);
        System.out.println();

        // Testing addProducts
        VendingMachine vendingMachine2 = new VendingMachine();
        vendingMachine2.addProducts(sodaList);
        vendingMachine2.addProducts(candyList);
        vendingMachine2.addProducts(chipList);
        System.out.println(vendingMachine2);

        // Testing insertCoin
        VendingMachine vendingMachine3 = new VendingMachine();
        vendingMachine3.insertCoins(penny);
        vendingMachine3.insertCoins(quarter);
        System.out.println(vendingMachine3.getCoinSum());

        // Testing valid purchase
        VendingMachine vendingMachine4 = new VendingMachine(candyList);
        vendingMachine4.insertCoins(quarter);
        vendingMachine4.insertCoins(quarter);
        vendingMachine4.insertCoins(quarter);
        vendingMachine4.insertCoins(quarter);
        System.out.println(vendingMachine4.purchase("Candy"));

        // Testing invalid purchase
        VendingMachine vendingMachine5 = new VendingMachine(candyList);
        vendingMachine5.insertCoins(quarter);
        System.out.println(vendingMachine5.purchase("Candy"));

        

    }

}
