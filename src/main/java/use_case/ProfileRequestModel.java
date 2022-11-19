package main.java.use_case;

//package use_case;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//import Entity.Profile;

public class ProfileRequestModel {

     private String age;
     private String username;
     private String address;
     private String description;
     private String phone;
     

     public ProfileRequestModel(int age, String address, String username, String description, String phone) {
          this.age = Integer.toString(age);
          this.username = username;
          this.address = address;
          this.description = description;
          this.phone = phone;

     }
     public void setAge(String age){ this.age = age;}
     public void setUsername(String username){this.username = username;}
     public void setDescription(String description){this.description = description;}
     public void setAddress(String address){this.address = address;}
     public void setPhone(String phone){this.phone = phone;}
}
