public class Coin {
    private String name;
    private double value;

    /**
     * Null Constructor
     */
    public Coin() {
        name = "";
        value = 0.0;
    }

    /**
     * Overloaded constructor
     * @param name string for name of coin
     * @param value double value for coin
     */
    public Coin(String name, double value) {
        this.name = name;
        this.value = value;
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
     * @param name string name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for value
     * @return double value of coin
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter for value
     * @param value double value for coin
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Overriding toString method
     * @return string
     */
    @Override
    public String toString() {
        return name + " " + value;
    }
}
