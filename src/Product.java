public class Product {
    private String name;
    private double cost;

    public Product() {
        name = "";
        cost = 0.0;
    }

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name + " " + cost;
    }

}
