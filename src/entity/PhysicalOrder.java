package entity;

public class PhysicalOrder implements Order {

    private final String number;

    PhysicalOrder(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {return number;}
}
