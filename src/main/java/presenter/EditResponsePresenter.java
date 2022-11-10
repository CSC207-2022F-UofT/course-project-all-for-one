package presenter;

import Entity.Profile;

public class EditResponsePresenter {
    int age = Profile.getAge();
    String username = Profile.getUsername();
    String description = Profile.getDescription();
    String Address = Profile.getAddress();
    String phone = Profile.getPhone();


}
