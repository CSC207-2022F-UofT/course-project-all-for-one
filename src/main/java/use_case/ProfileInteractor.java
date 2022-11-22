package use_case;


import presenter.ProfilePresenter;

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
