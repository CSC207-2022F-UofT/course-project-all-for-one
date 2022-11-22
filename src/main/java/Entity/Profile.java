package main.java.Entity;

import java.util.ArrayList;

public class Profile {
    private static String age;
    private static String username;
    private static String description;
    private static String address;
    private static String phone;

    static ArrayList<String> profile = new ArrayList<String>();
    public Profile(){
        profile.add(age);
        profile.add(username);
        profile.add(description);
        profile.add(address);
        profile.add(phone);
    }


   // public void setAge(String age){ this.age = age;}
    //public void setUsername(String username){this.username = username;}
    //public void setDescription(String description){this.description = description;}
    //public void setAddress(String address){this.address = address;}
   // public void setPhone(String phone){this.phone = phone;}

    //public void setProfile(ArrayList<String> profile){this.profile = profile;}

    public static String getAge(){return age;}
    public static String getUsername(){return username;}
    public static String getDescription(){return description;}
    public static String getAddress(){return address;}
    public static String getPhone(){return phone;}

    public static ArrayList<String> getProfile(){return profile;}

}



