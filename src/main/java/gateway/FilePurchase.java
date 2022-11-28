package gateway;

import use_case.PurchaseRequestModel;
import java.io.*;
import java.util.*;

public class FilePurchase implements PurchaseGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, PurchaseRequestModel> accounts = new HashMap<>();

    public FilePurchase(String csvPath) throws IOException{

        csvFile = new File(csvPath);

        headers.put("username", 0);
        for (int i = 1; i < csvFile.length(); i++) {
            headers.put("creation_time" + i, i);

            if (csvFile.length() == 0) {
                save();
            } else {

                BufferedReader reader = new BufferedReader(new FileReader(csvFile));
                reader.readLine();

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    List<String> creation_times = new ArrayList<>();
                    creation_times.add(col[headers.get("creation_time" + i)]);
                    PurchaseRequestModel purchase = new PurchaseRequestModel(username, creation_times);
                    accounts.put(username, purchase);
                }

                reader.close();
            }
        }
    }

    @Override
    public void save(PurchaseRequestModel requestModel) {
        accounts.put(requestModel.getUsername(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (PurchaseRequestModel purchase : accounts.values()) {
                Long n = csvFile.length() - 1;
                String line = String.format("%s".repeat(n.intValue()), purchase.getCreationTimes());
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getCreationTimes(String username) {
        return accounts.get(username).getCreationTimes();
    }
}
