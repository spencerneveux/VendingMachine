public class Coin {
    private String name;
    private double value;

    public Coin() {
        name = "";
        value = 0.0;
    }

    public Coin(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + " " + value;
    }
}
