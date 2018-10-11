//Spencer Neveux
// Brooke Engelking
// Vending machine class to hold product objects and coin objects
// 10/9/18

import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Product> products;
    private ArrayList<Coin> coins;
    private ArrayList<Coin> coinPurchase;
    private double coinSum;

    /**
     * Null constructor
     */
    public VendingMachine() {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        coinPurchase = new ArrayList<>();
        coinSum = 0.0;
    }

    /**
     * Constructor to insert one product
     * @param product Product object
     */
    public VendingMachine(Product product) {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        coinPurchase = new ArrayList<>();
        products.add(product);
        coinSum = 0.0;
    }

    /**
     * Constructor to insert a list of product objects
     * @param listProduct Product arraylist
     */
    public VendingMachine(ArrayList<Product> listProduct) {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        coinPurchase = new ArrayList<>();
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
                    coins.addAll(coinPurchase);
                    products.remove(i);
                    coinPurchase.clear();
                    coinSum = 0;
                    return item;
                }
            }
        }
        return coinPurchase;
    }

    /**
     * Method to insert coins for purchase of item
     * @param coin Coin object
     */
    public void insertCoins(Coin coin) {
        coinPurchase.add(coin);
        coinSum += coin.getValue();
    }

    /**
     * Getter for coin sum
     * @return double value of coin sum
     */
    public double getCoinSum() {
        return coinSum;
    }

    /**
     * Method to get list of coins in vending machine
     * @return arraylist of coin objects
     */
    public ArrayList<Coin> getCoins() {
        return coins;
    }

    /**
     * Method to remove all coins from vending machine
     * @return Arraylist of coin objects
     */
    public ArrayList<Coin> removeCoins() {
        return coins;
    }

    @Override
    /**
     * Method to Override toString
     */
    public String toString() {
        String result = "";
        for (Product product : products) {
            result += product.getName() + " $" + product.getCost() + "\n";
        }
        return result;
    }
}
