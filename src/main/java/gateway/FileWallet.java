package gateway;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import use_case.WalletRequestModel;

public class FileWallet implements WalletGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, WalletRequestModel> accounts = new HashMap<>();

    public FileWallet(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("username", 0);
        headers.put("balance", 1);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine();

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                double balance = Double.valueOf(col[headers.get("balance")]);
                WalletRequestModel wallet = new WalletRequestModel(username, balance);
                accounts.put(username, wallet);
            }

            reader.close();
        }
    }

    @Override
    public void save(WalletRequestModel requestModel) {
        accounts.put(String.valueOf(requestModel.getBalance()), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (WalletRequestModel wallet : accounts.values()) {
                String line = String.format("%s", wallet.getBalance());
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getBalance(String username) {
        return accounts.get(username).getBalance();
    }
}
