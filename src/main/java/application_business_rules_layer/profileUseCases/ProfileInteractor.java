package application_business_rules_layer.profileUseCases;


import Interface_adapters_layer.presenter.ProfilePresenter;

public class ProfileInteractor implements  ProfileInputBoundary{

    final ProfilePresenter  profilePresenter;



    public ProfileInteractor(ProfilePresenter profilePresenter) {
        this.profilePresenter = profilePresenter;
    }


    @Override
    public ProfileResponseModel create(ProfileRequestModel requestModel) {
        return null;

    }
}
