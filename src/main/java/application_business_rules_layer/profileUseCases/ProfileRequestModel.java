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

     /**
      *
      * @return the username
      */
     public String getUsername() {
          return username;
     }

     /**
      *
      * @return the age
      */
     public String getAge(){
          return age;
     }

     /**
      *
      * @return address
      */
     public String getAddress(){
          return address;
     }

     /**
      *
      * @return description
      */
     public String getDescription(){
          return description;
     }

     /**
      *
      * @return gender
      */
     public String getGender(){
          return gender;
     }

     /**
      *
      * @return phone
      */
     public String getPhone(){
          return phone;
     }

}
