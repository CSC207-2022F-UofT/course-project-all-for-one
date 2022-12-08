package application_business_rules_layer;

import application_business_rules_layer.profileUseCases.ProfileGateway;
import application_business_rules_layer.profileUseCases.ProfileRequestModel;
import framworks_drivers_layer.dataAccess.MemoryProfile;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProfileGatewaytest {
    @Test
    public void profileTest() {
        ProfileGateway profileGateway = new MemoryProfile();
        ProfileRequestModel profileRequestModel1 = new ProfileRequestModel("steve", "123456", "male", "889 bay", "suck","4379923239");
        ProfileRequestModel prfileRequestModel2 = new ProfileRequestModel("collin", "654321", "male", "chestnut","human", "332472693");
        profileGateway.save(profileRequestModel1);
        profileGateway.save(prfileRequestModel2);


        Assertions.assertEquals("steve", profileGateway.getUsername("steve"));
        Assertions.assertEquals("123456", profileGateway.getAge("steve"));
        Assertions.assertEquals("suck", profileGateway.getDescription("steve"));
        Assertions.assertEquals("chestnut", profileGateway.getAddress("collin"));
        Assertions.assertEquals("male", profileGateway.getGender("collin"));
        Assertions.assertEquals("332472693", profileGateway.getPhone("collin"));

}

}
