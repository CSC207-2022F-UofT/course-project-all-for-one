package gateway;

import use_case.PurchaseRequestModel;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilePurchaseHistory {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<List<Order>, PurchaseRequestModel> orders = new HashMap<>();

    public PurchaseGateway(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("username", 0);
        headers.put("creation_time", 1);
        headers.put("product", 2);
        headers.put("price", 3);
        headers.put("name", 4);
        headers.put("address", 5);
        headers.put("phone_number", 6);
        headers.put("status", 7);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine();

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String creation_time = String.valueOf(col[headers.get("creation_time")]);
                String product = String.valueOf(col[headers.get("product")]);
                String price = String.valueOf(col[headers.get("price")]);
                String name = String.valueOf(col[headers.get("name")]);
                String address = String.valueOf(col[headers.get("address")]);
                String phone_number = String.valueOf(col[headers.get("phone_number")]);
                String status = String.valueOf(col[headers.get("status")]);
            }

            reader.close();
        }
    }

    public void save(PurchaseRequestModel requestModel) {
        orders.put(requestModel.getOrders(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (PurchaseRequestModel order : orders.values()) {
                String line = "%s,%s,%s".formatted(
                        order.getOrders());
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

}
