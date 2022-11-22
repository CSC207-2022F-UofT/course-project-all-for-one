package main.java.use_case;


import main.java.presenter.ProfilePresenter;

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
