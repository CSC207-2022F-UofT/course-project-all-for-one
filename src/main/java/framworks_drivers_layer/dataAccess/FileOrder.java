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

        headers.put("Title", 0);
        headers.put("CreationTime", 1);
        headers.put("Price", 2);
        headers.put("Name", 3);
        headers.put("Address", 4);
        headers.put("PhoneNumber", 5);
        headers.put("ShipmentStatus", 6);
        headers.put("BuyerUsername", 7);
        headers.put("SellerUsername", 8);



        if (csvFile.length() == 0) {
            save();
        } else {

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
//                LocalDateTime creationTime = LocalDateTime.parse(creationTimeString);
                OrderDsRequestModel order = new OrderDsRequestModel(title, creationTimeString, price, name, address,
                        phoneNumber, shipmentStatus, buyerUsername, sellerUsername);
                orders.put(buyerUsername, order);
            }

            reader.close();
        }
    }

    @Override
    public void save(OrderDsRequestModel requestModel) {
        orders.put(String.valueOf(requestModel.hashCode()), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (OrderDsRequestModel order : orders.values()) {
                String line = "" + order.getTitle() + "," + order.getCreationTime() + "," + order.getPrice() + "," +
                        order.getName() + "," + order.getAddress() + "," + order.getPhoneNumber() + "," +
                        order.getShipmentStatus() + "," + order.getBuyerUsername() + "," + order.getSellerUsername();
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}




