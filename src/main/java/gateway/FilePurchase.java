package gateway;

import use_case.PurchaseRequestModel;
import java.io.*;
import java.util.*;

public class FilePurchase implements PurchaseGateway {

    private final File csvFile;

    private final Map<String, PurchaseRequestModel> accounts = new HashMap<>();

    public FilePurchase(String csvPath) throws IOException{

        csvFile = new File(csvPath);


        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine();

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            String username = String.valueOf(col[0]);
            List<String> creation_times = new ArrayList<>();
            for (int i = 1; i < col.length; i++ ){
                creation_times.add(col[i]);
            }
            PurchaseRequestModel purchase = new PurchaseRequestModel(username, creation_times);
            accounts.put(username, purchase);
        }

        reader.close();


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

            for (PurchaseRequestModel purchase : accounts.values()) {
                String line = "";
                line += purchase.getUsername();
                for (String creationTime: purchase.getCreationTimes()){
                    line += "," + creationTime ;
                }
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
