package application_business_rules_layer.profileUseCases;


public class ProfileRequestModel {

     private String age;
     private String username;
     private String address;
     private String description;
     private String phone;


     private String gender;

     public ProfileRequestModel(String username,String age, String gender, String address, String description, String phone) {
          this.age = age;
          this.username = username;
          this.address = address;
          this.description = description;
          this.phone = phone;
          this.gender = gender;

     }
     public void setAge(String age){ this.age = age;}
     public void setUsername(String username){this.username = username;}
     public void setDescription(String description){this.description = description;}
     public void setAddress(String address){this.address = address;}
     public void setPhone(String phone){this.phone = phone;}

     public void setGender(String gender) { this.gender = gender;}

     public String getUsername() {
          return username;
     }

     public String getAge(){
          return age;
     }

     public String getAddress(){
          return address;
     }
     public String getDescription(){
          return description;
     }
     public String getGender(){
          return gender;
     }
     public String getPhone(){
          return phone;
     }
}
