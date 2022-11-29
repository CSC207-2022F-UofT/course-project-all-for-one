package application_business_rules_layer.profileUseCases;


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
