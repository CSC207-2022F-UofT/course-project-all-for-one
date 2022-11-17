package entity;

public class PhysicalPost implements Post {

    private final String number;

    PhysicalPost(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {return number;}
}
