package Entity;

public class Profile {
    private static int age;
    private static String username;
    private static String description;
    private static String address;
    private static String phone;

    public void setAge(int age){ this.age = age;}
    public void setUsername(String username){this.username = username;}
    public void setDescription(String description){this.description = description;}
    public void setAddress(String address){this.address = address;}
    public void setPhone(String phone){this.phone = phone;}

    public static int getAge(){return age;}
    public static String getUsername(){return username;}
    public static String getDescription(){return description;}
    public static String getAddress(){return address;}
    public static String getPhone(){return phone;}

}
