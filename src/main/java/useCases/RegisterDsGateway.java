package useCases;

public interface RegisterDsGateway {
    boolean isExistedName(String username);

    void save(RegisterDsRequestModel requestModel);
}
