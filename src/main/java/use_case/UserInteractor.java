package use_case;

import Entity.UserFactory;
import gateway.UserDsGateway;
import presenter.UserPresenter;

public class UserInteractor implements UserInputBoundary{
    final UserDsGateway userDsGateway;

    final UserPresenter userPresenter;

    final UserFactory userFactory;


    public UserInteractor(UserDsGateway userDsGateway, UserPresenter userPresenter, UserFactory userFactory){
        this.userDsGateway = userDsGateway;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public UserResponseModel create(UserRequestModel requestmodel) {
        return null;
    }
}
