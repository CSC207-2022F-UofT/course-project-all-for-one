package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.userUseCases.UserDsGateway;
import application_business_rules_layer.userUseCases.UserRegisterDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUser implements UserDsGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, UserRegisterDsRequestModel> accounts = new HashMap<>();

    public FileUser(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("creation_time", 2);
        headers.put("balance", 3);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String password = String.valueOf(col[headers.get("password")]);
                String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                double balance = Double.parseDouble(col[headers.get("balance")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                UserRegisterDsRequestModel user = new UserRegisterDsRequestModel(username, password, ldt, balance);
                accounts.put(username, user);
            }

            reader.close();

        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(UserRegisterDsRequestModel requestModel) {
        accounts.put(requestModel.getName(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (UserRegisterDsRequestModel user : accounts.values()) {
                String line = "" + user.getName() + "," + user.getPassword() + "," + user.getCreationTime() + ","
                        + user.getWalletBalance();
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public boolean isPasswordCorrect (String username, String password) {
        return accounts.get(username).getPassword().equals(password);
    }

    @Override
    public String getPassword(String username) {
        return accounts.get(username).getPassword();
    }

    @Override
    public double getBalance(String username) {
        return accounts.get(username).getWalletBalance();
    }

}
