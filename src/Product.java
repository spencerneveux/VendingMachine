public class Product {
    private String name;
    private double cost;

    /**
     * Null Constructor
     */
    public Product() {
        name = "";
        cost = 0.0;
    }

    /**
     * Overloaded constructor
     * @param name String name of product
     * @param cost double cost of product
     */
    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Getter for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name Sets name to name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for cost
     * @return double value cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Setter for cost
     * @param cost double cost value
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Overriding toString method
     * @return String of product
     */
    @Override
    public String toString() {
        return name + " " + cost;
    }

}
