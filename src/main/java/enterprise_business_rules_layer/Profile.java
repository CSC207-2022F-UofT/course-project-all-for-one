package enterprise_business_rules_layer;


public class Profile {
    private static String age;
    private static String username;
    private static String description;
    private static String address;

    private static String phone;

    private static String gender;
    public Profile(String age, String username, String gender, String description, String phone, String address){
        this.age = age;
        this.username = username;
        this.gender = gender;
        this.description = description;
        this.phone = phone;
        this.address = address;
    }



    public static String getAge(){return age;}
    public static String getUsername(){return username;}
    public static String getDescription(){return description;}
    public static String getAddress(){return address;}
    public static String getPhone(){return phone;}

    public static String getGender(){return gender;}



}



