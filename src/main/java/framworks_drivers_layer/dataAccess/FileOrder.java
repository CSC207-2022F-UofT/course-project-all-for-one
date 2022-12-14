package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.tradeUseCases.OrderDsRequestModel;

import java.io.*;
import java.util.*;

public class FileOrder implements OrderDsGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, OrderDsRequestModel> orders = new HashMap<>();

    public FileOrder(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        // construct the headers of the csv file
        headers.put("Title", 0);
        headers.put("CreationTime", 1);
        headers.put("Price", 2);
        headers.put("Name", 3);
        headers.put("Address", 4);
        headers.put("PhoneNumber", 5);
        headers.put("ShipmentStatus", 6);
        headers.put("BuyerUsername", 7);
        headers.put("SellerUsername", 8);
        headers.put("Tags", 9);
        headers.put("ID", 10);

        // determine if the csv file is empty
        if (csvFile.length() == 0) {
            save();
        }

        // read the csv and put all data into a map
        else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");

                String title = String.valueOf(col[headers.get("Title")]);
                String creationTimeString = String.valueOf(col[headers.get("CreationTime")]);
                double price = Double.parseDouble(col[headers.get("Price")]);
                String name = String.valueOf(col[headers.get("Name")]);
                String address = String.valueOf(col[headers.get("Address")]);
                String phoneNumber = String.valueOf(col[headers.get("PhoneNumber")]);
                String shipmentStatus = String.valueOf(col[headers.get("ShipmentStatus")]);
                String buyerUsername = String.valueOf(col[headers.get("BuyerUsername")]);
                String sellerUsername = String.valueOf(col[headers.get("SellerUsername")]);
                ArrayList<String> tags = new ArrayList<>(Arrays.asList(String.valueOf(col[headers.get("Tags")]).split(":")));
//                LocalDateTime creationTime = LocalDateTime.parse(creationTimeString);
                String id = String.valueOf(col[headers.get("ID")]);
                OrderDsRequestModel order = new OrderDsRequestModel(title, creationTimeString, price, name, address,
                        phoneNumber, shipmentStatus, buyerUsername, sellerUsername, tags, id);
                orders.put(order.getId(), order);
            }

            reader.close();
        }
    }

    /**
     *
     * @param requestModel the order data to save
     */
    @Override
    public void save(OrderDsRequestModel requestModel) {
        orders.put(String.valueOf(requestModel.hashCode()), requestModel);
        this.save();
    }

    /**
     * write the data of the map created above to the csv file
     */
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (OrderDsRequestModel order : orders.values()) {
                String tags = order.getTags().toString();
                tags = tags.replace("[","").
                        replace("]","").replace(" ","").
                        replace(",",":");
                String line = "" + order.getTitle() + "," + order.getCreationTime() + "," + order.getPrice() + "," +
                        order.getName() + "," + order.getAddress() + "," + order.getPhoneNumber() + "," +
                        order.getShipmentStatus() + "," + order.getBuyerUsername() + "," +
                        order.getSellerUsername() + "," + tags + "," + order.getId();
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param username username of the user that is acting
     * @return a list of tags
     */
    public List<String> getPurchaseHistoryTagsData(String username){
        List<String> tags = new ArrayList<>();
        for(OrderDsRequestModel orderDsRequestModel: orders.values()){
            if(username.equals(orderDsRequestModel.getBuyerUsername())){
                tags.addAll(orderDsRequestModel.getTags());
            }
        }
        return tags;
    }

    /**
     *
     * @param username the username to get the purchase history
     * @return a list of OrderDsRequestModel object
     */
    public List<OrderDsRequestModel> getPurchaseHistory(String username) {
        List<OrderDsRequestModel> purchaseHistory = new ArrayList<>();
        for(OrderDsRequestModel order : orders.values()) {
            if(username.equals(order.getBuyerUsername()) || username.equals(order.getSellerUsername())) {
                purchaseHistory.add(order);
            }
        }
        return purchaseHistory;
    }
}




