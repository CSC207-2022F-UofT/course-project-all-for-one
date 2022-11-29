package application_business_rules_layer.profileUseCases;

public interface ProfileInputBoundary {
    ProfileResponseModel create(ProfileRequestModel requestModel);
}
