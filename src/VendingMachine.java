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

        // Testing addProduct
        VendingMachine vendingMachine2 = new VendingMachine();
        vendingMachine2.addProduct(soda);
        vendingMachine2.addProduct(candy);
        vendingMachine2.addProduct(chips);
        System.out.println("Vending machine with three products");
        System.out.println(vendingMachine2);

        // Testing addProducts
        VendingMachine vendingMachine6 = new VendingMachine();
        vendingMachine6.addProducts(sodaList);
        System.out.println("Vending machine with a list of sodas");
        System.out.println(vendingMachine6);

        // Testing insertCoin
        VendingMachine vendingMachine3 = new VendingMachine();
        vendingMachine3.insertCoins(penny);
        vendingMachine3.insertCoins(quarter);
        System.out.println("Inserting a penny and a quarter.");
        System.out.println("The sum should be equal to 26 cents");
        System.out.println(vendingMachine3.getCoinSum());
        System.out.println();

        // Testing valid purchase
        VendingMachine vendingMachine4 = new VendingMachine(candyList);
        System.out.println("Initially the vending machine has\n" + vendingMachine4);
        vendingMachine4.insertCoins(quarter);
        vendingMachine4.insertCoins(quarter);
        vendingMachine4.insertCoins(quarter);
        vendingMachine4.insertCoins(quarter);
        System.out.println("Purchasing a candy");
        System.out.println("Now I have a candy and the vending machine has one less candy");
        Object myCandyBar = vendingMachine4.purchase("Candy");
        System.out.println(vendingMachine4);

        // Testing invalid purchase
        VendingMachine vendingMachine5 = new VendingMachine(candyList);
        System.out.println("Testing an invalid purchase");
        System.out.println("Trying to buy a candy with only 1 quarter. Should return a quarter");
        vendingMachine5.insertCoins(quarter);
        System.out.println("This is the change I inserted " + vendingMachine5.purchase("Candy"));
        System.out.println();

        // Walkthrough
        VendingMachine vm = new VendingMachine();
        vm.addProducts(candyList);
        vm.addProducts(sodaList);
        vm.addProducts(chipList);
        System.out.println("Creating a vending machine with three products");
        System.out.println(vm);
        System.out.println();
        System.out.println("Inserting 4 quarters and purchasing chips");
        vm.insertCoins(quarter);
        vm.insertCoins(quarter);
        vm.insertCoins(quarter);
        vm.insertCoins(quarter);
        vm.purchase("Chips");
        System.out.println("Now chips should have a total of 4");
        System.out.println(vm);
        System.out.println();
        System.out.println("The total coins in the vending machine are " + vm.getCoins());
        System.out.println("Now I am removing all the coins" + vm.removeCoins());
        System.out.println("Now I am adding a single bag of chips back in");
        vm.addProduct(chips);
        System.out.println();
        System.out.println(vm);


    }

}
