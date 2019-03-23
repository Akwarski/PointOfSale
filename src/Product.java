public class Product extends Abstract {

    private String name;
    private double price;

    Product(String n, double p){
        this.name = n;
        this.price = p;
    }

    @Override
    public String retName() {
        return name;
    }

    @Override
    public double retPrice() {
        return price;
    }
}
