package entity;

public class PhysicalOrderFactory implements OrderFactory {

    @Override
    public Order create(String number) {return new PhysicalOrder(number);}
}
