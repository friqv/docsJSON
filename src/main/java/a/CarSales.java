package a;

public class CarSales {

    int id;
    String first_name;
    String last_name;
    String car;
    double price;
    String state;

    public CarSales(int id, String first_name, String last_name, String car, double price, String state) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.car = car;
        this.price = price;
        this.state = state;
    }

    @Override
    public String toString() {
        return "carSales{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", car='" + car + '\'' +
                ", price=" + price +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
