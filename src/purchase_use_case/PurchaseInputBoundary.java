package purchase_use_case;

public interface PurchaseInputBoundary {
    PurchaseResponseModel create(PurchaseRequestModel requestModel);
}
